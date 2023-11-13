package com.example.demo.service;

import com.example.demo.domain.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 根据用户编号获取用户权限
     * @param userId
     * @return
     */
    String getUserAuthority(Long userId);

    /**
     * 根据用户名删除用户缓存权限信息
     * @param username
     */
    void clearUserAuthority(String username);

    /**
     * 根据角色编号删除用户缓存权限信息
     * @param roleId
     */
    void clearUserAuthorityByRoleId(Long roleId);

    /**
     * 根据菜单编号删除用户缓存权限信息
     * @param menuId
     */
    void clearUserAuthorityByMenuId(Long menuId);
}
