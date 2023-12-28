package com.example.demo.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名（账号）
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;

    /**
     * 删除（0-未删除，1-已删除）
     */
    private Integer isDelete;

    /**
     * （0-男，1-女）
     */
    private Integer gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 描述（备注）
     */
    private String description;

    /**
     * 账号是否过期（0-未过期，1-过期）
     */
    private Integer isAccountNonExpired;

    /**
     * 账号是否被锁定（0-未锁定，1-已锁定）
     */
    private Integer isAccountNonLocked;

    /**
     * 账号过期时间
     */
    private String accountExpiredTime;

    /**
     * 是否启用（0-未启用，1-未启用）
     */
    private Integer enabled;

    /**
     * 创建者的编号
     */
    private Long createUser;

    /**
     * 创建者的编号
     */
    private Long updateUser;


}
