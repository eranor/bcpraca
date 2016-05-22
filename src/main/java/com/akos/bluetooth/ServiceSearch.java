package com.akos.bluetooth;


import javafx.collections.*;
import javafx.concurrent.Task;
import org.apache.logging.log4j.*;

import javax.bluetooth.*;
import javax.bluetooth.UUID;
import java.io.IOException;
import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ServiceSearch extends Task<ObservableMap<String, List<String>>> {
    private static final Logger logger = LogManager.getLogger(ServiceSearch.class);

    // url attribute
    private final int URL_ATTRIBUTE = 0X0100;
    // RN-SPP (RN-42) sphero service uuid
    private final UUID SERVICE_UUID = new UUID("0000110100001000800000805F9B34FB", false);

    private final UUID[] searchUuidSet = new UUID[]{SERVICE_UUID};

    private final Object serviceSearchCompletedEvent = new Object();
    private final int[] attrIDs = new int[]{URL_ATTRIBUTE};
    private final ObservableMap<String, List<String>> mapReturnResult = FXCollections.observableHashMap();

    public ObservableMap<String, List<String>> getBluetoothDevices() throws InterruptedException, BluetoothStateException {

        RemoteDeviceDiscovery remoteDeviceDiscovery = new RemoteDeviceDiscovery();
        ObservableList<RemoteDevice> devices = remoteDeviceDiscovery.findNearbyDevices();
        int workDone = 0;
        updateProgress(workDone, devices.size());
        ServiceDiscoveryListener listener = new ServiceDiscoveryListener();
        for (RemoteDevice rd : devices) {
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
                updateProgress(++workDone, devices.size());
            }
        }
        return mapReturnResult;
    }

    @Override
    protected ObservableMap<String, List<String>> call() throws InterruptedException, BluetoothStateException {
        return getBluetoothDevices();
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
            logger.log(Level.INFO, "Service search on device completed!");
            synchronized (serviceSearchCompletedEvent) {
                serviceSearchCompletedEvent.notifyAll();
            }
        }
    }

}
