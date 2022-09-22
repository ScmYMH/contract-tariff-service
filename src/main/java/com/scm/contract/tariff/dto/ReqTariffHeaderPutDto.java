package com.scm.contract.tariff.dto;

import lombok.Data;

@Data
public class ReqTariffHeaderPostDto {
    private String cntrtId; // 계약 ID
    private String trffNm; // 타리프 Nm
    private String trffDesc; // 타리프 설명
    private String bizTcd; // 사업유형코드
    private String arApCcd; // 매출매입구분코드
    private String svcTcd; // 서비스유형코드
    private String detlSvcTcd; // 상세서비스유형
}
