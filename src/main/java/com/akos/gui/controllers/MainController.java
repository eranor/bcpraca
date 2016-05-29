package com.akos.gui.controllers;

import com.akos.gui.controllers.canvas.CanvasTab;
import com.akos.modules.*;
import com.akos.services.*;
import javafx.collections.SetChangeListener;
import javafx.event.*;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class MainController extends AbstractController implements Initializable {


    public MenuBar menu;

    public AnchorPane mainView;
    public BorderPane rootBorderPane;
    public TabPane canvasTabPane;
    public HBox rightPanelHBox;
    public HBox leftPanelHBox;
    public HBox statusBarHBox;
    public VBox rightPanel;
    public SplitPane splitPane;
    public ModulesPanel modulesPanel;
    public TitledPane modulePropertiesPane;
    public TitledPane robotStatusPane;
    public TitledPane robotConsolePane;
    public TitledPane robotJoystickPane;

    public Button collapseRightPanelButton;
    public Button collapseLeftPanelButton;
    public Label cursorPosLabel;


    ModulePreview preview;
    ModuleFactory moduleFactory = ModuleFactory.getInstance();

    private EventHandler<DragEvent> moduleDragOverRoot = null;
    private EventHandler<DragEvent> moduleDragDropped = null;
    private EventHandler<DragEvent> moduleDragOverTabPane = null;

    public MainController(MainService mainService) {
        super(mainService);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mainService.getPrograms().addListener(new ProgramSetChangeListener());
        canvasTabPane.getStylesheets().add("com/akos/css/gui/CanvasTabPane.css");
        canvasTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);
        SplitPane.setResizableWithParent(rightPanelHBox, Boolean.FALSE);
        SplitPane.setResizableWithParent(leftPanelHBox, Boolean.FALSE);
        preview = new ModulePreview();
        this.mainView.getChildren().add(preview);

        buildDragHandlers();

        for (Node module : modulesPanel.modulesContainer.getChildren()) {
            addDragDetection((IGraphicModule) module);
        }
        for (Node module : modulesPanel.variablesContainer.getChildren()) {
            addDragDetection((IGraphicModule) module);
        }

        mainService.getSelectionModel().selectedNodeProperty().addListener((observable, oldValue, newValue) -> {
            splitPane.getDividers().get(1).setPosition(1);
        });

        mainService.cursorPositionProperty().addListener((o, ov, nv) -> {
            cursorPosLabel.setText(String.format("%s:%s", (int) nv.getX(), (int) nv.getY()));
        });

    }

    private void addDragDetection(IGraphicModule module) {
        module.getView().setOnDragDetected(event -> {
            rootBorderPane.setOnDragOver(moduleDragOverRoot);
            canvasTabPane.setOnDragOver(moduleDragOverTabPane);
            canvasTabPane.setOnDragDropped(moduleDragDropped);
            preview.show(module, new Point2D(event.getSceneX(), event.getSceneY()));
            event.consume();
        });
    }

    private void buildDragHandlers() {
        moduleDragOverRoot = event -> {
            Point2D p = canvasTabPane.sceneToLocal(event.getSceneX(), event.getSceneY());

            if (!canvasTabPane.boundsInLocalProperty().get().contains(p)) {
                preview.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));
                return;
            }
            event.consume();
        };

        moduleDragOverTabPane = event -> {
            event.acceptTransferModes(TransferMode.ANY);
            preview.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));
            event.consume();
        };

        moduleDragDropped = event -> {
            DragDropContainer container =
                    (DragDropContainer) event.getDragboard().getContent(DragDropContainer.AddNode);

            container.addData("scene_coords", new Point2D(event.getSceneX(), event.getSceneY()));

            ClipboardContent content = new ClipboardContent();
            content.put(DragDropContainer.AddNode, container);

            event.getDragboard().setContent(content);
            event.setDropCompleted(true);
            canvasTabPane.removeEventHandler(DragEvent.DRAG_OVER, moduleDragOverTabPane);
            canvasTabPane.removeEventHandler(DragEvent.DRAG_DROPPED, moduleDragDropped);
            rootBorderPane.removeEventHandler(DragEvent.DRAG_OVER, moduleDragOverRoot);

            preview.hide();
            event.consume();
        };

        mainView.setOnDragDone(event -> {
            canvasTabPane.removeEventHandler(DragEvent.DRAG_OVER, moduleDragOverTabPane);
            canvasTabPane.removeEventHandler(DragEvent.DRAG_DROPPED, moduleDragDropped);
            rootBorderPane.removeEventHandler(DragEvent.DRAG_OVER, moduleDragOverRoot);

            preview.hide();
            CanvasTab tab = (CanvasTab) canvasTabPane.getTabs().stream().filter(Tab::isSelected).findAny().orElse(null);
            if (tab != null) {
                onNodeAdded(tab, (DragDropContainer) event.getDragboard().getContent(DragDropContainer.AddNode));
                onLinkAdded(tab, (DragDropContainer) event.getDragboard().getContent(DragDropContainer.AddLink));
            }
            event.consume();
        });

    }

    private void onNodeAdded(CanvasTab tab, DragDropContainer container) {
        if (container != null && container.getValue("scene_coords") != null) {
            AbstractModule droppedModule = moduleFactory.getModule((Type) container.getValue("type"));
            if (droppedModule != null)
                tab.contentPane.getChildren().add(droppedModule);
            Point2D cursorPoint = (Point2D) container.getValue("scene_coords");
            if (droppedModule != null) {
                DragUtils.relocateToPoint(droppedModule, new Point2D(cursorPoint.getX() - 64, cursorPoint.getY() - 64));
                droppedModule.toFront();
                mainService.getCurrentProgram().updateElements(droppedModule.getModel());
            }
        }
    }

    private void onLinkAdded(CanvasTab tab, DragDropContainer container) {
        if (container != null) {
            String[] sourceId = (String[]) container.getValue("source");
            String[] targetId = (String[]) container.getValue("target");

            if (sourceId != null && targetId != null) {
                ModuleLink link = new ModuleLink();
                tab.contentPane.getChildren().add(0, link);
                AbstractFunctionModule srcMod = null, tarMod = null;
                ModuleConnector srcConn = null, tarConn = null;

                for (Node n : tab.contentPane.getChildren()) {
                    if (n.getId().equals(sourceId[0])) {
                        srcMod = (AbstractFunctionModule) n;
                        srcConn = (ModuleConnector) srcMod.getChildren().stream().filter(node -> node.getId().equals
                                (sourceId[1])).findFirst().orElse(null);
                    } else if (n.getId().equals(targetId[0])) {
                        tarMod = (AbstractFunctionModule) n;
                        tarConn = (ModuleConnector) tarMod.getChildren().stream().filter(node -> node.getId().equals
                                (targetId[1])).findFirst().orElse(null);
                    }
                }

                if (srcConn != null && tarConn != null) {
                    if (srcConn.getConnectorType() != tarConn.getConnectorType())
                        if (!srcConn.isConnected() && !tarConn.isConnected())
                            if (srcConn.getConnectorType().isInput() && !tarConn.getConnectorType().isInput())
                                configureLink(link, tarMod, srcMod, tarConn, srcConn);
                            else
                                configureLink(link, srcMod, tarMod, srcConn, tarConn);
                }
            }
        }
    }

    private void configureLink(ModuleLink link, AbstractModule srcMod,
                               AbstractModule tarMod, ModuleConnector srcConn, ModuleConnector tarConn) {
        link.setStartConn(srcConn);
        link.setEndConn(tarConn);
        link.bindDirection();
        link.bindEnds();
        srcConn.setOnMouseClicked(event -> {
            tarMod.removeLink(link.getId());
            srcConn.setConnected(false);
            tarConn.setConnected(false);
        });
        mainService.getCurrentProgram().makeConnection(srcConn.getPriority(), srcMod.getModel(),
                tarConn.getPriority(), tarMod.getModel());
    }

    public void collapseRightPanel(ActionEvent actionEvent) {
        if (rightPanelHBox.getChildren().contains(rightPanel)) {
            rightPanelHBox.getChildren().remove(rightPanel);
            SplitPane.Divider d = splitPane.getDividers().get(1);
            d.setPosition(1);
        } else
            rightPanelHBox.getChildren().add(rightPanel);
    }

    public void collapseLeftPanel(ActionEvent actionEvent) {
        if (leftPanelHBox.getChildren().contains(modulesPanel)) {
            leftPanelHBox.getChildren().remove(modulesPanel);
            SplitPane.Divider d = splitPane.getDividers().get(0);
            d.setPosition(0);
        } else
            leftPanelHBox.getChildren().add(0, modulesPanel);
    }

    private class ProgramSetChangeListener implements SetChangeListener<Program> {

        @Override
        public void onChanged(Change<? extends Program> change) {
            if (change.wasAdded()) {
                Program program = change.getElementAdded();
                CanvasTab tab = new CanvasTab(mainService, program);
                canvasTabPane.getTabs().add(tab);
                tab.setupHandlers();
            } else if (change.wasRemoved()) {
                Program program = change.getElementRemoved();
                canvasTabPane.getTabs().stream().filter(tab -> tab instanceof CanvasTab).filter(tab ->
                        ((CanvasTab) tab).getProgram() == program).forEach(tab -> canvasTabPane.getTabs().remove(tab));
            }
        }
    }

    /**
     * Created by Ákos on 2015. 12. 11.
     * Email: akoshervay@gmail.com
     */
    /*
    *   Module preview class for moving between the module panel
    *   and the canvas
    * */
    public static class ModulePreview extends ImageView {

        ClipboardContent content;

        public ModulePreview() {
            super();
            this.setVisible(false);
            this.setOpacity(0.65);
            this.setId("preview-module");
        }

        public void show(IGraphicModule module, Point2D point) {
            this.setImage(module.getView().snapshot(null, null));
            this.setManaged(false);
            this.relocateToPoint(point);

            ClipboardContent content = new ClipboardContent();
            DragDropContainer container = new DragDropContainer();

            container.addData("type", module.getType());
            content.put(DragDropContainer.AddNode, container);

            this.startDragAndDrop(TransferMode.ANY).setContent(content);
            this.setVisible(true);
            this.setMouseTransparent(true);
        }


        public void hide() {
            this.setImage(null);
            this.setVisible(false);
        }

        public void relocateToPoint(Point2D point) {
            Point2D localCoords = getParent().sceneToLocal(point);

            relocate((int) (localCoords.getX() - (getBoundsInLocal().getWidth() / 2)),
                    (int) (localCoords.getY() - (getBoundsInLocal().getHeight() / 2)));
        }

    }
}
