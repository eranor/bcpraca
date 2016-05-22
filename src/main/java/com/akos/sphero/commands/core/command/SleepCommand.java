package com.akos.sphero.commands.core.command;

import com.akos.sphero.common.internal.DeviceCommand;
import com.akos.sphero.common.internal.ids.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */
public class SleepCommand extends DeviceCommand {

    private static final long serialVersionUID = 7178864053645635274L;
    private final int time;
    private final int macroId;
    private final int orbBasicLine;

    public SleepCommand(int time, int macroId, int orbBasicLine) {
        super(VirtualDeviceId.CORE, CoreCommandId.SLEEP);
        this.time = time;
        this.macroId = macroId;
        this.orbBasicLine = orbBasicLine;
        this.setResponseRequested(true);
    }

    public int getWakeUpTime() {
        return this.time;
    }

    @Override
    public byte[] getData() {
        return new byte[]{(byte) (this.time >> 8), (byte) this.time, (byte) this.macroId, (byte) this.orbBasicLine};
    }

    public enum SleepType {
        NORMAL(0),
        DEEP(1),
        LOW_POWER(2);

        private final byte value;

        SleepType(int value) {
            this.value = (byte) value;
        }

        public static SleepType sleepTypeForByte(byte b) {
            switch (b) {
                case 0:
                    return NORMAL;
                case 1:
                    return DEEP;
                default:
                    throw new IllegalArgumentException(String.format("Byte %d is not a valid value for SleepType", new Object[]{Byte.valueOf(b)}));
            }
        }
    }
}
