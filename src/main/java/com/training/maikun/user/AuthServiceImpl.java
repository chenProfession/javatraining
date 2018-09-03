package com.training.maikun.user;

import com.training.maikun.result.ResultView;
import com.training.maikun.security.JwtTokenTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * @program: order
 * @Description:
 * @author: Mr.Cheng
 * @date: 2018/8/13 上午11:55
 */
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenTool jwtTokenTool;

    @Autowired
    private UserService userService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public ResultView register(User userToAdd) {
        final String username = userToAdd.getUsername();
        if (username == null) {
            return null;
        }

        SysRole sysRole = new SysRole();
        sysRole.setRoleId(0);
        sysRole.setRoleName("ROLE_USER");

        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(rawPassword);
        userToAdd.setRoles(Arrays.asList(sysRole));

        ResultView resultView = userService.userRegister(userToAdd);
        return resultView;
    }

    @Override
    public String login(String username, String password) {

        Authentication upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);

        if (!authentication.isAuthenticated())
        {
            log.error("username or password is wrong");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenTool.generateToken(userDetails);
        return tokenHead + token;
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenTool.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenTool.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            return jwtTokenTool.refreshToken(token);
        }
        return null;
    }
}
