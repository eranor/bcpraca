package com.akos.models.modules;

import javafx.beans.property.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */


public class RollModuleModel extends AModuleModel {

    //private int heading;
    private transient IntegerProperty heading;
    private transient ObjectProperty<SliderValue> speedSlider;
    private transient ObjectProperty<RollMode> mode;


    public RollModuleModel() {
        super(ModuleType.RollModule);
        heading = new SimpleIntegerProperty(this, "heading", 0);
        speedSlider = new SimpleObjectProperty<>(this, "speedSlider", null);
        mode = new SimpleObjectProperty<>(this, "mode", null);
    }

    @Override
    public String[] getCompiledValue() {
        String format = String.format("goroll %d,%d,%d", heading.get(), speedSlider.get().getValue(), mode.get().getVal());
        return new String[]{format};
    }

    public int getHeading() {
        return heading.get();
    }

    public IntegerProperty headingProperty() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading.set(heading);
    }

    public SliderValue getSpeedSlider() {
        return speedSlider.get();
    }

    public ObjectProperty<SliderValue> speedSliderProperty() {
        return speedSlider;
    }

    public void setSpeedSlider(SliderValue speedSlider) {
        this.speedSlider.set(speedSlider);
    }

    public RollMode getMode() {
        return mode.get();
    }

    public ObjectProperty<RollMode> modeProperty() {
        return mode;
    }

    public void setMode(RollMode mode) {
        this.mode.set(mode);
    }
}

enum RollMode {
    STOP(0), NORMAL(1), FAST(2);

    private final int val;

    RollMode(int i) {
        this.val = i;
    }

    public int getVal() {
        return val;
    }
}

