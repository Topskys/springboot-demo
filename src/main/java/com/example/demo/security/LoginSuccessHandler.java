package com.example.demo.security;

import cn.hutool.json.JSONUtil;
import com.example.demo.util.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 登录失败的处理逻辑
        response.setContentType("application/json;charset=utf-8");
        ServletOutputStream outputStream = response.getOutputStream();
        // 生成Token，并放置请求头
        Result result=Result.ok().message("");
        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));
        // 输出流
        outputStream.flush();
        outputStream.close();
    }
}
