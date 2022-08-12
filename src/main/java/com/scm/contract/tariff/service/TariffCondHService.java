package com.scm.contract.tariff.service;

import com.scm.contract.tariff.dto.ResDestInfoGetDto;
import com.scm.contract.tariff.dto.ResLccInfoGetDto;
import com.scm.contract.tariff.entity.CntrtInfoEntity;

import java.util.List;

public interface TariffCondHService {

    public List<ResDestInfoGetDto> getAllDestInfo();

    public List<ResLccInfoGetDto> getLccInfo(String lccCd, String subLccCd, String lccCdNm);

    public List<CntrtInfoEntity> getAllCntrtInfo(String cntrtId);
}
