package com.scm.contract.tariff.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReqAllTariffInfoDto {
    private String cntrtId;
    private List<AllTariffInfoDto> allTariffInfoList;
}
