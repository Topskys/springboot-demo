package com.example.demo.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CertificateDto {

    @NotBlank(message = "产品批次为必填项")
    private String batch;

    private String name;

    @NotBlank(message = "产品质检单为必填项")
    private String url;
}
