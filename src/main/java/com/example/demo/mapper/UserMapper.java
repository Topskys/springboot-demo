package com.example.demo.mapper;

import com.example.demo.domain.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
public interface UserMapper extends BaseMapper<User> {
   List<Long> getNavMenuIds(Long userId);

   List<User> listByMenuId(Long menuId);
}
