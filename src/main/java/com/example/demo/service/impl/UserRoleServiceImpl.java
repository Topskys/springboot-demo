package com.example.demo.service.impl;

import com.example.demo.domain.po.UserRole;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关系映射表 服务实现类
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
