package org.chiu.micro.auth.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
public class SecurityUtils {

    @Value("${blog.highest-role}")
    private String highestRole;

    private SecurityUtils(){}

    @SuppressWarnings("unchecked")
    public static List<String> getLoginRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return Collections.emptyList();
        }

        return (List<String>) authentication.getDetails();
    }

    public static Authentication getLoginAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Long getLoginUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return 0L;
        }
        return Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
