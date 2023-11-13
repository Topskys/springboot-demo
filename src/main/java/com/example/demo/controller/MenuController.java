package com.example.demo.controller;


import com.example.demo.service.IMenuService;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单资源表 前端控制器
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @GetMapping
    String getHiString(){
        return "Hello World";
    }


    @GetMapping("/routes")
    @PreAuthorize("hasAuthority('sys:menu:list')")
    Result getMenuRoutes(){

        return null;
    }
}
