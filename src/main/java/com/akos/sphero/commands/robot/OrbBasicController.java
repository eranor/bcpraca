package com.akos.sphero.commands.robot;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

import com.akos.sphero.Robot;
import com.akos.sphero.commands.async.orbbasic.*;
import com.akos.sphero.commands.robot.command.orbbasic.*;
import com.akos.sphero.commands.robot.response.orbbasic.*;
import com.akos.sphero.common.internal.*;
import org.apache.logging.log4j.*;

import java.util.*;

public class OrbBasicController implements ResponseListener {

    private static final Logger logger = LogManager.getLogger(OrbBasicController.class);

    private boolean storageType = false;
    private int chunkStart;
    private int chunkEnd;
    private byte[] program;
    private boolean programSent;
    private int startingLine;
    private static final String g = "OBX-OrbBasic";
    private Robot robot;
    private HashSet<OrbBasicEventListener> listeners;

    public OrbBasicController(Robot robot) {
        if (null == robot) {
            throw new IllegalArgumentException("NULL Robot Argument");
        } else {
            this.robot = robot;
            this.listeners = new HashSet<>();
            robot.addResponseListener(this);
        }
    }

    public void setProgram(byte[] program) {
        this.program = program;
    }

    public void setOrbBasicControlEventListener(OrbBasicEventListener listener) {
        this.listeners.add(listener);
    }

    public void addEventListener(OrbBasicEventListener listener) {
        this.listeners.add(listener);
    }

    public void removeEventListener(OrbBasicEventListener listener) {
        this.listeners.remove(listener);
    }

    public void clearEventListeners() {
        this.listeners.clear();
    }

    public void loadProgram() {
        if (this.robot == null) {
            throw new IllegalStateException("No Robot defined.");
        } else {
            logger.debug("OBX-OrbBasic", "Begin Loading Program");
            this.chunkStart = 0;
            this.chunkEnd = 0;
            this.programSent = false;
            this.startingLine = this.findStartlineIntegerValue(new String(this.program));
            logger.debug(this.getClass().getName(), "startline " + this.startingLine);
            this.robot.send(new AppendOrbBasicFragmentCommand(this.storageType, this.getPacket()));
        }
    }

    public int findStartlineIntegerValue(String programString) {
        programString = programString.replaceAll("[^0-9]+", " ");
        if (Objects.equals(Arrays.asList(programString.trim().split(" ")).get(0), ""))
            return 1;
        else
            return Integer.parseInt(Arrays.asList(programString.trim().split(" ")).get(0));
    }

    public void eraseStorage() {
        if (this.robot == null) {
            throw new IllegalStateException("No Robot defined.");
        } else {
            this.robot.send(new EraseOrbBasicStorageCommand(this.storageType));
        }
    }

    public void executeProgram() {
        if (this.robot == null) {
            throw new IllegalStateException("No Robot defined.");
        } else {
            logger.debug("OBX-OrbBasic", "Executing Program");
            this.robot.send(new ExecuteOrbBasicProgramCommand(this.storageType, this.startingLine));
        }
    }

    public void abortProgram() {
        if (this.robot == null) {
            throw new IllegalStateException("No Robot defined.");
        } else {
            this.robot.send(new AbortOrbBasicProgramCommand());
        }
    }

    private byte[] getPacket() {
        this.chunkStart = this.chunkEnd;
        boolean maxLengthReached = false;

        for (int i = this.chunkEnd + 1; !maxLengthReached; ++i) {
            if (i >= this.program.length) {
                if (i - this.chunkStart > 252) {
                    logger.debug("OBX-OrbBasic", "Reached Max Length: ");
                    maxLengthReached = true;
                } else {
                    logger.debug("OBX-OrbBasic", "Reached Length: " + this.program.length);
                    this.programSent = true;
                    maxLengthReached = true;
                    this.chunkEnd = i;
                }
            } else if (this.program[i] == 10) {
                if (i - this.chunkStart > 252) {
                    logger.debug("OBX-OrbBasic", "Reached Max Length: ");
                    maxLengthReached = true;
                } else {
                    this.chunkEnd = i + 1;
                }
            }
        }

        byte[] chunkBuffer = new byte[this.chunkEnd - this.chunkStart];

        for (int i = this.chunkStart; i < this.chunkEnd; ++i) {
            chunkBuffer[i - this.chunkStart] = this.program[i];
        }

        logger.debug("OBX-OrbBasic", "Chunk Proccessed: " + new String(chunkBuffer));
        return chunkBuffer;
    }

    public void handleResponse(DeviceResponse response) {
        if (response instanceof AppendOrbBasicFragmentResponse) {
            Iterator iter;
            OrbBasicEventListener eventListener;
            if (response.getResponseCode() == ResponseCode.OK) {
                logger.debug("OBX-OrbBasic", "Fragment Append Success");
                if (!this.programSent) {
                    this.robot.send(new AppendOrbBasicFragmentCommand(this.storageType, this.getPacket()));
                } else {
                    iter = this.listeners.iterator();
                    while (iter.hasNext()) {
                        eventListener = (OrbBasicEventListener) iter.next();
                        eventListener.onLoadProgramComplete(true);
                    }
                }
            } else {
                logger.debug("OBX-OrbBasic", "Fragment Append Fail: " + response.getResponseCode());
                iter = this.listeners.iterator();

                while (iter.hasNext()) {
                    eventListener = (OrbBasicEventListener) iter.next();
                    eventListener.onLoadProgramComplete(false);
                }
            }
        } else if (response instanceof EraseOrbBasicStorageResponse) {
            boolean success = false;
            if (response.getResponseCode() == ResponseCode.OK) {
                success = true;
            }
            for (OrbBasicEventListener eventListener : this.listeners) {
                eventListener.onEraseCompleted(success);
            }
        }

    }

    public void handleStringResponse(String stringResponse) {
    }

    public void handleAsyncMessage(AsyncResponse asyncMessage) {
        Iterator iter;
        OrbBasicEventListener listener;
        if (asyncMessage instanceof OrbBasicPrintMessageAsyncData) {
            iter = this.listeners.iterator();
            while (iter.hasNext()) {
                listener = (OrbBasicEventListener) iter.next();
                OrbBasicPrintMessageAsyncData response = (OrbBasicPrintMessageAsyncData) asyncMessage;
                listener.onPrintMessage(response.getMessage());
            }
        } else if (asyncMessage instanceof OrbBasicErrorASCIIAsyncData) {
            iter = this.listeners.iterator();

            while (iter.hasNext()) {
                listener = (OrbBasicEventListener) iter.next();
                OrbBasicErrorASCIIAsyncData response = (OrbBasicErrorASCIIAsyncData) asyncMessage;
                listener.onErrorMessage(response.getErrorASCII());
            }
        } else if (asyncMessage instanceof OrbBasicErrorBinaryAsyncData) {
            iter = this.listeners.iterator();

            while (iter.hasNext()) {
                listener = (OrbBasicEventListener) iter.next();
                OrbBasicErrorBinaryAsyncData response = (OrbBasicErrorBinaryAsyncData) asyncMessage;
                listener.onErrorByteArray(response.getErrorBinary());
            }
        }

    }
}
