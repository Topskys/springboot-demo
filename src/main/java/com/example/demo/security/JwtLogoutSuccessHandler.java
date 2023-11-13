package com.example.demo.security;

import cn.hutool.json.JSONUtil;
import com.example.demo.common.Const;
import com.example.demo.util.JwtUtil;
import com.example.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登录处理器
 */
@Component
public class JwtLogoutSuccessHandler  implements LogoutSuccessHandler {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 如果还没有退出，则执行退出操作
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        response.setContentType("application/json;charset=utf-8");
        ServletOutputStream outputStream = response.getOutputStream();

        // 将jwt（Authorization）请求头置为空
        response.setHeader(jwtUtil.getHeader(),"");

        Result result=Result.ok().message(Const.LOGOUT_SUCCESS);
        outputStream.write(JSONUtil.toJsonStr(result).getBytes("UTF-8"));
        // 输出流
        outputStream.flush();
        outputStream.close();
    }
}
