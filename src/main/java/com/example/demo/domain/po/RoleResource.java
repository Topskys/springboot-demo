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
 * 角色菜单资源表
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_role_resource")
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色权限编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色编号
     */
    private Long roleId;

    /**
     * 权限资源编号
     */
    private Long resourceId;

    /**
     * 是否删除（1-删除，0-未删除）
     */
    private Integer isDeleted;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建者的编号
     */
    private Long createUser;


}
