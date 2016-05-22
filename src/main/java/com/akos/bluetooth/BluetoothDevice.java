package com.akos.bluetooth;/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

import com.akos.bluetooth.heartbeat.*;
import com.akos.sphero.common.Channel;
import javafx.beans.property.*;
import org.apache.logging.log4j.*;

import javax.bluetooth.RemoteDevice;
import javax.microedition.io.*;
import java.io.IOException;
import java.util.concurrent.*;

public class BluetoothDevice extends RemoteDevice {

    private static final Logger logger = LogManager.getLogger(BluetoothDevice.class);
    public static final int SPP_DEFAULT_CHANNEL = 1;
    private final String friendlyName;

    private boolean isConnected = false;
    private String deviceURL;
    private StreamConnection connection = null;
    private ExecutorService heartbeatService;
    private Heartbeat heartbeat = new Heartbeat();

    private final SimpleObjectProperty<BluetoothDevice> bd;
    private SimpleStringProperty address;
    private SimpleStringProperty name = null;

    public final int sppChannel;
    public Channel dataChannel = null;

    public BluetoothDevice(String address, String name, int sppChannel) {
        super(address);
        this.sppChannel = sppChannel;
        this.deviceURL = "btspp://" + address + ":" + sppChannel + ";authenticate=false;encrypt=false;master=false";
        this.friendlyName = name;
        this.bd = new SimpleObjectProperty<>(this, "bd", this);
        this.address = new SimpleStringProperty(this, "address", address);
        this.name = new SimpleStringProperty(this, "name", name);
    }

    public void setSpheroUrl(String url) {
        if (!isConnected) {
            if (url.matches("btspp://" + this.getBluetoothAddress() + ":" +
                    "([1-9]|[1-3]?[0-9]);authenticate=(true|false);encrypt=(true|false);master=(true|false)")) {
                deviceURL = url;
            } else {
                logger.log(Level.WARN, "New Device service URL is not properly formatted.");
            }
        } else {
            logger.log(Level.WARN, "Unable to change Device (" + friendlyName + ") URL while connected.");
        }
    }

    public void connect() {
        if (!isConnected) {
            try {
                startHeartbeat();
                StreamConnectionNotifier connection = (StreamConnectionNotifier) Connector.open(this.deviceURL);
                dataChannel = new Channel(connection.acceptAndOpen(), heartbeat);
                dataChannel.open();
                isConnected = true;
            } catch (IOException e) {
                logger.log(Level.ERROR, String.format("Unable to connect to Device (%s) at %s", friendlyName, deviceURL));
            }
        } else {
            logger.log(Level.ERROR, String.format("Device (%s) is already connected.", friendlyName));
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
                logger.log(Level.ERROR, String.format("Unable to disconnect from the Sphero (%s).", friendlyName));
            }
        } else {
            logger.log(Level.ERROR, String.format("Device (%s) is already disconnected.", friendlyName));
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
            logger.log(Level.ERROR, String.format("Device (%s) is not connected!", friendlyName));
        }
        return isConnected;
    }

    @Override
    public String toString() {
        return String.format("%s => %s", getFriendlyName(), getFormattedAddress());
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getConnectionURL() {
        return deviceURL;
    }

    public BluetoothDevice getRobotDevice() {
        return bd.get();
    }

    public SimpleObjectProperty<BluetoothDevice> rdProperty() {
        return bd;
    }

    public String getAddress() {
        return address.get();
    }

    public String getFormattedAddress() {
        return getBluetoothAddress().replaceAll("(.{2})", "$1:").substring(0, 17);
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }


}
