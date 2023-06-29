package com.molean.tencent.channelbot.annotations;

import com.molean.isletopia.framework.annotations.Service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Service
@Retention(RetentionPolicy.RUNTIME)
public @interface OpHandlerTarget {
    Class<?> value();
}
