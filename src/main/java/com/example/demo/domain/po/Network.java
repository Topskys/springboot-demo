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
 * 销售网站表
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_network")
public class Network implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * （销售）网点编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String name;

    /**
     * 联系人
     */
    private String manager;

    /**
     * 联系电话
     */
    private String contact;

    /**
     * 地理位置
     */
    private String address;

    /**
     * 所属区域
     */
    private String area;

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
     * 修改者的编号
     */
    private Long updateUser;


}
