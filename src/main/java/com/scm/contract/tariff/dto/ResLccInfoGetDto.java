package com.scm.contract.tariff.dto;

import lombok.Data;

@Data
public class ResLccInfoGetDto {
    private Integer seqNo;
    private String lccCd; // 물류비코드
    private String subLccCd; // 세부물류비코드
    private String lccCdNm; // 물류비코드명
    private String lccCdDesc; // 물류비코드설명
    private String trnsCostTcd; // 운송비유형코드
    private String trnsCostSubTcd; // 세부운송비유형코드
    private String trffUseYn; // 요율사용여부
    private String netAmtYn; // 순액총액여부
    private String delYn; // 삭제여부

    public ResLccInfoGetDto(Integer seqNo, String lccCd, String subLccCd, String lccCdNm,
                            String lccCdDesc, String trnsCostTcd, String trnsCostSubTcd,
                            String trffUseYn, String netAmtYn, String delYn) {
        this.seqNo = seqNo;
        this.lccCd = lccCd;
        this.subLccCd = subLccCd;
        this.lccCdNm = lccCdNm;
        this.lccCdDesc = lccCdDesc;
        this.trnsCostTcd = trnsCostTcd;
        this.trnsCostSubTcd = trnsCostSubTcd;
        this.trffUseYn = trffUseYn;
        this.netAmtYn = netAmtYn;
        this.delYn = delYn;
    }
}
