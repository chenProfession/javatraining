package com.training.maikun.user;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @program: SysRole
 * @Description: Repository
 * @author: Mr.Cheng
 * @date: 2018/8/14 下午5:15
 */
public interface SysRoleRepository extends JpaRepository<SysRole,String> {

    SysRole findByRoleId(String roleId);
}
