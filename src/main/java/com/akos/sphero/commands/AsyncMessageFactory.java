package com.akos.sphero.commands;

import com.akos.sphero.commands.async.*;
import com.akos.sphero.commands.async.orbbasic.*;
import com.akos.sphero.common.internal.AsyncResponse;
import com.akos.sphero.common.internal.AsyncResponse.Type;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author: Orbotix
 * @author: Ákos Hervay(akoshervay@gmail.com) (modifier)
 */


public class AsyncMessageFactory {
    private static final Map<Type, Class<? extends AsyncResponse>> asyncResponseMap = new HashMap<Type, Class<? extends AsyncResponse>>();
    private static AsyncMessageFactory asyncMessageFactory;

    public static void register(AsyncResponse.Type dataType, Class<? extends AsyncResponse> asyncDataClass) {
        asyncResponseMap.put(dataType, asyncDataClass);
    }

    private AsyncMessageFactory() {
    }

    public static synchronized AsyncMessageFactory getInstance() {
        if(asyncMessageFactory == null) {
            asyncMessageFactory = new AsyncMessageFactory();
        }
        return asyncMessageFactory;
    }

    public AsyncResponse dataFromPacket(byte[] packet) {
        byte var2 = packet[2];
        Class responseClass = this.a(var2);
        return this.a(responseClass, packet);
    }

    private Class<? extends AsyncResponse> a(byte var1) {
        AsyncResponse.Type var2 = AsyncResponse.Type.fromByte(var1);
        return (Class) asyncResponseMap.get(var2);
    }

    private AsyncResponse a( Class<? extends AsyncResponse> responseClass, byte[] packet) {
        if(responseClass == null) {
            return new AsyncResponse(packet);
        } else {
            Constructor constructor = this.a(responseClass);
            if(constructor == null) {
                //DLog.w("Constructor was null for async message, creating base AsyncMessage...");
                return new AsyncResponse(packet);
            } else {
                AsyncResponse response = this.a(constructor, packet);
                if(response == null) {
                    //DLog.w("Could not create an async message from the constructor, creating base AsyncMessage...");
                    return new AsyncResponse(packet);
                } else {
                    return response;
                }
            }
        }
    }

        private Constructor<? extends AsyncResponse> a(Class<? extends AsyncResponse> responseClass) {
        Constructor constructor = null;

        try {
            constructor = responseClass.getDeclaredConstructor(new Class[]{byte[].class});
        } catch (NoSuchMethodException var4) {
            //DLog.e("Could not get declared constructor of async message class: %s. Reason: %s", new Object[]{responseClass, var4.getMessage()});
        }
        return constructor;
    }

        private AsyncResponse a(Constructor<? extends AsyncResponse> responseClass, byte[] packet) {
            AsyncResponse var3 = null;

        try {
            var3 = responseClass.newInstance(new Object[]{packet});
        } catch (InvocationTargetException var7) {
            //DLog.e("Could not build async message. Reason: %s", new Object[]{var7.getMessage()});
        } catch (InstantiationException var8) {
            //DLog.e("Could not build async message. Reason: %s", new Object[]{var8.getMessage()});
        } catch (IllegalAccessException var9) {
            if(!responseClass.isAccessible()) {
                //DLog.w("Constructor of async message class is not accessible. Overriding access level and retrying...");
                responseClass.setAccessible(true);

                try {
                    var3 = responseClass.newInstance(new Object[]{packet});
                } catch (Exception var6) {
                    //DLog.e("Could not instantiate a response after changing access level");
                }
            }
        }

        return var3;
    }

    static {
        register(Type.MacroEmitMarker, MacroEmitMarker.class);
        register(Type.WillSleepAsyncMessage, SleepWillOccurMessage.class);
        register(Type.DidSleepAsyncMessage, com.akos.sphero.commands.async.SleepDidOccurMessage.class);
        register(Type.L1DiagnosticAsyncMessage, Level1DiagnosticsAsyncData.class);
        register(Type.SensorAsyncMessage, DeviceSensorAsyncMessage.class);
        register(Type.CollisionDetected, CollisionDetectedAsyncData.class);
        register(Type.SelfLevelComplete, SelfLevelCompleteAsyncData.class);
        register(Type.PowerAsyncMessage, PowerNotificationAsyncData.class);
        register(Type.OrbBasicPrint, OrbBasicPrintMessageAsyncData.class);
        register(Type.OrbBasicErrorASCII, OrbBasicErrorASCIIAsyncData.class);
        register(Type.OrbBasicErrorBinary, OrbBasicErrorBinaryAsyncData.class);
        register(Type.GyroLimitsExceeded, GyroLimitsExceededAsyncData.class);
    }
}
