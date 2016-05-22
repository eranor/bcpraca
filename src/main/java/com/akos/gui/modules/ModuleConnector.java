package com.akos.gui.modules;

import javafx.fxml.*;
import javafx.geometry.Side;
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


    private final Side side;
    private ConnectorType connectorType;

    public ModuleConnector(ConnectorType type, Side side) {
        CFXMLLoader.load("com/akos/fxml/modules/modules2_Connector.fxml", this);
        this.connectorType = type;
        this.side = side;
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
                new Color(0.3764705882352941, 0.7137254901960784, 0.34509803921568627, 0.5)),
        OUT(new Color(0.9411764705882353, 0.7568627450980392, 0.49019607843137253, 1),
                new Color(0.9372549019607843, 0.19215686274509805, 0.06666666666666667, 0.5));

        private final Color fillColor;
        private final Color strokeColor;

        ConnectorType(Color fill, Color stroke) {
            this.fillColor = fill;
            this.strokeColor = stroke;
        }
    }
}
