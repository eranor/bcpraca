package com.akos.models.services;

import com.akos.gui.modules.AbstractFunctionModule;
import com.akos.sphero.Robot;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.*;
import javafx.geometry.Point2D;

import java.util.*;

/**
 * Created by Ákos on 2015. 12. 07.
 * Email: akoshervay@gmail.com
 */


public class InMemoryMainService implements MainService {

    private Map<UUID, Program> programs;
    private SimpleObjectProperty<Program> currentProgram;
    private ObservableSet<Program> programSet = FXCollections.observableSet();

    private SimpleObjectProperty<AbstractFunctionModule> selectedModule;
    private SelectionModel selectionModel = new SelectionModel();

    private SimpleObjectProperty<Robot> robot;

    private SimpleObjectProperty<Point2D> cursorPosition;


    public InMemoryMainService() {
        System.out.println("MainService initialized...");
        programs = new HashMap<>();
        currentProgram = new SimpleObjectProperty<>(this, "currentProgram", null);
        robot = new SimpleObjectProperty<>(this, "robot", null);
        selectedModule = new SimpleObjectProperty<>(this, "selected", null);
        cursorPosition = new SimpleObjectProperty<>(this, "cursorPosition");
    }

    @Override
    public ObservableSet<Program> getPrograms() {
        return programSet;
    }

    @Override
    public boolean updatePrograms(Program program) {
        if (!programs.containsValue(program)) {
            programs.put(program.getId(), program);
            programSet.add(program);
            return true;
        }
        return false;
    }

    @Override
    public void setCurrentProgram(Program program) {
        currentProgram.set(program);
    }

    @Override
    public Program getCurrentProgram() {
        return hasActiveProgram() ? currentProgram.get() : null;
    }

    @Override
    public boolean hasActiveProgram() {
        return currentProgram != null;
    }

    public SimpleObjectProperty<Program> currentProgramProperty() {
        return currentProgram;
    }

    @Override
    public Robot getRobot() {
        return robot.get();
    }

    public SimpleObjectProperty<Robot> robotProperty() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot.set(robot);
    }

    public AbstractFunctionModule getSelectedModule() {
        return selectedModule.get();
    }

    public SimpleObjectProperty<AbstractFunctionModule> selectedModuleProperty() {
        return selectedModule;
    }

    public void setSelectedModule(AbstractFunctionModule selectedModule) {
        this.selectedModule.set(selectedModule);
    }

    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    @Override
    public Point2D getCursorPosition() {
        return cursorPosition.get();
    }

    @Override
    public SimpleObjectProperty<Point2D> cursorPositionProperty() {
        return cursorPosition;
    }

    public void setCursorPosition(Point2D cursorPosition) {
        this.cursorPosition.set(cursorPosition);
    }
}
