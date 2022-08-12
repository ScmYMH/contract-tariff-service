package com.scm.contract.tariff.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResTariffHeaderCondGetDto {
    private List<Map<String, String>> bizTcdArr; // 사업지역코드 (수출-EX, 역내판매운송-LD)
    private List<Map<String, String>> svcTcdArr; // 서비스유형
    private List<Map<String, String>> arApCcdArr; // 매출매입구분
    private List<Map<String, String>> detlSvcTcdArr; // 상세서비스유형
}
