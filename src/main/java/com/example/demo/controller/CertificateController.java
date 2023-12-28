package com.example.demo.controller;


import com.example.demo.domain.dto.CertificateDto;
import com.example.demo.domain.po.Certificate;
import com.example.demo.service.impl.CertificateServiceImpl;
import com.example.demo.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 质检报告表 前端控制器
 * </p>
 *
 * @author Topskys
 * @since 2023-12-28
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/certificate")
public class CertificateController {


    @Autowired
    private CertificateServiceImpl certificateService;


    /**
     * 根据产品批次获取质检报告
     * @param batch 产品批次
     * @return certificate 质检单证书
     */
    @GetMapping("/report")
    public Result<Certificate> getCertificate(@NotBlank(message = "产品批次为必填项") String batch){
        Certificate certificate = certificateService.findByBatch(batch);
        return Result.success(certificate);
    }


    /**
     * 创建（产品批次和质检单）信息关联
     * @param certificateDto {batch,name,url}
     * @return certificate 质检单证书
     */
    @PostMapping()
    public Result createCertificate(@RequestBody @Validated CertificateDto certificateDto){
        Certificate temp=certificateService.findByBatch(certificateDto.getBatch());
        if (temp.getId()>0) return Result.fail("该批次已存在质检报告");
        Certificate certificate=certificateService.createUnion(certificateDto);
        return Result.success(certificate);
    }


    /**
     * 根据质检报告编号删除质检报告
     * @param id 产品批次
     */
    @GetMapping("{id}")
    public Result removeCertificate(Long id){
        Certificate certificate = certificateService.removeById(id);
        return Result.success(certificate);
    }


    /**
     * 创建（产品批次和质检单）信息关联
     * @param certificateDto {batch,name,url}
     * @return certificate 质检单证书
     */
    @PutMapping("{id}")
    public Result createCertificate(@RequestBody @Validated CertificateDto certificateDto,@PathVariable Long id){
        try{
            Certificate certificate=certificateService.createUnion(certificateDto);
            return Result.success(certificate);
        }catch (Exception e){
            log.error("修改失败！");
            return Result.fail("修改失败！");
        }
    }




}
