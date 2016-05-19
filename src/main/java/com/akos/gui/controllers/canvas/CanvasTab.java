package com.akos.gui.controllers.canvas;


import com.akos.gui.modules.*;
import com.akos.models.services.*;
import javafx.beans.property.*;
import javafx.fxml.*;
import javafx.geometry.Point2D;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ákos on 2015. 12. 07.
 * Email: akoshervay@gmail.com
 */


public class CanvasTab extends Tab implements Initializable {

    private final MainService mainService;

    private RectangleSelection rectangleSelection;
    private Program visibleProgram;
    private BooleanProperty altStatus = new SimpleBooleanProperty(this, "altStatus", false);
    private DragContext sceneDragContext = new DragContext();

    @FXML
    public ScrollPane scrollPane;
    @FXML
    public StackPane innerStackPane;
    @FXML
    public AnchorPane contentPane;
    @FXML
    public GriddedPane backgroundGrid;
    @FXML
    public Group contentGroup;
    @FXML
    public Group zoomGroup;

    public CanvasTab(MainService mainService, Program program) {
        CFXMLLoader.justLoad("com/akos/fxml/gui/CanvasTab.fxml", this);
        this.setText(program.getName());
        this.setClosable(true);

        this.mainService = mainService;
        this.visibleProgram = program;

    }

    public Program getProgram() {
        return visibleProgram;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scrollPane.setHvalue(scrollPane.getHmin() + (scrollPane.getHmax() - scrollPane.getHmin()) / 2);
        scrollPane.setVvalue(scrollPane.getVmin() + (scrollPane.getVmax() - scrollPane.getVmin()) / 2);
        contentPane.prefWidthProperty().bind(innerStackPane.prefWidthProperty());
        contentPane.prefHeightProperty().bind(innerStackPane.prefHeightProperty());
        backgroundGrid.prefWidthProperty().bind(innerStackPane.prefWidthProperty());
        backgroundGrid.prefHeightProperty().bind(innerStackPane.prefHeightProperty());
        this.rectangleSelection = new RectangleSelection(contentPane);
    }

    public void setupHandlers() {
        zoomGroup.setOnScroll(event -> {
            if (getAltStatus()) {
                AnimatedZoomOperator zoomOperator = new AnimatedZoomOperator();
                zoomOperator.zoom(scrollPane, zoomGroup, event);
                event.consume();
            }
        });

        zoomGroup.setOnZoom(event -> {
            AnimatedZoomOperator zoomOperator = new AnimatedZoomOperator();
            zoomOperator.zoom(scrollPane, zoomGroup, event);
            event.consume();
        });

        getTabPane().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ALT)
                setAltStatus(true);
            event.consume();
        });
        getTabPane().addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            if (event.getCode() == KeyCode.ALT)
                setAltStatus(false);
            if (event.getCode() == KeyCode.DELETE) {
                mainService.getSelectionModel().getSelection().forEach(node -> {
                    AbstractFunctionModule node1 = (AbstractFunctionModule) node;
                    getProgram().getElements().remove(node1.getModel());
                    getProgram().getModuleGraph().removeNode(node1.getModel());
                    node1.removeLink();
                    contentPane.getChildren().remove(node);
                });
            }
            event.consume();
        });

        contentGroup.setOnMouseMoved(event1 -> {
            mainService.cursorPositionProperty().set(contentGroup.sceneToLocal(new Point2D(event1.getSceneX(), event1.getSceneY())));
        });

        contentPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            getTabPane().requestFocus();
            if (event.getButton() != MouseButton.SECONDARY && event.getTarget() != null && event.getTarget() == contentPane) {
                event.consume();
                rectangleSelection.startSelection(mainService.getSelectionModel(), event);
            } else if (contentPane.getChildren().contains(event.getTarget())) {
                mainService.getSelectionModel().clear().add((Node) event.getTarget()).setSelectedNode((Node) event.getTarget());
            }
        });
    }

    public boolean getAltStatus() {
        return altStatus.get();
    }

    public BooleanProperty altStatusProperty() {
        return altStatus;
    }

    public void setAltStatus(boolean altStatus) {
        this.altStatus.set(altStatus);
    }

}
