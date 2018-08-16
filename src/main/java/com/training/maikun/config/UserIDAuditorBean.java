package com.training.maikun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @program: user information
 * @Description: to get the user information for @CreateBy and @LastModifiedBy
 * @author: Mr.Cheng
 * @date: 2018/8/16 上午12:17
 */
//@Configuration
public class UserIDAuditorBean implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
            return null;
        }
        if (ctx.getAuthentication() == null) {
            return null;
        }
        if (ctx.getAuthentication().getPrincipal() == null) {
            return null;
        }
        Object principal = ctx.getAuthentication().getPrincipal();
        if (principal.getClass().isAssignableFrom(Long.class)) {
            return (Optional<Long>) principal;
        } else {
            return null;
        }
    }
}
