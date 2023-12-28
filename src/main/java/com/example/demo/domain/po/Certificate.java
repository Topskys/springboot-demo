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
 * 质检报告表
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_certificate")
public class Certificate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 证书编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 质检报告
     */
    private String name;

    /**
     * 产品批次
     */
    private String batch;

    /**
     * 证书地址链接
     */
    private String url;

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
