package com.akos.sphero.common;

import com.akos.bluetooth.heartbeat.Heartbeat;
import com.akos.sphero.commands.*;
import com.akos.sphero.common.internal.*;
import com.akos.sphero.common.internal.ids.SOP;

import javax.microedition.io.StreamConnection;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

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

    private DataOutputStream deviceCommandStream = null;
    private DataInputStream deviceResponseStream = null;

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
        deviceResponseStream = connection.openDataInputStream();
        deviceCommandStream = connection.openDataOutputStream();
        if (!executorService.isShutdown()) {
            executorService.execute(inboundProcessor);
            executorService.execute(outboundProcessor);
        }
    }

    public void close() throws IOException {
        executorService.shutdownNow();
        deviceCommandStream.close();
        deviceResponseStream.close();
    }


    private class InboundProcessor extends Processor {

        private BlockingQueue<DeviceResponse> incomingQueue;

        public InboundProcessor(BlockingQueue<DeviceResponse> incomingQueue) {
            this.incomingQueue = incomingQueue;
        }

        @Override
        public void run() {
            this.running = true;
            try {
                while (!executorService.isShutdown()) {
                    ByteArrayOutputStream incomingByteStream = new ByteArrayOutputStream();

                    incomingByteStream.write(deviceResponseStream.readByte());     // SOP1
                    byte SOP2 = deviceResponseStream.readByte();
                    incomingByteStream.write(SOP2);                                // SOP2

                    int lengthOfData = 0;
                    boolean isAsync = false;
                    if (SOP2 == SOP.DEFAULT.getValue()) {
                        byte MSRP = deviceResponseStream.readByte();
                        incomingByteStream.write(MSRP);                            // MSRP
                        incomingByteStream.write(deviceResponseStream.readByte()); // SEQ
                        byte DLEN = deviceResponseStream.readByte();
                        incomingByteStream.write(DLEN);                            // DLEN
                        lengthOfData = DLEN;
                    } else if (SOP2 == SOP.ASYNC.getValue()) {
                        isAsync = true;
                        incomingByteStream.write(deviceResponseStream.readByte()); // ID CODE
                        byte DLEN_MSB = deviceResponseStream.readByte();
                        incomingByteStream.write(DLEN_MSB);                        // DLEN MSB
                        byte DLEN_LSB = deviceResponseStream.readByte();
                        incomingByteStream.write(DLEN_LSB);                        // DLEN LSB
                        lengthOfData = (DLEN_MSB << 8) | (DLEN_LSB);
                    }
                    for (int i = 0; i < (lengthOfData - 1); i++) {
                        incomingByteStream.write(deviceResponseStream.readByte()); // DATA
                    }
                    incomingByteStream.write(deviceResponseStream.readByte());     // CHK
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
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                heartbeat.kill();
                this.running = false;
            }

        }
    }

    private class OutboundProcessor extends Processor {
        @Override
        public void run() {
            this.running = true;
            try {
                while (!executorService.isShutdown()) {
                    DeviceCommand message = outgoingQueue.take();
                    deviceCommandStream.write(message.getPacket());
                    deviceCommandStream.flush();
                    sentCommands.put(message.getSequenceNumber(), message);
                    System.out.printf("Command => %s : %s%n", message, message.getSequenceNumber());
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            } finally {
                heartbeat.kill();
                this.running = false;
            }
        }
    }

}
