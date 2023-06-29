package com.molean.tencent.channelbot.annotations;

import com.molean.tencent.channelbot.BotRegistrationProvider;
import com.molean.isletopia.framework.annotations.IAnnotationHandler;

public class OpEntityCollector implements IAnnotationHandler<OpCode>{
    public void handle(Class<?> clazz, OpCode annotation) {
        int value = annotation.value();
        BotRegistrationProvider.INSTANCE.getOpEntityMap().put(value, clazz);
    }
}
