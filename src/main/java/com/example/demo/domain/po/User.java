package com.example.demo.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
@Data
@TableName("tb_user")
public class User extends Base {

    /**
     * 登录账户名（用户名）
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别(0-男，1-女)
     */
    private Integer gender;

    /**
     * 部门编号
     */
    private Long departmentId;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 账户过期时间
     */
    private String accountExpiredTime;

    /**
     * 是否是管理员账号,1-是,0-否
     */
    private Integer isAdmin;

    /**
     * 帐户是否过期(0-未过期，1-已过期)
     */
    private Integer isAccountNonExpired;

    /**
     * 帐户是否被锁定(0-未锁定，1-已已锁定)
     */
    private Integer isAccountNonLocked;

}
