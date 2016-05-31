package com.akos.gui.controllers.right_panel;

import com.akos.gui.jfx_components.NumericField;
import com.akos.modules.specific.SliderValue;
import javafx.beans.property.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.PropertyEditor;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class SliderPropertyEditor<T> implements PropertyEditor<T> {

    private HBox editor;
    private PropertySheet.Item item;
    private ObjectProperty<T> value = new SimpleObjectProperty<>();
    private NumericField numericField;

    public SliderPropertyEditor(PropertySheet.Item item) {
        this.item = item;
        if (item.getValue() != null) {
            editor = createEditorPane((SliderValue) item.getValue());
            value.set((T) item.getValue());
        } else {
            editor = createEditorPane(new SliderValue(0, 100, 50));
        }
    }

    private HBox createEditorPane(SliderValue sv) {
        HBox box = new HBox();
        box.setSpacing(5);
        numericField = new NumericField(Integer.class);
        numericField.setAlignment(Pos.CENTER);
        numericField.setPrefWidth(40);
        Slider slider = new Slider(sv.getMin(), sv.getMax(), sv.getValue());
        slider.setMajorTickUnit(Math.floorDiv(sv.getMax(), 4));
        slider.setMinorTickCount(sv.getMax() < 10 ? 1 : 10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setSnapToTicks(true);
        slider.valueProperty().bindBidirectional(numericField.valueProperty());
        slider.setValue(sv.getValue());
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            sv.setValue(newValue.intValue());
            item.setValue(sv);
        });
        box.getChildren().addAll(numericField, slider);
        return box;
    }

    @Override
    public Node getEditor() {
        return editor;
    }

    @Override
    public T getValue() {
        return this.value.get();
    }

    @Override
    public void setValue(T value) {
        this.value.set(value);
    }
}
