package com.akos.modules;

import com.akos.App;
import com.akos.modules.specific.EnumProperty;
import javafx.application.Platform;
import javafx.beans.DefaultProperty;
import javafx.collections.ObservableList;
import javafx.concurrent.*;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.PropertySheet.Item;
import org.controlsfx.property.*;

import java.net.URL;
import java.util.*;

/**
 * Created by Ákos on 2015. 12. 16.
 * Email: akoshervay@gmail.com
 */

@DefaultProperty("extension")
public abstract class AbstractFunctionModule extends AbstractModule {
    public static final int MODULE_WIDTH = 256;
    public static final double MODULE_HEIGHT = 188.892;
    public static final double CONNECTOR_WIDTH = 41.79;
    public static final double CONNECTOR_HEIGHT = 62.29;
    @FXML
    public AnchorPane view;
    @FXML
    public TextField labelTextField;
    @FXML
    public Pane moduleTitlePane;

    @FXML
    Group extension;

    public ConnectorMap connectorMap = new ConnectorMap();

    private List<String> mLinkIds = new ArrayList<>();

    public AbstractFunctionModule() {
        CFXMLLoader.load("com/akos/fxml/modules/AbstractModule.fxml", this);
        setId(UUID.randomUUID().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DragUtils.buildNodeDragHandlers(this);

        extension.setMouseTransparent(true);
        labelModuleName.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setName(newValue);
        });

        labelTextField.focusedProperty().addListener((ol, ov, nv) -> {
            if (!nv) {
                labelModuleName.setVisible(true);
                setStyle(null);
                labelTextField.setVisible(false);
                labelTextField.setMouseTransparent(true);
                labelTextField.textProperty().unbindBidirectional(labelModuleName.textProperty());
            }
        });

        moduleTitlePane.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (event.getClickCount() == 2 && model != null) {
                    System.out.println("Double clicked");
                    if (!labelTextField.isVisible()) {
                        labelModuleName.setVisible(false);
                        setStyle("-fx-background-color: darkturquoise");
                        labelTextField.setVisible(true);
                        labelTextField.setMouseTransparent(false);
                        labelTextField.textProperty().bindBidirectional(labelModuleName.textProperty());
                    }
                }
            }
        });

    }

    public void registerLink(String linkId) {
        mLinkIds.add(linkId);
    }

    public void removeLink(String id) {
        AnchorPane parent = (AnchorPane) this.getParent();
        for (ListIterator<Node> iterNode = parent.getChildren().listIterator(); iterNode.hasNext(); ) {
            Node node = iterNode.next();
            if (node.getId() == null)
                continue;
            if (node.getId().equals(id)) {
                iterNode.remove();
                App.mainService.getCurrentProgram().removeEdge(((ModuleLink) node).start.getModel(), ((ModuleLink) node).end.getModel());
            }
        }
    }

    public void removeLinks() {
        for (ListIterator<String> iterId = mLinkIds.listIterator(); iterId.hasNext(); ) {
            removeLink(iterId.next());
            iterId.remove();
        }
    }

    protected void buildConnectors() {
        connectorMap.forEach((side, moduleConnectors) -> {
            double posx = (MODULE_WIDTH / (moduleConnectors.size() + 1) - CONNECTOR_WIDTH / 2);
            double posy = (MODULE_HEIGHT / (moduleConnectors.size() + 1) - CONNECTOR_WIDTH / 2);
            double height = CONNECTOR_HEIGHT / 3;
            double width = CONNECTOR_WIDTH / 3;
            for (ModuleConnector mc : moduleConnectors) {
                getChildren().add(mc);
                mc.toBack();
                if (side == Side.TOP) {
                    AnchorPane.setTopAnchor(mc, -height);
                    AnchorPane.setLeftAnchor(mc, posx * (moduleConnectors.indexOf(mc) + 1));
                } else if (side == Side.BOTTOM) {
                    AnchorPane.setBottomAnchor(mc, -height);
                    AnchorPane.setLeftAnchor(mc, posx * (moduleConnectors.indexOf(mc) + 1));
                } else if (side == Side.LEFT) {
                    mc.setRotate(90);
                    AnchorPane.setLeftAnchor(mc, -width);
                    AnchorPane.setTopAnchor(mc, posy * (moduleConnectors.indexOf(mc) + 1));
                } else if (side == Side.RIGHT) {
                    mc.setRotate(90);
                    AnchorPane.setRightAnchor(mc, -width);
                    AnchorPane.setTopAnchor(mc, posy * (moduleConnectors.indexOf(mc) + 1));
                }
            }
        });
    }

    public void updatePropertySheet(PropertySheet propertySheet) {
        Service<?> service = new Service<ObservableList<Item>>() {

            @Override
            protected Task<ObservableList<Item>> createTask() {
                return new Task<ObservableList<Item>>() {
                    @Override
                    protected ObservableList<Item> call() throws Exception {
                        return BeanPropertyUtils.getProperties(model);
                    }
                };
            }
        };
        service.setOnSucceeded(e -> {
            @SuppressWarnings("unchecked")
            ObservableList<Item> list = (ObservableList<Item>) e.getSource().getValue();
            final List[] argsList = new List[]{null};
            list.filtered(item -> EnumProperty.class.isAssignableFrom(item.getType())).forEach(item1 -> {
                argsList[0] = ((EnumProperty) item1.getObservableValue().get().getValue()).getArgsList();
                item1.getObservableValue().ifPresent(oc -> oc.addListener((o, ol, nv) -> {
                    argsList[0] = ((EnumProperty) nv).getArgsList();
                    updatePropertySheet(propertySheet);
                }));
            });
            if (argsList[0] != null)
                for (List l : argsList) {
                    list.removeIf(item -> !l.contains(((BeanProperty) item).getPropertyDescriptor().getName()));
                }
            for (Item i : list) {
                if (i instanceof BeanProperty && ((BeanProperty) i).getPropertyDescriptor() instanceof ValidatedPropertyDescriptor) {
                    BeanProperty bi = (BeanProperty) i;
                    bi.setEditable(((ValidatedPropertyDescriptor) bi.getPropertyDescriptor()).isEditable());
                }
                if (i.getName().equals("Name")) {
                    i.getObservableValue().ifPresent(ov -> ov.addListener((a, b, v) ->
                            Platform.runLater(() -> labelModuleName.setText(v.toString()))));
                }

            }
            propertySheet.getItems().setAll(list.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())));
        });
        service.start();
    }

    public ObservableList<Node> getExtension() {
        return extension.getChildren();
    }

    @Override
    public void setModel(IModuleModel model) {
        super.setModel(model);
        this.labelModuleName.setText(model.getName());
    }

    /**
     * @author: Ákos Hervay(akoshervay@gmail.com)
     */


    public static class ConnectorMap extends HashMap<Side, List<ModuleConnector>> {

        public void addConnector(ModuleConnector.ConnectorType type, Side side, int priority) {
            if (!containsKey(side))
                put(side, new ArrayList<>());
            get(side).add(new ModuleConnector(type, side, priority));
        }

    }
}
