package com.scm.contract.tariff.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReqAllTariffInfoDto {
    private String cntrtId;
    private String cntrtStatDate;
    private String cntrtEndDate;
    private List<AllTariffInfoDto> allTariffInfoList;
}
