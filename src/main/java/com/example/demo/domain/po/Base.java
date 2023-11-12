package com.example.demo.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础持久实体
 */
@Data
public class Base implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建者编号
     */
    private Long createUser;

    /**
     * 更新者编号
     */
    private Long updateUser;

    /**
     * 是否启用（1-是，0-否）
     */
    private Integer enabled;

    /**
     * 删除（1-是，0-否）
     */
    private Integer isDelete;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
