package com.example.demo.security;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.common.Const;
import com.example.demo.common.exception.CaptchaException;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码过滤器
 */
@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url=request.getRequestURI();
        if(url.contains("login") && request.getMethod().equals("POST")){
            try {
                // 验证码效验
                validate(request);
            }catch(CaptchaException e){
                // 将错误信息交给登录失败处理器
                loginFailureHandler.onAuthenticationFailure(request,response,e);
            }
        }
        filterChain.doFilter(request,response);
    }


    /**
     * 验证码效验
     * @param request 请求对象
     */
    public void validate(HttpServletRequest request){
     String code= request.getParameter("code"); // input code
     String key = request.getParameter(Const.JWT_KEY); // token key
     // 验证码和Token效验
     if(StringUtils.isBlank(code) || StringUtils.isBlank(key)){
         throw new ClassCastException(Const.INVALID_CODE);
     }
     // 判断验证码是否一致
     if (!code.equals(redisUtil.hashGet(Const.CAPTCHA_KEY,key))){
         throw new ClassCastException(Const.INVALID_CODE);
     }
     // 一次使用验证码
     redisUtil.hashDel(Const.CAPTCHA_KEY,key);
    }
}
