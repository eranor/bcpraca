package com.akos.modules;

import com.akos.gui.Utils;
import javafx.fxml.*;
import javafx.geometry.Side;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.net.URL;
import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class ModuleConnector extends Pane implements Initializable {

    @FXML
    Polygon connector;

    private final ConnectorType connectorType;
    private final Side side;
    private final int priority;
    private boolean connected = false;

    public ModuleConnector(ConnectorType type, Side side, int priority) {
        CFXMLLoader.load("com/akos/fxml/modules/modules2_Connector.fxml", this);
        this.connectorType = type;
        this.side = side;
        this.priority = priority;

        Tooltip t = new Tooltip(connectorType.getTooltip());
        Utils.hackTooltipStartTiming(t);
        Tooltip.install(this, t);

        connector.setFill(connectorType.fillColor);
        connector.setStroke(connectorType.strokeColor);
        setId(UUID.randomUUID().toString());
    }


    public ConnectorType getConnectorType() {
        return connectorType;
    }

    public Side getSide() {
        return side;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.setOnMouseEntered(event -> {
            this.setStyle("-fx-effect: dropshadow(three-pass-box, #ffb82a, 4, 4, 0, 0);");

        });
        this.setOnMouseExited(event -> {
            this.setStyle(null);
        });
        this.setOnDragOver(event -> this.setStyle("-fx-effect: dropshadow(three-pass-box, #ffb82a, 4, 4, 0, 0);"));
        this.setOnDragDone(event -> this.setStyle(null));

    }


    public enum ConnectorType {
        IN(new Color(0.6549019607843137, 0.8313725490196079, 0.5725490196078431, 1),
                new Color(0.3764705882352941, 0.7137254901960784, 0.34509803921568627, 0.5),
                true, "Input Connector"),
        COLLECTOR(new Color(0.6549019607843137, 0.8313725490196079, 0.5725490196078431, 1),
                new Color(0.3764705882352941, 0.7137254901960784, 0.34509803921568627, 0.5),
                true, "Collector"),
        OUT(new Color(0.9411764705882353, 0.7568627450980392, 0.49019607843137253, 1),
                new Color(0.9372549019607843, 0.19215686274509805, 0.06666666666666667, 0.5)
                , false, "Output Connector"),
        TRUE(new Color(0.3215686274509804, 0.6941176470588235, 0.24705882352941178, 1),
                new Color(0.08235294117647059, 0.45098039215686275, 0.16470588235294117, 0.5)
                , false, "Output if condition is TRUE"),
        FALSE(new Color(0.8274509803921568, 0.1607843137254902, 0.0392156862745098, 1),
                new Color(0.49019607843137253, 0.050980392156862744, 0.03137254901960784, 0.5)
                , false, "Output if condition is FALSE");


        private final Color fillColor;
        private final Color strokeColor;
        private final boolean type;
        private final String tooltip;

        ConnectorType(Color fill, Color stroke, boolean type, String tooltip) {
            this.fillColor = fill;
            this.strokeColor = stroke;
            this.type = type;
            this.tooltip = tooltip;
        }

        public boolean isInput() {
            return type;
        }

        public String getTooltip() {
            return tooltip;
        }
    }
}
