package com.akos.sphero.common;

import com.akos.bluetooth.heartbeat.Heartbeat;
import com.akos.sphero.commands.*;
import com.akos.sphero.common.internal.*;

import javax.microedition.io.StreamConnection;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import static com.akos.sphero.common.internal.ids.SOP.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class Channel {

    public static final int CORE_POOL_SIZE = 2;
    private final StreamConnection connection;
    private final ResponseFactory responseFactory;
    private final AsyncMessageFactory asyncMessageFactory;

    private BlockingQueue<DeviceResponse> incomingQueue = new LinkedBlockingQueue<>();
    private BlockingQueue<DeviceCommand> outgoingQueue = new LinkedBlockingQueue<>();
    private Map<Byte, DeviceCommand> sentCommands = new HashMap<>();

    private final InboundProcessor inboundProcessor = new InboundProcessor(incomingQueue);
    private final OutboundProcessor outboundProcessor = new OutboundProcessor();

    private final ExecutorService executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
    private Heartbeat heartbeat = null;

    public Channel(StreamConnection connection, Heartbeat heartbeat) {
        this.connection = connection;
        this.heartbeat = heartbeat;
        this.responseFactory = ResponseFactory.getInstance();
        this.asyncMessageFactory = AsyncMessageFactory.getInstance();
    }

    public void send(DeviceCommand command) {
        try {
            outgoingQueue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<DeviceResponse> receiveAll() {
        ArrayList<DeviceResponse> allQueuedResponses = new ArrayList<>();
        incomingQueue.drainTo(allQueuedResponses);
        return allQueuedResponses;
    }

    public DeviceResponse receive() {
        DeviceResponse response = null;
        try {
            while (response == null && inboundProcessor.isRunning()) {
                response = incomingQueue.poll(1, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    public int numberOfQueuedResponses() {
        return incomingQueue.size();
    }

    public void open() throws IOException {
        inboundProcessor.deviceResponseStream = connection.openDataInputStream();
        outboundProcessor.deviceCommandStream = connection.openDataOutputStream();
        if (!executorService.isShutdown()) {
            executorService.execute(inboundProcessor);
            executorService.execute(outboundProcessor);
        }
    }

    public void close() throws IOException {
        executorService.shutdownNow();
        outboundProcessor.close();
        inboundProcessor.close();
    }


    private class InboundProcessor extends Processor {

        private BlockingQueue<DeviceResponse> incomingQueue;
        private DataInputStream deviceResponseStream = null;

        public InboundProcessor(BlockingQueue<DeviceResponse> incomingQueue) {
            this.incomingQueue = incomingQueue;
        }

        @Override
        public void run() {
            this.running = true;
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    ByteArrayOutputStream incomingByteStream = new ByteArrayOutputStream();

                    incomingByteStream.write(readNextByte());
                    byte SOP2 = readNextByte();
                    incomingByteStream.write(SOP2);

                    int lengthOfData = 0;
                    boolean isAsync = false;
                    if (SOP2 == DEFAULT.getValue()) {
                        incomingByteStream.write(readNextByte());
                        incomingByteStream.write(readNextByte());
                        lengthOfData = readNextByte();
                        incomingByteStream.write(lengthOfData);
                    } else if (SOP2 == ASYNC.getValue()) {
                        isAsync = true;
                        incomingByteStream.write(readNextByte());
                        byte DLEN_MSB = readNextByte();
                        incomingByteStream.write(DLEN_MSB);
                        byte DLEN_LSB = readNextByte();
                        incomingByteStream.write(DLEN_LSB);
                        lengthOfData = (DLEN_MSB << 8) | (DLEN_LSB);
                    }
                    for (int i = 0; i < (lengthOfData - 1); i++) {
                        incomingByteStream.write(readNextByte());
                    }
                    incomingByteStream.write(readNextByte());
                    DeviceResponse packet = null;
                    if (isAsync) {
                        packet = asyncMessageFactory.dataFromPacket(incomingByteStream.toByteArray());
                    } else {
                        DeviceCommand command = sentCommands.remove(incomingByteStream.toByteArray()[3]);
                        packet = responseFactory.responseFromRawPacket(incomingByteStream.toByteArray(), command);
                    }
                    System.out.printf("Response => %s : %s%n", packet, packet.getSequenceNumber());
                    this.incomingQueue.put(packet);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                heartbeat.kill();
                this.running = false;
            }

        }

        public byte readNextByte() {
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return deviceResponseStream.readByte();
                    } catch (IOException e) {
                        interrupted = true;
                    }
                }
            } finally {
                if (interrupted)
                    Thread.currentThread().interrupt();
            }
        }

        public void close() throws IOException {
            deviceResponseStream.close();
        }
    }

    private class OutboundProcessor extends Processor {

        private DataOutputStream deviceCommandStream = null;

        @Override
        public void run() {
            this.running = true;
            try {
                while (!executorService.isShutdown()) {
                    DeviceCommand message = getNextTask(outgoingQueue);
                    deviceCommandStream.write(message.getPacket());
                    deviceCommandStream.flush();
                    sentCommands.put(message.getSequenceNumber(), message);
                    System.out.printf("Command => %s : %s%n", message, message.getSequenceNumber());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                heartbeat.kill();
                this.running = false;
            }
        }

        public DeviceCommand getNextTask(BlockingQueue<DeviceCommand> queue) {
            boolean interrupted = false;
            try {
                while (true) {
                    try {
                        return queue.take();
                    } catch (InterruptedException e) {
                        interrupted = true;
                    }
                }
            } finally {
                if (interrupted)
                    Thread.currentThread().interrupt();
            }
        }

        public void close() throws IOException {
            deviceCommandStream.close();
        }
    }

}
