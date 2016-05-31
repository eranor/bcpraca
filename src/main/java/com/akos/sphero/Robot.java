package com.akos.sphero;

import com.akos.bluetooth.BluetoothDevice;
import com.akos.sphero.commands.robot.OrbBasicController;
import com.akos.sphero.common.internal.*;
import org.apache.logging.log4j.*;

import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class Robot extends BluetoothDevice {

    private static final Logger logger = LogManager.getLogger(Robot.class);
    public static final String SPHERO_IEEE_OUI = "000666"; // IEEE OUI for Roving Networks
    private final OrbBasicController orbController;

    private String identifier;

    public Robot(List<String> args) {
        this(args.get(0), args.get(1), args.size() > 2 ? args.get(3) : null);
    }

    public Robot(String name, String address, String url) {
        super(name, address);
        this.orbController = new OrbBasicController(this);
        setSpheroUrl(url != null ? url : "btspp://" + address + ":1;authenticate=false;encrypt=false;master=false");
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
            logger.log(Level.WARN, "Unable to change Device (" + name + ") URL while connected.");
        }
    }


    public void send(DeviceCommand command) {
        if (isConnected()) {
            this.dataChannel.send(command);
            logger.debug("Command" + command + "sent!");
        }
    }

    public DeviceResponse getNextPacket() {
        if (this.dataChannel.numberOfQueuedResponses() > 0) {
            return this.dataChannel.receive();
        }
        logger.info("No packets from Sphero (" + getName() + ") are currently in the queue.");
        return null;
    }

    public DeviceResponse waitForNextPacket() {
        return dataChannel.receive();
    }

    public ArrayList<DeviceResponse> getAllPackets() {
        return dataChannel.receiveAll();
    }

    public void addResponseListener(OrbBasicController orbBasicController) {

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


    public OrbBasicController getOrbController() {
        return orbController;
    }
}
