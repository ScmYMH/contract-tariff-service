package com.scm.contract.tariff.service;

import com.scm.contract.tariff.dto.ReqTariffHeaderPostDto;
import com.scm.contract.tariff.dto.ResTariffHeaderCondGetDto;
import com.scm.contract.tariff.dto.ResTariffHeaderPostDto;
import com.scm.contract.tariff.entity.TariffInfoEntity;

public interface TariffInfoService {
    ResTariffHeaderCondGetDto getTariffHeaderCond();

    ResTariffHeaderPostDto postTariffHeader(ReqTariffHeaderPostDto reqTariffHeaderPostDto);
}
