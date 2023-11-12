package com.example.demo.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单资源表
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
@Data
@TableName("tb_menu")
public class Menu extends Base {



    /**
     * 菜单标题
     */
    private String title;

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
     * 权限标识
     */
    private String perms;

    /**
     * 重定向
     */
    private String redirect;

    /**
     * 是否固定（在多页导航栏）
     */
    private Integer affix;

    /**
     * 是否外链（1-是，0-否）
     */
    private Integer isFrame;

    /**
     * 是否内嵌（1-是，0-否）
     */
    private Integer isLink;

    /**
     * 外链地址（1-是，0-否）
     */
    private Integer linkUrl;

    /**
     * 是否隐藏（1-是，0-否）
     */
    private Integer hidden;

    /**
     * 资源类型（0-目录，1-菜单，2-按钮）
     */
    private Integer type;

    /**
     * 不缓存页面（1-是，0-否）
     */
    private Integer noCache;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态（备用字段）
     */
    private String status;
}
