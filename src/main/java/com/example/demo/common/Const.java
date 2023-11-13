package com.example.demo.common;

/**
 * 常量类
 */
public class Const {

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
}
