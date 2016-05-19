package com.akos.models.services;

import javafx.beans.property.*;
import javafx.collections.*;
import javafx.scene.Node;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class SelectionModel {

    SetProperty<Node> selection = new SimpleSetProperty<>(this, "selection", FXCollections.observableSet());
    SimpleObjectProperty<Node> selectedNode = new SimpleObjectProperty<>(this, "selectedNode", null);

    public SelectionModel add(Node node) {
        node.setStyle("-fx-effect: dropshadow(three-pass-box, red, 10, 10, 0, 0);");
        selection.get().add(node);
        return this;
    }

    public SelectionModel remove(Node node) {
        node.setStyle("-fx-effect: null");
        selection.get().remove(node);
        return this;
    }

    public SelectionModel clear() {
        while (!selection.get().isEmpty()) {
            remove(selection.get().iterator().next());
        }
        return this;
    }

    public boolean contains(Node node) {
        return selection.get().contains(node);
    }

    public int selectedCount() {
        return getSelection().size();
    }

    public ObservableSet<Node> getSelection() {
        return selection.get();
    }

    public SetProperty<Node> selectionProperty() {
        return selection;
    }

    public void setSelection(ObservableSet<Node> selection) {
        this.selection.set(selection);
    }

    public Node getSelectedNode() {
        return selectedNode.get();
    }

    public SimpleObjectProperty<Node> selectedNodeProperty() {
        return selectedNode;
    }

    public void setSelectedNode(Node selectedNode) {
        this.selectedNode.set(selectedNode);
    }
}

