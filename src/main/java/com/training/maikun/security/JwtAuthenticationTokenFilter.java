package com.training.maikun.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: order
 * @Description: make JWT token
 * @author: Mr.Cheng
 * @date: 2018/8/12 下午10:17
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Qualifier("jwtUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenTool jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("i am starting to work");

        /** testing **/
//        UserDetails userDetailsTest = this.userDetailsService.loadUserByUsername("test");
//        UsernamePasswordAuthenticationToken authenticationTest = new UsernamePasswordAuthenticationToken(userDetailsTest, null, userDetailsTest.getAuthorities());
//        authenticationTest.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//        logger.info("authenticated user :" + "test" + ", setting security context:" + authenticationTest);
//        SecurityContextHolder.getContext().setAuthentication(authenticationTest);

        /** testing end **/

        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(tokenHead)) {
            final String authToken = authHeader.substring(tokenHead.length());
            // The part after "Bearer "
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            logger.info("checking authentication " + username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
