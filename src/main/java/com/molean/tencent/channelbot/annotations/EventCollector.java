package com.molean.tencent.channelbot.annotations;

import com.molean.tencent.channelbot.BotRegistrationProvider;
import com.molean.isletopia.framework.annotations.IAnnotationHandler;

public class EventCollector implements IAnnotationHandler<EventType> {
    public void handle(Class<?> clazz, EventType annotation) {
        String value = annotation.value();
        BotRegistrationProvider.INSTANCE.getEventMap().put(value, clazz);
    }
}
