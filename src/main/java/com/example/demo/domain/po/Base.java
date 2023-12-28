package com.example.demo.domain.po;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础持久实体
 */
@Data
public class Base implements Serializable {

    /**
     * 创建者编号
     */
    private Long createUser;

    /**
     * 更新者编号
     */
    private Long updateUser;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
