package com.example.demo.service.impl;

import com.example.demo.domain.dto.CertificateDto;
import com.example.demo.domain.po.Certificate;
import com.example.demo.mapper.CertificateMapper;
import com.example.demo.service.ICertificateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 质检报告表 服务实现类
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Service
public class CertificateServiceImpl extends ServiceImpl<CertificateMapper, Certificate> implements ICertificateService {


    @Autowired
    private CertificateMapper certificateMapper;

    /**
     * 通过产品批次查询质检报告
     */
    @Override
    public Certificate findByBatch(String batch) {
        return certificateMapper.selectById(batch);
    }

    /**
     *  信息关联，创建质检报告与产品批次关联
     */
    @Override
    public Certificate createUnion(CertificateDto certificateDto) {
        return certificateMapper.insert(certificateDto);
    }

    @Override
    public Boolean removeById(Long id) {
        return null;
    }

    @Override
    public void removeUnion(Long id) {

    }



}
