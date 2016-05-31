package com.akos.modules;

import com.akos.modules.specific.*;
import javafx.util.Pair;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author: Ákos Hervay(akoshervay@gmail.com)
 */

public class ModuleFactory {

    private Map<Type, Pair<Class<? extends AbstractModule>, Class<? extends AModuleModel>>> moduleRegistry;
    private static ModuleFactory instance;

    public static String decapitalize(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }
        char c[] = string.toCharArray();
        c[0] = Character.toLowerCase(c[0]);
        return new String(c);
    }

    public ModuleFactory() {
        moduleRegistry = new HashMap<>();
    }

    public static ModuleFactory getInstance() {
        if (instance == null) {
            instance = new ModuleFactory();
        }
        return instance;
    }

    public void register(Type type, Class<? extends AbstractModule> moduleClass, Class<? extends AModuleModel> modelClass) {
        moduleRegistry.put(type, new Pair<>(moduleClass, modelClass));
    }


    public AbstractModule getModule(Type type) {
        Pair<Class<? extends AbstractModule>, Class<? extends AModuleModel>> classes = moduleRegistry.get(type);
        Constructor<? extends AbstractModule> constructor = null;
        try {
            constructor = classes.getKey().getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            if (constructor != null) {
                AbstractModule object = constructor.newInstance();
                object.setModel(getModelConstructor(classes.getValue()));
                return object;
            } else
                return null;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AModuleModel getModelConstructor(Class<? extends AModuleModel> modelClass) {
        Constructor<? extends AModuleModel> constructor = null;
        try {
            constructor = modelClass.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            if (constructor != null) {
                return constructor.newInstance();
            } else
                return null;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    static {
        ModuleFactory registry = getInstance();
        registry.register(ModuleType.RollModule, RollFunctionModule.class, RollModuleModel.class);
        registry.register(ModuleType.StartModule, StartFunctionModule.class, StartModuleModel.class);
        registry.register(ModuleType.ConditionModule, ConditionFunctionModule.class, ConditionModuleModel.class);
        registry.register(ModuleType.ForLoopModule, ForLoopFunctionModule.class, ForLoopModuleModel.class);
        registry.register(ModuleType.WhileLoopModule, WhileLoopFunctionModule.class, WhileLoopModuleModel.class);
        registry.register(ModuleType.LEDModule, RGBLedFunctionModule.class, RGBLedModuleModel.class);
        registry.register(ModuleType.SleepModule, SleepFunctionModule.class, SleepModuleModel.class);
        registry.register(ModuleType.TimerModule, TimerFunctionModule.class, TimerModuleModel.class);
        registry.register(ModuleType.EndModule, EndFunctionModule.class, EndModuleModel.class);
        registry.register(ModuleType.EndIfModule, EndIfFunctionModule.class, EndIfModuleModel.class);
        registry.register(ModuleType.InputModule, InputFunctionModule.class, InputModuleModel.class);
        registry.register(ModuleType.PrintModule, PrintFunctionModule.class, PrintModuleModel.class);
        registry.register(ModuleType.LocateModule, LocateFunctionModule.class, LocateModuleModel.class);
        registry.register(ModuleType.VariableModule, VariableFunctionModule.class, VariableModuleModel.class);
    }
}
