package com.akos.bluetooth;

import javafx.collections.*;
import org.apache.logging.log4j.*;

import javax.bluetooth.*;
import java.io.IOException;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class BluetoothDiscovery implements Runnable {

    private static final Logger logger = LogManager.getLogger(BluetoothDiscovery.class);
    private final String SPHERO_IEEE_OUI = "000666"; // IEEE OUI for Roving Networks

    private final Object inquiryCompletedEvent = new Object();
    private final Object serviceSearchCompletedEvent = new Object();
    private final SpheroDiscoveryListener listener = new SpheroDiscoveryListener();

    public ObservableList<BluetoothDevice> discoveredDevices = FXCollections.observableArrayList();
    private String deviceServiceURL = null;
    private String robotDeviceServiceURL = null;

    public void findNearbySpheros() throws BluetoothStateException, InterruptedException {

        discoveredDevices.clear();
        synchronized (inquiryCompletedEvent) {
            boolean isInquiryStarted = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
            if (isInquiryStarted) {
                logger.log(Level.INFO, "Waiting for inquiry to complete...");
                inquiryCompletedEvent.wait();
                logger.log(Level.INFO, "Found " + discoveredDevices.size() + " Sphero(s)!");
            }
        }

        // Search for RN-SPP service on Sphero
        UUID serviceUUID = new UUID("0000110100001000800000805F9B34FB", false); // RN-SPP (RN-42)

        UUID[] searchUuidSet = new UUID[]{serviceUUID};
        int[] attrIDs = null;

        for (BluetoothDevice s : discoveredDevices) {
            synchronized (serviceSearchCompletedEvent) {
                logger.log(Level.INFO, String.format("Searching services on %s", s));
                LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet, s, listener);
                serviceSearchCompletedEvent.wait();
            }
            if (deviceServiceURL == null) {
                logger.log(Level.WARN, "No services found. Using default Sphero service URL.");
            } else {
                s.setSpheroUrl(deviceServiceURL);
            }
        }
    }

    @Override
    public void run() {
        try {
            this.findNearbySpheros();
        } catch (BluetoothStateException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class SpheroDiscoveryListener implements DiscoveryListener {

        public void deviceDiscovered(RemoteDevice rd, DeviceClass btClass) {
            BluetoothDevice bd = null;

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
            }
        }

        public void inquiryCompleted(int discType) {
            logger.log(Level.INFO, "Inquiry for any nearby Spheros completed!");
            synchronized (inquiryCompletedEvent) {
                inquiryCompletedEvent.notifyAll();
            }
        }

        public void servicesDiscovered(int transID, ServiceRecord[] serviceRecord) {
            for (ServiceRecord aServiceRecord : serviceRecord) {
                String url = aServiceRecord.getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
                if (url == null) {
                    continue;
                }
                deviceServiceURL = url;
                logger.log(Level.INFO, "Found service (RN-SPP) at " + url + ".");
                break;    // Sphero only has a single RN-SPP service.
            }
        }

        public void serviceSearchCompleted(int transID, int respCode) {
            logger.log(Level.INFO, "Service search on Sphero completed!");
            synchronized (serviceSearchCompletedEvent) {
                serviceSearchCompletedEvent.notifyAll();
            }
        }
    }
}
