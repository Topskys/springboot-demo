package com.example.demo.controller;


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

    @GetMapping
    String getHiString(){
        return "Hello World";
    }
}
