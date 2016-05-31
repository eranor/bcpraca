package com.akos.bluetooth;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

import com.akos.bluetooth.heartbeat.*;
import com.akos.sphero.common.Channel;
import org.apache.logging.log4j.*;

import javax.bluetooth.RemoteDevice;
import javax.microedition.io.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class BluetoothDevice extends RemoteDevice {

    private static final Logger logger = LogManager.getLogger(BluetoothDevice.class);

    private StreamConnection connection = null;
    private Heartbeat heartbeat = new Heartbeat();
    private ExecutorService heartbeatService;

    protected boolean isConnected = false;
    protected String deviceURL;
    protected String name;
    protected String address;

    public Channel dataChannel = null;

    public BluetoothDevice(String name, String address) {
        super(address);
        this.name = name;
        this.address = getFormattedAddress();
    }

    public BluetoothDevice(List<String> args) {
        this(args.get(0), args.get(1));
    }


    public void connect() {
        if (!isConnected) {
            try {
                startHeartbeat();
                connection = (StreamConnection) Connector.open(this.deviceURL);
                dataChannel = new Channel(connection, heartbeat);
                dataChannel.open();
                isConnected = true;
                logger.info(String.format("Connected to Device (%s) at %s", name, deviceURL));
            } catch (IOException e) {
                logger.error(String.format("Unable to connect to Device (%s) at %s", name, deviceURL));
            }
        } else {
            logger.error(String.format("Device (%s) is already connected.", name));
        }
    }

    public void disconnect() {
        if (isConnected) {
            try {
                dataChannel.close();
                connection.close();
                isConnected = false;
                stopHeartbeat();
            } catch (IOException e) {
                logger.log(Level.ERROR, String.format("Unable to disconnect from the Sphero (%s).", name));
            }
        } else {
            logger.log(Level.ERROR, String.format("Device (%s) is already disconnected.", name));
        }
    }

    private void startHeartbeat() {
        heartbeatService = Executors.newSingleThreadExecutor();
        this.addHeartbeatListener(new HeartbeatListener() {
            @Override
            public void onChange() {
                disconnect();
            }
        });
    }

    private void stopHeartbeat() {
        heartbeatService.shutdown();
    }

    private void addHeartbeatListener(HeartbeatListener aListener) {
        aListener.setHeartbeat(heartbeat);
        heartbeatService.execute(aListener);
    }

    public boolean isConnected() {
        if (!isConnected) {
            logger.log(Level.ERROR, String.format("Device (%s) is not connected!", name));
        }
        return isConnected;
    }

    @Override
    public String toString() {
        return String.format("%s => %s", name, getFormattedAddress());
    }

    public String getDeviceURL() {
        return deviceURL;
    }

    public String getName() {
        return name;
    }

    public String getFormattedAddress() {
        return getBluetoothAddress().replaceAll("(.{2})", "$1:").substring(0, 17);
    }


}
