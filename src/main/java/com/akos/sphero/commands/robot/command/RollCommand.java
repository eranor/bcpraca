package com.akos.sphero.commands.robot.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;
import com.akos.sphero.utils.Utils;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class RollCommand extends DeviceCommand {
    private final float heading;
    private final float velocity;
    private final State state;

    public RollCommand(float heading, float velocity) {
        this(heading, velocity, State.GO);
    }

    public RollCommand(float heading, float velocity, State state) {
        super(VirtualDeviceId.ROBOT, RobotCommandId.ROLL);
        if (state == State.STOP) {
            this.velocity = 0.0F;
        } else {
            this.velocity = Utils.limit(velocity, 0.0f, 1.0f);
        }

        this.state = state;
        this.heading = (float) ((int) heading % 360);
        this.setResponseRequested(false);
    }

    public RollCommand(byte[] packet) {
        this.velocity = (float) packet[6] / 255.0F;
        this.heading = (float) ((packet[7] << 8) + packet[8]);
        this.state = State.stateWithByte(packet[9]);
        this.setResponseRequested(false);
    }

    public float getHeading() {
        return this.heading;
    }

    public float getVelocity() {
        return this.velocity;
    }

    public State getState() {
        return this.state;
    }

    public byte[] getData() {
        return new byte[]{(byte) ((int) ((double) this.velocity * 255.0D)), (byte) ((int) this.heading >> 8), (byte) ((int) this.heading), this.state.getValue()};
    }

    public String toString() {
        return "<" + super.toString() + " h:" + this.heading + " v:" + this.velocity + " " + this.state;
    }


    public enum State {
        STOP(0),
        GO(1),
        CALIBRATE(2);

        private byte a;

        State(int value) {
            this.a = (byte) value;
        }

        public byte getValue() {
            return this.a;
        }

        public static State stateWithByte(byte b) {
            return STOP.getValue() == b ? STOP : (GO.getValue() == b ? GO : (CALIBRATE.getValue() == b ? CALIBRATE : null));
        }
    }

}
