package com.scm.contract.tariff.service;

import com.scm.contract.tariff.dto.ReqTariffHeaderPostDto;
import com.scm.contract.tariff.dto.ResTariffHeaderDto;

public interface TariffInfoService {
    ResTariffHeaderDto getTariffHeader(String cntrtId, Integer tariffId);
    ResTariffHeaderDto postTariffHeader(ReqTariffHeaderPostDto reqTariffHeaderPostDto);
}
