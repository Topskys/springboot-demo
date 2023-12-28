package com.example.demo.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品和（企业）部门映射关系表
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_product_department")
public class ProductDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品部门关系编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品编号
     */
    private Long productId;

    /**
     * 部门编号
     */
    private Long departmentId;


}
