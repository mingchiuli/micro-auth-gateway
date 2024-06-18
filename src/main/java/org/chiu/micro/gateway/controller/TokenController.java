package org.chiu.micro.gateway.controller;

import org.chiu.micro.gateway.lang.Result;
import org.chiu.micro.gateway.service.TokenService;
import org.chiu.micro.gateway.vo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author mingchiuli
 * @create 2023-03-29 12:58 am
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    @GetMapping("/refresh")
    @PreAuthorize("hasAuthority('token:refresh')")
    public Result<Map<String, String>> refreshToken() {
        return Result.success(tokenService::refreshToken);
    }

    @GetMapping("/userinfo")
    @PreAuthorize("hasAuthority('token:userinfo')")
    public Result<UserInfoVo> userinfo() {
        return Result.success(tokenService::userinfo);
    }
}
