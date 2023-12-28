package com.example.demo.service;

import com.example.demo.domain.dto.CertificateDto;
import com.example.demo.domain.po.Certificate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 质检报告表 服务类
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
public interface ICertificateService extends IService<Certificate> {

    /**
     * 通过产品批次查询质检报告
     */
    Certificate findByBatch(String batch);


    /**
     *  信息关联，创建质检报告与产品批次关联
     */
    Certificate createUnion(CertificateDto certificateDto);

    /**
     * 根据质检报告编号删除信息关联
     */
    Boolean removeById(Long id);
}
