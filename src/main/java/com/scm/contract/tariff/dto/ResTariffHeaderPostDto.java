package com.scm.contract.tariff.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ResTariffHeaderPostDto {

    private Integer trffId; // 타리프 ID
    private String cntrtId; // 계약 ID
    private String svcTcd;// 서비스유형코드
    private String trffNm; // 타리프
    private String trffDesc; // 타리프설명
    private String bizTcd; // 사업유형코드
    private String arApCcd; // 매출매입구분코드
    private String detlSvcTcd; // 상세 서비스 유형 코드
    private String bizDivCd; // 사업영역코드 (null)
    private String custId; // 거래처 ID (null)
    private String corpId; // 법인 ID
    private String delYn; // 삭제여부

    public ResTariffHeaderPostDto(Integer trffId, String cntrtId, String svcTcd, String trffNm, String trffDesc, String bizTcd, String arApCcd, String detlSvcTcd, String bizDivCd, String custId, String corpId, String delYn) {
        this.trffId = trffId;
        this.cntrtId = cntrtId;
        this.svcTcd = svcTcd;
        this.trffNm = trffNm;
        this.trffDesc = trffDesc;
        this.bizTcd = bizTcd;
        this.arApCcd = arApCcd;
        this.detlSvcTcd = detlSvcTcd;
        this.bizDivCd = bizDivCd;
        this.custId = custId;
        this.corpId = corpId;
        this.delYn = delYn;
    }

}
