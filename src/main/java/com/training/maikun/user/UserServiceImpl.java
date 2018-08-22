package com.training.maikun.user;

import com.training.maikun.enums.ResultEnum;
import com.training.maikun.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: order
 * @Description: implement the user service
 * @author: Mr.Cheng
 * @date: 2018/8/21 下午8:04
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SysRoleRepository sysRoleRepository;
    /**
     * @param username
     * @Description: find the user information by user name
     * @Param: [username]
     * @return: com.training.maikun.user.User
     * @Author: Mr.Cheng
     * @Date: 2018/8/21 下午7:59
     */
    @Override
    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * @param userid
     * @Description: find the user information by user id
     * @Param: [userid]
     * @return: com.training.maikun.user.User
     * @Author: Mr.Cheng
     * @Date: 2018/8/21 下午7:59
     */
    @Override
    public User findUserById(String userid) {
        return userRepository.findById(userid).get();
    }

    public UserServiceImpl() {
    }

    /**
     * @param user
     * @Description: user registration
     * @Param: [user]
     * @return: com.training.maikun.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2018/8/21 下午8:00
     */
    @Override
    public ResultView userRegister(User user) {
        User result = userRepository.saveAndFlush(user);
        ResultView resultView = new ResultView();
        if(result != null){
            resultView.setCode(ResultEnum.SUCCESS.getCode());
            resultView.setMsg(ResultEnum.SUCCESS.getMessage());
        }else {
            resultView.setCode(ResultEnum.FAILURE.getCode());
            resultView.setMsg(ResultEnum.FAILURE.getMessage());
        }
        return resultView;
    }

    /**
     * @param role
     * @Description: find the system role by id
     * @Param: [role]
     * @return: com.training.maikun.user.SysRole
     * @Author: Mr.Cheng
     * @Date: 2018/8/21 下午8:03
     */
    @Override
    public SysRole findRolebyId(String role) {
        return sysRoleRepository.findByRoleId(role);
    }

    /**
     * @param sysRole
     * @Description: add the system role
     * @Param: [sysRole]
     * @return: com.training.maikun.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2018/8/21 下午8:03
     */
    @Override
    public ResultView addSystemRole(SysRole sysRole) {
        SysRole result = sysRoleRepository.saveAndFlush(sysRole);
        ResultView resultView = new ResultView();
        if(result != null){
            resultView.setCode(ResultEnum.SUCCESS.getCode());
            resultView.setMsg(ResultEnum.SUCCESS.getMessage());
        }else {
            resultView.setCode(ResultEnum.FAILURE.getCode());
            resultView.setMsg(ResultEnum.FAILURE.getMessage());
        }
        return resultView;
    }
}
