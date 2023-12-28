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
 * 产品评价表
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 客户姓名
     */
    private String employerName;

    /**
     * 客户联系方式
     */
    private String employerContact;

    /**
     * 评价星级
     */
    private Integer star;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 上传图片字符串数组
     */
    private String pictures;

    /**
     * 地理位置
     */
    private String address;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


}
