package com.scm.contract.tariff.dto;

import lombok.Data;

@Data
public class ResDestInfoGetDto {
    private String nodeCd; // 목적지 코드
    private String nodeDesc; // 목적지 명
    private String nationNm; // 국가 명
    private String nationCd; // 국가 코드
    private String deliveryAreaCd; // 대권역
    private String boundaryCd; // 소권역
    private String delYn;

    public ResDestInfoGetDto(String nodeCd, String nodeDesc, String nationNm, String nationCd, String deliveryAreaCd, String boundaryCd, String delYn) {
        this.nodeCd = nodeCd;
        this.nodeDesc = nodeDesc;
        this.nationNm = nationNm;
        this.nationCd = nationCd;
        this.deliveryAreaCd = deliveryAreaCd;
        this.boundaryCd = boundaryCd;
        this.delYn = delYn;
    }
}
