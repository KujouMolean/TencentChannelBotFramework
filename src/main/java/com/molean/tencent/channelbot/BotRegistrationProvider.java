package com.molean.tencent.channelbot;

import com.molean.isletopia.framework.ClassResolver;
import com.molean.isletopia.framework.ClassScanner;
import com.molean.tencent.channelbot.annotations.*;
import lombok.Getter;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum BotRegistrationProvider {
    INSTANCE;

    private final OpEntityCollector opEntityCollector = new OpEntityCollector();
    private final EventCollector eventCollector = new EventCollector();
    private final OpHandlerCollector opHandlerCollector = new OpHandlerCollector();

    private static boolean init = false;

    public void init(ClassResolver classResolver, ClassScanner classScanner) throws Exception {
        if (init) {
            return;
        }
        init = true;
        Set<Class<?>> classes = classResolver.loadClass(classScanner, "com.molean.tencent.channelbot");
        for (Class<?> aClass : classes) {
            try {
                resolveClass(aClass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resolveClass(Class<?> clazz) throws Exception {
        if (clazz.isAnnotationPresent(OpCode.class)) {
            opEntityCollector.handle(clazz, clazz.getAnnotation(OpCode.class));
        }
        if (clazz.isAnnotationPresent(EventType.class)) {
            eventCollector.handle(clazz, clazz.getAnnotation(EventType.class));
        }
        if (clazz.isAnnotationPresent(OpHandlerTarget.class)) {
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            Object o = declaredConstructor.newInstance();
            opHandlerCollector.handle(o);
        }
    }


    @Getter
    private final Map<String, Class<?>> eventMap = new HashMap<>();
    @Getter
    private final Map<Integer, Class<?>> opEntityMap = new HashMap<>();
    @Getter
    private final Map<Class<?>, Set<OpHandler<Object>>> opHandlerMap = new HashMap<>();


}

