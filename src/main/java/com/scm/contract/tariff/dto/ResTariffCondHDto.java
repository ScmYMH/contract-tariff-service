package com.scm.contract.tariff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResTariffCondHDto {
    private Integer seqNo; // 일련번호
    private String cntrtId; // 계약 ID
    private Integer trffId; // 타리프 ID
    private String depCd; // 출발지코드
    private String depNm; // 출발지명
    private String arrCd; // 도착지코드
    private String arrNm; // 도착지명
    private String lccCd; // 물류비코드
    private String subLccCd; // 세부물류비코드
    private String lccCdDesc; // 물류비코드설명
    private String trffStatDate; // 타리프시작일자
    private String trffEndDate; // 타리프종료일자
    private String cntrtCurrCd; // 계약통화코드
    private String payCurrCd; // 지불통화코드
    private String prodGcd; // 제품그룹코드(품종명)
    private String incoCd; // 인도조건코드
    private BigDecimal unitPrice; // 계약단가
    private String calUnitCd; // 계산단위
    private String condId; // 조건ID
    private String condNm; // 조건명
}
