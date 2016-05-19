package com.akos.gui.controllers;


import com.akos.bluetooth.*;
import com.akos.gui.dialogs.PopupDialog;
import com.akos.gui.jfx_components.TableViewButtonCell;
import com.akos.models.services.MainService;
import com.akos.sphero.Robot;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.bluetooth.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 06.
 * Email: akoshervay@gmail.com
 */


public class ConnectionScreen extends AbstractController implements Initializable {
    public Label labelDeviceName;
    public Label labelDeviceAddress;
    public Label labelDeviceStatus;
    public Button buttonDiscoverDevice;
    public ProgressIndicator searchProgressIndicator;
    public TableView<BluetoothDevice> tableDiscoveredDevices;
    public TableColumn numberingColumn;
    public TableColumn<Object, Object> nameColumn;
    public TableColumn<Object, Object> addressColumn;
    public TableColumn buttonColumn;
    public BorderPane view;

    public BluetoothDiscovery discoveryThread;

    public ConnectionScreen(MainService mainService) {
        super(mainService);
        this.discoveryThread = new BluetoothDiscovery();
    }

    public void discoverDeviceAction(ActionEvent actionEvent) {
        try {
            LocalDevice localDevice = LocalDevice.getLocalDevice();
            labelDeviceName.setText(localDevice.getFriendlyName());
            labelDeviceAddress.setText(localDevice.getBluetoothAddress());
            labelDeviceStatus.setText(String.valueOf(localDevice.getDiscoverable()));
            new Thread(discoveryThread).start();
        } catch (BluetoothStateException e) {
            Stage dialog = new PopupDialog(((Node) actionEvent.getTarget()).getScene().getWindow());
            dialog.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        numberingColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BluetoothDevice, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BluetoothDevice, String> p) {
                return new ReadOnlyObjectWrapper<>(tableDiscoveredDevices.getItems().indexOf(p.getValue()) + "");
            }
        });
        numberingColumn.setSortable(false);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        Callback<TableColumn<BluetoothDevice, String>, TableViewButtonCell<BluetoothDevice, String>> cellFactory = //
                param -> {
                    TableViewButtonCell<BluetoothDevice, String> t = new TableViewButtonCell<>("Use device");
                    EventHandler<ActionEvent> connectToDeviceAction = event -> {
                        System.out.println("Saving device: ");
                        BluetoothDevice device = (BluetoothDevice) t.getTableRow().getItem();
                        mainService.setRobot(new Robot(device));
                    };
                    t.setEventHandler(connectToDeviceAction);
                    return t;
                };
        buttonColumn.setCellFactory(cellFactory);
        tableDiscoveredDevices.setItems(discoveryThread.discoveredDevices);
    }


}
