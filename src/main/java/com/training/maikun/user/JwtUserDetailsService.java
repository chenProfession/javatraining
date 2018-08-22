package com.training.maikun.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: order
 * @Description:
 * @author: Mr.Cheng
 * @date: 2018/8/12 下午7:53
 */
@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService{
    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /** find the user by username **/
        /** testing **/
        JwtUser user = new JwtUser("111","test","test");
        List<SysRole> roles = new ArrayList<>();
        SysRole sysRole = new SysRole();

        sysRole.setRoleId("admin");
        sysRole.setRoleName("ROLE_ADMIN");

        roles.add(sysRole);
        user.setRoles(roles);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(SysRole role:user.getRoles())
        {
            log.info(role.getRoleName());
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            log.info("loadUserByUsername: " + user);
        }
        user.setAuthorities(authorities);
        log.info("Get the user:" + user);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        return user;
    }
}
