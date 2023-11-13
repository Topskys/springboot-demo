package com.example.demo.service;

import com.example.demo.domain.po.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单资源表 服务类
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
public interface IMenuService extends IService<Menu> {

    List<Long> getNavMenuIds(Long userId);

    List getMenuRoutes();
}
