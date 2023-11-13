package com.example.demo.service.impl;

import com.example.demo.domain.po.Menu;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单资源表 服务实现类
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public List<Long> getNavMenuIds(Long userId) {
        return null;
    }
}
