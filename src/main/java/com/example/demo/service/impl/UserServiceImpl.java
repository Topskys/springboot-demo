package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.domain.po.Menu;
import com.example.demo.domain.po.Role;
import com.example.demo.domain.po.User;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    MenuServiceImpl menuService;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public User getUserByUsername(String username) {
        return getOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public String getUserAuthority(Long userId) {

        String authority="";
        User user=userMapper.selectById(userId);
        if(redisUtil.hasKey("GrantedAuthority:"+user.getUsername())){
            // 读取权限标识缓存
            authority=(String) redisUtil.get("GrantedAuthority:"+userId);
        }else {
            // 获取用户角色标识
            List<Role> roles = roleService.list(new QueryWrapper<Role>().inSql("id", "select role_id from user_role where user_id = " + userId));
            if(roles.size() >0){
                String roleCodes=roles.stream().map(r->"ROLE_"+r.getCode()).collect(Collectors.joining(","));
                authority=roleCodes.concat(",");
            }
            // 获取角色权限菜单
            List<Long> menuIds=menuService.getNavMenuIds(userId);
            if(menuIds.size()>0){
                List<Menu> menus=menuService.listByIds(menuIds);
                String menuPerms=menus.stream().map(Menu::getPerms).collect(Collectors.joining(","));
                authority=authority.concat(menuPerms);
            }
            // 设置权限标识缓存
            redisUtil.set("GrantedAuthority:"+user.getUsername(),authority,60*60);
        }
        return authority;
    }

    /**
     * 删除redis权限缓存1
     * @param username
     */
    @Override
    public void clearUserAuthority(String username) {
        redisUtil.del("GrantedAuthority:"+username);
    }

    /**
     * 删除redis权限缓存2
     * @param roleId
     */
    @Override
    public void clearUserAuthorityByRoleId(Long roleId) {
       List<User> users=this.list(new QueryWrapper<User>().inSql("id","select user_id from tb_user_role where role_id = " + roleId));
       users.forEach(user -> {
           redisUtil.del("GrantedAuthority:"+user.getUsername());
       });
    }

    /**
     * 删除redis权限缓存3
     * @param menuId
     */
    @Override
    public void clearUserAuthorityByMenuId(Long menuId) {
        List<User> users= userMapper.listByMenuId(menuId);
        users.forEach(user -> {
            redisUtil.del("GrantedAuthority:"+user.getUsername());
        });
    }
}
