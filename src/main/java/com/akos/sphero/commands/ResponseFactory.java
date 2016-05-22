package com.akos.sphero.commands;

import com.akos.sphero.commands.core.response.*;
import com.akos.sphero.commands.robot.response.*;
import com.akos.sphero.commands.robot.response.orbbasic.*;
import com.akos.sphero.common.ByteResponse;
import com.akos.sphero.common.internal.*;
import com.akos.sphero.common.internal.ids.*;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class ResponseFactory {
    private static final String a = "obx-rfactory";
    private static final Map<Byte, Class<? extends DeviceResponse>> robotResponseMap = new HashMap();
    private static final Map<Byte, Class<? extends DeviceResponse>> coreResponseMap = new HashMap();
    private static final Map<Byte, Class<? extends DeviceResponse>> otherResponseMap = new HashMap();
    private static ResponseFactory instance;

    public static void register(VirtualDeviceId deviceId, Id commandId, Class<? extends DeviceResponse> responseClass) {
        if (deviceId == VirtualDeviceId.ROBOT) {
            robotResponseMap.put(commandId.getValue(), responseClass);
        } else if (deviceId == VirtualDeviceId.CORE) {
            coreResponseMap.put(commandId.getValue(), responseClass);
        } else {
            otherResponseMap.put(commandId.getValue(), responseClass);
        }

    }

    private ResponseFactory() {
    }

    public static synchronized ResponseFactory getInstance() {
        if (instance == null) {
            instance = new ResponseFactory();
        }
        return instance;
    }

    public DeviceResponse responseFromRawPacket(byte[] packet, DeviceCommand command) {
        if (command == null) {
            //DLog.v("Command could not be found for sequence number: %02X", new Object[]{Byte.valueOf(packet[3])});
        }
        if (packet == null) {
            throw new IllegalArgumentException("Argument \"packet\" cannot be null");
        } else if (command != null && !command.getClass().equals(DeviceCommand.class)) {
            Class aClass = this.getDeviceResponse(command);
            return this.getDeviceResponse(aClass, packet, command);
        } else {
            //Log.v("obx-rfactory", "Base device command response created");
            return new ByteResponse(packet, command);
        }
    }


    private Class<? extends DeviceResponse> getDeviceResponse(DeviceCommand command) {
        Class responseClass = null;
        byte deviceId = command.getDeviceId();
        if (deviceId == VirtualDeviceId.ROBOT.getValue()) {
            responseClass = (Class) robotResponseMap.get(command.getCommandId());
        } else if (deviceId == VirtualDeviceId.CORE.getValue()) {
            responseClass = (Class) coreResponseMap.get(command.getCommandId());
        } else if (deviceId == VirtualDeviceId.BOOTLOADER.getValue()) {
            responseClass = (Class) otherResponseMap.get(command.getCommandId());
        }
        return responseClass;
    }


    private DeviceResponse getDeviceResponse(Class<? extends DeviceResponse> response, byte[] packet, DeviceCommand command) {
        if (response == null) {
            //DLog.w("Response class is null, creating getDeviceResponse byte response...");
            return new ByteResponse(packet, command);
        } else {
            Constructor constructor = this.getDeviceResponse(response);
            if (constructor == null) {
                //DLog.w("Constructor was null for response, creating getDeviceResponse byte response...");
                return new ByteResponse(packet, command);
            } else {
                DeviceResponse newResponse = this.getDeviceResponse(constructor, packet, command);
                if (newResponse == null) {
                    //DLog.w("Could not create getDeviceResponse response from the constructor, creating getDeviceResponse byte response...");
                    return new ByteResponse(packet, command);
                } else {
                    return newResponse;
                }
            }
        }
    }


    private Constructor<? extends DeviceResponse> getDeviceResponse(Class<? extends DeviceResponse> response) {
        Constructor constructor = null;
        try {
            constructor = response.getDeclaredConstructor(byte[].class, DeviceCommand.class);
        } catch (NoSuchMethodException var4) {
            //DLog.e("Could not get declared constructor of response class: %s. Reason: %s", new Object[]{response, var4.getMessage()});
        }
        return constructor;
    }


    private DeviceResponse getDeviceResponse(Constructor<? extends DeviceResponse> response, byte[] packet, DeviceCommand command) {
        DeviceResponse newResponse = null;

        try {
            newResponse = response.newInstance(packet, command);
        } catch (InvocationTargetException e) {
            //DLog.e("Could not build response for command %s. Reason: %s", new Object[]{command, var8.getMessage()});
        } catch (InstantiationException e) {
            //DLog.e("Could not build response for command %s. Reason: %s", new Object[]{command, var9.getMessage()});
        } catch (IllegalAccessException e) {
            if (!response.isAccessible()) {
                response.setAccessible(true);

                try {
                    newResponse = response.newInstance(packet, command);
                } catch (Exception ex) {
                    //DLog.e("Could not instantiate getDeviceResponse response after changing access level");
                }
            }
        }

        return newResponse;
    }

    static {
        //register(VirtualDeviceId.BOOTLOADER, (byte) 4, JumpToMainResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.JUMP_TO_BOOTLOADER, JumpToBootloaderResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.PING, PingResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.VERSIONING, VersioningResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.SLEEP, SleepResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.GET_BLUETOOTH_INFO, GetBluetoothInfoResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.SET_BLUETOOTH_NAME, SetDeviceNameResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.LEVEL_1_DIAGNOSTICS, PreformLevel1DiagnosticsResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.POLL_PACKET_TIMES, PollPacketTimesResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.GET_POWER_STATE, GetPowerStateResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.SET_POWER_NOTIFICATION, SetPowerNotificationResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.SET_INACTIVITY_TIMEOUT, SetInactivityTimeoutResponse.class);
        register(VirtualDeviceId.CORE, CoreCommandId.GET_CHARGER_STATE, GetPowerStateResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.BOOST, BoostResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.BACK_LED_OUTPUT, SetBackLEDOutputResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.SET_HEADING, SetHeadingResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.RGB_LED_OUTPUT, RGBLEDOutputResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.ROLL, RollResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.ROTATION_RATE, SetRotationRateResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.STABILIZATION, SetStabilizationResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.RUN_MACRO, RunMacroResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.SAVE_TEMPORARY_MACRO, SaveTemporaryMacroResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.ABORT_MACRO, AbortMacroResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.RAW_MOTOR, RawMotorResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.SAVE_MACRO, SaveMacroResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.SET_DATA_STREAMING, SetDataStreamingResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.SAVE_TEMPORARY_MACRO_CHUNK, SaveTemporaryMacroChunkResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.INIT_MACRO_EXECUTIVE, InitMacroExecutiveResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.CONFIGURE_COLLISION_DETECTION, ConfigureCollisionDetectionResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.CONFIGURE_LOCATOR, ConfigureLocatorResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.GET_LED_COLOR, GetUserRGBColorResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.GET_DEVICE_MODE, GetDeviceModeResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.SET_DEVICE_MODE, SetUserHackModeResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.SELF_LEVEL, SelfLevelResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.SET_MOTION_TIMEOUT, SetMotionTimeoutResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.ORB_BASIC_ERASE_STORAGE, EraseOrbBasicStorageResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.ORB_BASIC_APPEND_FRAGMENT, AppendOrbBasicFragmentResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.ORB_BASIC_EXECUTE_PROGRAM, ExecuteOrbBasicProgramResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.ORB_BASIC_ABORT_PROGRAM, AbortOrbBasicProgramResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.GET_ODOMETER, GetOdometerResponse.class);
        //register(VirtualDeviceId.ROBOT, RobotCommandId.GET_SKU, GetSkuResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.GET_CHASSIS_ID, GetChassisIdResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.GET_OPTION_FLAGS, GetPermanentOptionFlagsResponse.class);
        register(VirtualDeviceId.ROBOT, RobotCommandId.SET_OPTION_FLAGS, SetPermanentOptionFlagsResponse.class);
        //register(VirtualDeviceId.ROBOT, (byte) 55, NonPersistentSetOptionFlagsResponse.class);
        //register(VirtualDeviceId.ROBOT, (byte) 56, NonPersistentGetOptionFlagsResponse.class);
    }
}
