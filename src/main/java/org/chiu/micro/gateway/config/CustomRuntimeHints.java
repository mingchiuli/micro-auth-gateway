package org.chiu.micro.gateway.config;

import lombok.SneakyThrows;

import org.chiu.micro.gateway.dto.StompMessageDto;
import org.chiu.micro.gateway.vo.LoginSuccessVo;
import org.chiu.micro.gateway.vo.UserInfoVo;
import org.springframework.aot.hint.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.LinkedHashSet;


public class CustomRuntimeHints implements RuntimeHintsRegistrar {

    @SneakyThrows
    @Override// Register method for reflection
    public void registerHints(@NonNull RuntimeHints hints, @Nullable ClassLoader classLoader) {
        // Register method for reflection
    
        hints.reflection().registerConstructor(LinkedHashSet.class.getDeclaredConstructor(), ExecutableMode.INVOKE);

        hints.serialization().registerType(LoginSuccessVo.class);
        hints.serialization().registerType(UserInfoVo.class);

        //CustomStompSessionHandlerAdapter使用
        hints.serialization().registerType(StompMessageDto.class);

        // Register resources
        hints.resources().registerPattern("script/email-phone.lua");
        hints.resources().registerPattern("script/password.lua");
        hints.resources().registerPattern("script/statistics.lua");
        hints.resources().registerPattern("script/save-code.lua");
    }
}
