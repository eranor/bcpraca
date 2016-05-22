package com.akos.sphero;

import com.akos.bluetooth.BluetoothDevice;
import com.akos.sphero.commands.robot.OrbBasicController;
import com.akos.sphero.common.internal.*;
import org.apache.logging.log4j.*;

import java.util.ArrayList;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class Robot extends BluetoothDevice {
    private static final Logger logger = LogManager.getLogger(Robot.class);
    private String identifier;

    public Robot(String address, String name, int sppChannel) {
        super(address, name, sppChannel);
    }

    public Robot(BluetoothDevice device) {
        super(device.getAddress(), device.getName(), device.sppChannel);
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
        logger.info("No packets from Sphero (" + getFriendlyName() + ") are currently in the queue.");
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
}
