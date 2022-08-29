package com.scm.contract.tariff.service;

import com.scm.contract.tariff.dto.ReqTariffCondHPostDto;
import com.scm.contract.tariff.dto.ResDestInfoGetDto;
import com.scm.contract.tariff.dto.ResLccInfoGetDto;
import com.scm.contract.tariff.dto.ResTariffCondHDto;

import java.util.List;

public interface TariffCondHService {

    public List<ResTariffCondHDto> getTariffCondH(String cntrtId, Integer tariffId);

    public List<ResTariffCondHDto> postTariffCondH(ReqTariffCondHPostDto reqTariffCondHPostDto);

    public List<ResTariffCondHDto> deleteTariffCondH(String seqNoParam);

    public List<ResDestInfoGetDto> getAllDestInfo();

    public List<ResLccInfoGetDto> getLccInfo(String lccCd, String subLccCd, String lccCdNm);

}
