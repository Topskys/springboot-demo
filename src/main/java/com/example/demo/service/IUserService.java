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

    User getUserByUsername(String username);
}
