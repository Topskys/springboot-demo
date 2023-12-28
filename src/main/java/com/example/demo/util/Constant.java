package com.example.demo.util;

/**
 * 常量类
 */
public class Constant {

    /**
     * redis存储键值
     */
    public static final String CAPTCHA_KEY="captcha";

    /**
     * CAPTCHA验证码的过期时间
     * 120秒（s）
     */
    public static final long CAPTCHA_EXPIRE_TIME=120;

    /**
     *  验证码错误提示信息
     */
    public static final String INVALID_CODE="验证码错误";

    /**
     * jwt token键值
     */
    public static final String JWT_KEY="Authorization";
    /**
     * 登录成功提示信息
     */
    public static final String LOGIN_SUCCESS="登录成功";
    /**
     * 登录失败提示信息
     */
    public static final String LOGIN_FAIL="登录失败";

    public static final String TOKEN_EXCEPTION="token异常";

    public static final String TOKEN_EXPIRE="token已过期";
    public static final String PlEASE_LOGIN="请先登录";
    public static final String USER_NOT_FOUND="用户名或密码错误";
    public static final String LOGOUT_SUCCESS="退出成功";
}
