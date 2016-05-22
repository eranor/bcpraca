package com.akos.bluetooth;

import javafx.collections.*;
import org.apache.logging.log4j.*;

import javax.bluetooth.*;
import java.io.IOException;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RemoteDeviceDiscovery {

    private static final Logger logger = LogManager.getLogger(RemoteDeviceDiscovery.class);

    private final String SPHERO_IEEE_OUI = "000666"; // IEEE OUI for Roving Networks
    private final Object inquiryCompletedEvent = new Object();
    private String deviceServiceURL = null;
    private String robotDeviceServiceURL = null;
    private ObservableList<RemoteDevice> discoveredDevices;

    public ObservableList<RemoteDevice> findNearbyDevices() throws BluetoothStateException, InterruptedException {
        discoveredDevices = FXCollections.observableArrayList();
        discoveredDevices.clear();

        DeviceDiscoveryListener listener = new DeviceDiscoveryListener();

        synchronized (inquiryCompletedEvent) {
            boolean isInquiryStarted = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
            if (isInquiryStarted) {
                logger.log(Level.INFO, "Waiting for inquiry to complete...");
                inquiryCompletedEvent.wait();
                logger.log(Level.INFO, "Found " + discoveredDevices.size() + " Device(s)!");
            }
        }

        return discoveredDevices;

        /*for (RemoteDevice device : discoveredDevices) {
            synchronized (serviceSearchCompletedEvent) {
                logger.log(Level.INFO, String.format("Searching services on %s", device));
                LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet, device, listener);
                serviceSearchCompletedEvent.wait();
            }
            if (deviceServiceURL == null) {
                logger.log(Level.WARN, "No services found. Using default Sphero service URL.");
            } else {
                device.setSpheroUrl(deviceServiceURL);
            }
        }   */
    }

    private class DeviceDiscoveryListener implements DiscoveryListener {
        @Override
        public void deviceDiscovered(RemoteDevice rd, DeviceClass deviceClass) {
            BluetoothDevice bd;
            try {
                bd = new BluetoothDevice(rd.getBluetoothAddress(), rd.getFriendlyName(false),
                        BluetoothDevice.SPP_DEFAULT_CHANNEL);
            } catch (IOException e) {
                bd = new BluetoothDevice(rd.getBluetoothAddress(), "Unknown Device", 1);
            }
            if (rd.getBluetoothAddress().startsWith(SPHERO_IEEE_OUI)) {
                logger.log(Level.INFO, String.format("Found a Sphero nearby: %s", bd));
                discoveredDevices.add(bd);
            } else {
                logger.log(Level.INFO, String.format("Found some other Bluetooth device: %s", bd));
                discoveredDevices.add(bd);
            }
        }

        @Override
        public void inquiryCompleted(int i) {
            logger.log(Level.INFO, "Inquiry for any nearby Spheros completed!");
            synchronized (inquiryCompletedEvent) {
                inquiryCompletedEvent.notifyAll();
            }
        }

        @Override
        public void servicesDiscovered(int i, ServiceRecord[] serviceRecords) {
        }

        @Override
        public void serviceSearchCompleted(int i, int i1) {
        }


    }
}
