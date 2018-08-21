package com.training.maikun.user;

import com.training.maikun.security.JwtTokenTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenTool jwtTokenTool;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public User register(User userToAdd) {
        final String username = userToAdd.getUsername();
        if (username == null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(new Date());
        userToAdd.setRoles(Arrays.asList("ROLE_USER"));
        //userRepository.insert(userToAdd);
        return null;
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenTool.generateToken(userDetails);
        return token;
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
