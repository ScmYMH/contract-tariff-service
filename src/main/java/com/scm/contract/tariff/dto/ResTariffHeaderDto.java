package com.scm.contract.tariff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResTariffHeaderDto {

    private Integer trffId; // 타리프 ID
    private String cntrtId; // 계약 ID
    private String svcTcd;// 서비스유형코드
    private String trffNm; // 타리프
    private String trffDesc; // 타리프설명
    private String bizTcd; // 사업유형코드
    private String arApCcd; // 매출매입구분코드
    private String detlSvcTcd; // 상세 서비스 유형 코드


}
