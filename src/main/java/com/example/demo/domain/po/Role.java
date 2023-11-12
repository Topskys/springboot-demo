package com.example.demo.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Topskys
 * @since 2023-11-12
 */
@Data
@TableName("tb_role")
public class Role extends Base {



    /**
     * 名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String code;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 是否是系统超级角色,1-是,0-否
     */
    private Integer isAdmin;

}
