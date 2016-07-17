package com.akos.services;

import com.akos.modules.AbstractFunctionModule;
import com.akos.sphero.Robot;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableSet;
import javafx.geometry.Point2D;


/**
 * Created by Ákos on 2015. 12. 07.
 * Email: akoshervay@gmail.com
 */

public interface MainService {

    /**
     * Return a sorted set of all currently loaded
     * programs in the IDLE.
     *
     * @return
     */
    ObservableSet<Program> getPrograms();

    /**
     * Add the programs to the list of programs.
     *
     * @param program
     */
    boolean updatePrograms(Program program);


    /**
     * Set the currently active program in the service.
     *
     * @param program
     */
    void setCurrentProgram(Program program);


    /**
     * Get the currently active Program in the service
     */
    Program getCurrentProgram();

    SimpleObjectProperty<Program> currentProgramProperty();

    /**
     * Checks if the service has an active Program set.
     *
     * @return boolean
     */
    boolean hasActiveProgram();

    /**
     * Getter for accessing the currently set
     * Robot in the robotProperty.
     *
     * @return currentRobot
     */
    Robot getRobot();


    /**
     * Simple property for the robot, for easier
     * listnening on state change.
     *
     * @return null
     */
    SimpleObjectProperty<Robot> robotProperty();

    /**
     * Set the currently active robot
     *
     * @param robot Sphero robot
     */
    void setRobot(Robot robot);


    AbstractFunctionModule getSelectedModule();

    SimpleObjectProperty<AbstractFunctionModule> selectedModuleProperty();

    void setSelectedModule(AbstractFunctionModule selectedModule);

    SelectionModel getSelectionModel();

    Point2D getCursorPosition();

    SimpleObjectProperty<Point2D> cursorPositionProperty();

    void setCursorPosition(Point2D cursorPosition);

}
