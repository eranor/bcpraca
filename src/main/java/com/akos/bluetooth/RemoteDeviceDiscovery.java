package com.akos.bluetooth;

import com.akos.sphero.Robot;
import javafx.collections.*;
import javafx.concurrent.Task;
import org.apache.logging.log4j.*;

import javax.bluetooth.*;
import javax.bluetooth.UUID;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RemoteDeviceDiscovery extends Task<Map<String, List<String>>> {

    private static final Logger logger = LogManager.getLogger(RemoteDeviceDiscovery.class);
    // url attribute
    private final int URL_ATTRIBUTE = 0X0100;
    // RN-SPP (RN-42) sphero service uuid
    private final UUID SERVICE_UUID = new UUID("0000110100001000800000805F9B34FB", false);

    private final UUID[] searchUuidSet = new UUID[]{SERVICE_UUID};
    private final int[] attrIDs = new int[]{URL_ATTRIBUTE};

    private final Object inquiryCompletedEvent = new Object();
    private final Object serviceSearchCompletedEvent = new Object();

    private ObservableMap<String, List<String>> mapReturnResult;
    private ObservableList<RemoteDevice> discoveredDevices;

    @Override
    protected Map<String, List<String>> call() throws Exception {
        return getBluetoothDevices();
    }

    public ObservableList<RemoteDevice> findNearbyDevices() throws BluetoothStateException, InterruptedException {
        discoveredDevices = FXCollections.observableArrayList();
        discoveredDevices.clear();
        DeviceDiscoveryListener listener = new DeviceDiscoveryListener();
        synchronized (inquiryCompletedEvent) {
            boolean isInquiryStarted = LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, listener);
            if (isInquiryStarted) {
                updateMessage("Waiting for inquiry to complete...");
                logger.log(Level.INFO, "Waiting for inquiry to complete...");
                inquiryCompletedEvent.wait();
                updateMessage("Found " + discoveredDevices.size() + " Device(s)!");
                logger.log(Level.INFO, "Found " + discoveredDevices.size() + " Device(s)!");
            }
        }
        return discoveredDevices;
    }

    public ObservableMap<String, List<String>> getBluetoothDevices() throws InterruptedException, BluetoothStateException, ExecutionException {
        mapReturnResult = FXCollections.observableHashMap();
        mapReturnResult.clear();
        findNearbyDevices();
        int workDone = 0;
        updateProgress(workDone, discoveredDevices.size());
        ServiceDiscoveryListener listener = new ServiceDiscoveryListener();
        for (RemoteDevice rd : discoveredDevices) {
            List<String> listDeviceDetails = new ArrayList<>();

            try {
                listDeviceDetails.add(rd.getFriendlyName(false));
                listDeviceDetails.add(rd.getBluetoothAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
            mapReturnResult.put(rd.getBluetoothAddress(), listDeviceDetails);
            synchronized (serviceSearchCompletedEvent) {
                updateMessage(String.format("Searching services on %s", rd));
                logger.debug(String.format("Searching services on %s", rd));
                LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet, rd, listener);
                serviceSearchCompletedEvent.wait();
                updateProgress(++workDone, discoveredDevices.size());
            }
        }
        updateProgress(0, 0);
        done();
        return mapReturnResult;
    }

    private class DeviceDiscoveryListener implements DiscoveryListener {
        @Override
        public void deviceDiscovered(RemoteDevice rd, DeviceClass deviceClass) {
            if (rd.getBluetoothAddress().startsWith(Robot.SPHERO_IEEE_OUI)) {
                updateMessage(String.format("Found a Sphero nearby: %s", rd));
                logger.log(Level.INFO, String.format("Found a Sphero nearby: %s", rd));
                discoveredDevices.add(rd);
            } else {
                updateMessage(String.format("Found some other Bluetooth device: %s", rd));
                logger.log(Level.INFO, String.format("Found some other Bluetooth device: %s", rd));
                discoveredDevices.add(rd);
            }
        }

        @Override
        public void inquiryCompleted(int i) {
            updateMessage("Inquiry for any nearby devices completed!");
            logger.log(Level.INFO, "Inquiry for any nearby devices completed!");
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

    private class ServiceDiscoveryListener implements DiscoveryListener {


        @Override
        public void inquiryCompleted(int discType) {
        }

        @Override
        public void deviceDiscovered(RemoteDevice remoteDevice, DeviceClass deviceClass) {
        }

        public void servicesDiscovered(int transID, ServiceRecord[] serviceRecord) {
            for (ServiceRecord record : serviceRecord) {
                String url = record.getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
                if (url == null) continue;

                RemoteDevice rd = record.getHostDevice();
                DataElement serviceName = record.getAttributeValue(URL_ATTRIBUTE);
                List<String> ts = new ArrayList<>();
                if (serviceName != null) {
                    ts.add((String) serviceName.getValue());
                    ts.add(url);
                } else {
                    ts.add("Unknown service");
                    ts.add(url);
                }
                mapReturnResult.get(rd.getBluetoothAddress()).addAll(ts);
            }
        }

        public void serviceSearchCompleted(int transID, int respCode) {
            updateMessage("Service search on device completed!");
            logger.log(Level.INFO, "Service search on device completed!");
            synchronized (serviceSearchCompletedEvent) {
                serviceSearchCompletedEvent.notifyAll();
            }
        }
    }
}
