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
 * （企业）部门表
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 父级部门编号（所属部门编号）
     */
    private Long pid;

    /**
     * 父级部门名称（所属部门名称）
     */
    private String parentName;

    /**
     * 部门负责人
     */
    private String manager;

    /**
     * 部门电话（手机号）
     */
    private String phone;

    /**
     * 部门邮箱
     */
    private String email;

    /**
     * 部门地址
     */
    private String address;

    /**
     * 部门描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 部门状态
     */
    private Integer enabled;

    /**
     * 是否删除,1-删除,0-正常
     */
    private Integer isDelete;

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

    /**
     * 创建者的编号
     */
    private Long updateUser;


}
