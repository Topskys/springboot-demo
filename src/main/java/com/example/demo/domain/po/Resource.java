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
 * 菜单资源表
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_resource")
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单资源编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单标题
     */
    private String title;

    /**
     * 父级菜单名称
     */
    private String parentName;

    /**
     * 父级菜单编号
     */
    private Long parentId;

    /**
     * 菜单路由名称
     */
    private String name;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 可访问角色标识字符串（权限标识）
     */
    private String code;

    /**
     * 重定向
     */
    private String redirect;

    /**
     * 是否固定（在多页导航栏）
     */
    private Integer affix;

    /**
     * 是否外链
     */
    private Integer isFrame;

    /**
     * 是否内嵌
     */
    private Integer isLink;

    /**
     * 外链地址
     */
    private Integer linkUrl;

    /**
     * 是否隐藏
     */
    private Integer hidden;

    /**
     * 资源类型，0-目录，1-菜单，2-按钮
     */
    private Integer type;

    /**
     * 页面是否缓存(1-不缓存，0-缓存)
     */
    private Integer noCache;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 描述（备注）
     */
    private String description;

    /**
     * 是否启用
     */
    private Integer enabled;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除,1-删除，0-未删除
     */
    private Integer isDelete;

    /**
     * 创建者的编号
     */
    private Long createUser;

    /**
     * 创建者的编号
     */
    private Long updateUser;


}
