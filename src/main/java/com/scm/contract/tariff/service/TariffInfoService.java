package com.scm.contract.tariff.service;

import com.scm.contract.tariff.dto.*;

import java.util.List;

public interface TariffInfoService {
    ResTariffHeaderDto getTariffHeader(String cntrtId, Integer tariffId);
    ResTariffHeaderDto postTariffHeader(ReqTariffHeaderPostDto reqTariffHeaderPostDto);
    ResTariffHeaderDto putTariffHeader(ReqTariffHeaderPutDto reqTariffHeaderPutDto);
    List<AllTariffInfoDto> getAllTariffInfo(String cntrtId);

    boolean postContractCopy(ReqAllTariffInfoDto reqAllTariffInfoDto);
}
