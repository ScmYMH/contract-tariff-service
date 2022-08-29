package com.scm.contract.tariff.dto;

import lombok.Data;

@Data
public class ReqTariffCondHPostDto {
    ResTariffCondHDto[] trffCondHDtoList;
    AddRowTariffCondHDto[] addRowTrffCondHDtoList;
}
