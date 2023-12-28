package com.example.demo.service.impl;

import com.example.demo.domain.po.ProductDepartment;
import com.example.demo.mapper.ProductDepartmentMapper;
import com.example.demo.service.IProductDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品和（企业）部门映射关系表 服务实现类
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Service
public class ProductDepartmentServiceImpl extends ServiceImpl<ProductDepartmentMapper, ProductDepartment> implements IProductDepartmentService {

}
