package com.example.demo.controller;

import cn.hutool.http.server.HttpServerRequest;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    HttpServerRequest request;

    @Autowired
    RedisUtil redisUtil;
}
