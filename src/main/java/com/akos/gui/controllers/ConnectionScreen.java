package com.akos.gui.controllers;


import com.akos.App;
import com.akos.bluetooth.*;
import com.akos.gui.dialogs.PopupDialog;
import com.akos.gui.jfx_components.TableViewButtonCell;
import com.akos.models.services.MainService;
import com.akos.sphero.Robot;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.*;
import org.controlsfx.control.*;

import javax.bluetooth.*;
import java.net.URL;
import java.util.*;

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
    public MaskerPane masker;
    public StatusBar statusBar;

    private ObservableList<BluetoothDevice> discoveredDevices = FXCollections.observableArrayList();

    public ConnectionScreen(MainService mainService) {
        super(mainService);
    }

    public void discoverDeviceAction(ActionEvent actionEvent) {
        try {

            LocalDevice localDevice = LocalDevice.getLocalDevice();
            labelDeviceName.setText(localDevice.getFriendlyName());
            labelDeviceAddress.setText(localDevice.getBluetoothAddress());
            labelDeviceStatus.setText(String.valueOf(localDevice.getDiscoverable()));

            Service<?> bt = new Service<Map<String, List<String>>>() {
                @Override
                protected Task<Map<String, List<String>>> createTask() {
                    return new RemoteDeviceDiscovery();
                }
            };
            statusBar.textProperty().bind(bt.messageProperty());
            statusBar.progressProperty().bind(bt.progressProperty());
            bt.setOnSucceeded(event -> {
                ((Map<String, List<String>>) event.getSource().getValue()).forEach((s, strings) -> {
                    discoveredDevices.add(s.startsWith(Robot.SPHERO_IEEE_OUI) ? new Robot(strings) : new BluetoothDevice(strings));
                });
                masker.setVisible(false);
                statusBar.textProperty().unbind();
                statusBar.progressProperty().unbind();
            });
            masker.setVisible(true);
            bt.reset();
            bt.start();
        } catch (BluetoothStateException e) {
            Stage dialog = new PopupDialog(((Node) actionEvent.getTarget()).getScene().getWindow());
            dialog.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        masker.setVisible(false);
        numberingColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BluetoothDevice, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<BluetoothDevice, String> p) {
                return new ReadOnlyObjectWrapper<>(tableDiscoveredDevices.getItems().indexOf(p.getValue()) + "");
            }
        });
        numberingColumn.setSortable(false);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("formattedAddress"));
        buttonColumn.setCellFactory(param -> {
            TableViewButtonCell<BluetoothDevice, String> t = new TableViewButtonCell<>("Use device");
            t.setEventHandler(event -> {
                System.out.println("Saving device: ");
                BluetoothDevice device = (BluetoothDevice) t.getTableRow().getItem();
                mainService.setRobot((Robot) device);

                Notifications.create()
                        .title("Information")
                        .text(String.format("Sphero %s with address %s set as main robot device.", device.getName(), device.getFormattedAddress()))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.BOTTOM_RIGHT)
                        .owner(App.primaryStage)
                        .hideCloseButton()
                        .darkStyle()
                        .showInformation();
            });
            return t;
        });
        tableDiscoveredDevices.setItems(discoveredDevices);
    }


}
