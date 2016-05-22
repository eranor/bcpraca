package com.akos.gui.jfx_components;


import com.akos.bluetooth.BluetoothDevice;
import javafx.event.*;
import javafx.scene.control.*;

/**
 * Created by Ákos on 2015. 11. 23.
 * Email: akoshervay@gmail.com
 */
public class TableViewButtonCell<S, T> extends TableCell<S, T> {

    private final String DEFAULT_NAME = "Ok";
    protected final Button btn = new Button(DEFAULT_NAME);
    private EventHandler<ActionEvent> eventHandler;

    public TableViewButtonCell() {
        super();
    }

    public TableViewButtonCell(String text) {
        super();
        this.btn.setText(text);
        this.eventHandler = null;

    }


    public void setEventHandler(EventHandler<ActionEvent> eh) {
        eventHandler = eh;
    }

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
            setText(null);
        } else {
            btn.setOnAction(this.eventHandler);
            setGraphic(btn);
        }

        TableRow currentRow = getTableRow();
        if (currentRow.getItem() != null) {
            BluetoothDevice d = (BluetoothDevice) currentRow.getItem();
            if (!(d.getAddress().startsWith("00066"))) {
                setGraphic(null);
            }
        }
    }
}

