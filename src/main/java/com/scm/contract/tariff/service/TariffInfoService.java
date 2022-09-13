package com.scm.contract.tariff.service;

import com.scm.contract.tariff.dto.ReqAllTariffInfoDto;
import com.scm.contract.tariff.dto.ReqTariffHeaderPostDto;
import com.scm.contract.tariff.dto.AllTariffInfoDto;
import com.scm.contract.tariff.dto.ResTariffHeaderDto;

import java.util.List;

public interface TariffInfoService {
    ResTariffHeaderDto getTariffHeader(String cntrtId, Integer tariffId);
    ResTariffHeaderDto postTariffHeader(ReqTariffHeaderPostDto reqTariffHeaderPostDto);

    List<AllTariffInfoDto> getAllTariffInfo(String cntrtId);

    boolean postContractCopy(ReqAllTariffInfoDto reqAllTariffInfoDto);
}
