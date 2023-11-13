package com.example.demo.security;

import com.example.demo.common.Const;
import com.example.demo.domain.po.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    IUserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.getUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(Const.USER_NOT_FOUND);
        }

        return new AccountUser(user.getId(), user.getUsername(), user.getPassword(),getUserAuthority(user.getId()));
    }

    /**
     * 获取用户权限信息（角色、菜单权限）
     * @param userId 用户编号
     * @return
     */
    public List<GrantedAuthority> getUserAuthority(Long userId) {
        return null;
    }
}
