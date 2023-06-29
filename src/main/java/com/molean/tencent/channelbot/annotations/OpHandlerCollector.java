package com.molean.tencent.channelbot.annotations;

import com.molean.tencent.channelbot.BotRegistrationProvider;
import com.molean.isletopia.framework.annotations.IBeanHandler;

import java.util.HashSet;

public class OpHandlerCollector implements IBeanHandler {

    @Override
    public void handle(Object object) {
        if (object.getClass().isAnnotationPresent(OpHandlerTarget.class)) {
            OpHandlerTarget annotation = object.getClass().getAnnotation(OpHandlerTarget.class);
            Class<?> value = annotation.value();
            if (object instanceof OpHandler<?> opHandler) {
                if (!BotRegistrationProvider.INSTANCE.getOpHandlerMap().containsKey(value)) {
                    BotRegistrationProvider.INSTANCE.getOpHandlerMap().put(value, new HashSet<>());
                }
                BotRegistrationProvider.INSTANCE.getOpHandlerMap().get(value).add((OpHandler<Object>) opHandler);
            }
        }
    }
}
