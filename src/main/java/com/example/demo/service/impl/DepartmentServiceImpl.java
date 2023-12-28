package com.example.demo.service.impl;

import com.example.demo.domain.po.Department;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * （企业）部门表 服务实现类
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
