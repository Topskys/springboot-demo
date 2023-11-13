package com.example.demo.security;

import cn.hutool.core.util.StrUtil;
import com.example.demo.common.Const;
import com.example.demo.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwt效验过滤器
 * 自定义过滤器
 * BasicAuthenticationFilter
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    @Autowired
    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String jwt = request.getParameter(jwtUtil.getHeader());
        if(StrUtil.isBlankOrUndefined(jwt)){
            chain.doFilter(request, response);
            return;
        }

        Claims claim= jwtUtil.getClaimsByToken(jwt);
        if(claim==null){
            throw new JwtException(Const.TOKEN_EXCEPTION);
        }
        if(jwtUtil.isTokenExpired(claim)){
            throw new JwtException(Const.TOKEN_EXPIRE);
        }

        String username=claim.getSubject();
        // TODO 获取用户权限信息
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,null,null);
        // 将用户信息放置上下文中
        SecurityContextHolder.getContext().setAuthentication(token);
        // next
        chain.doFilter(request, response);
    }


}
