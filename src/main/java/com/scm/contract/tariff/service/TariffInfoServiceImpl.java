package com.scm.contract.tariff.service;

import com.scm.contract.tcom.repositoy.CodeDefinitionRepository;
import com.scm.contract.tariff.dto.ReqTariffHeaderPostDto;
import com.scm.contract.tariff.dto.ResTariffHeaderDto;
import com.scm.contract.tariff.entity.TariffInfoEntity;
import com.scm.contract.tariff.repository.TariffInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class TariffInfoServiceImpl implements TariffInfoService{

    @Autowired
    TariffInfoRepository tariffInfoRepository;

    @Autowired
    CodeDefinitionRepository codeDefinitionRepository;

    Date today;

    public ResTariffHeaderDto getTariffHeader(String cntrtId, Integer tariffId){
        TariffInfoEntity tariffInfoEntity = tariffInfoRepository.findByCntrtIdAndTrffId(cntrtId, tariffId);

        return new ResTariffHeaderDto(
                tariffInfoEntity.getTrffId(),
                tariffInfoEntity.getCntrtId(),
                tariffInfoEntity.getSvcTcd(),
                tariffInfoEntity.getTrffNm(),
                tariffInfoEntity.getTrffDesc(),
                tariffInfoEntity.getBizTcd(),
                tariffInfoEntity.getArApCcd(),
                tariffInfoEntity.getDetlSvcTcd()
        );

    }
    public ResTariffHeaderDto postTariffHeader(ReqTariffHeaderPostDto reqTariffHeaderPostDto){

        today = new Date();

        // bizDivCd, custId => null
        TariffInfoEntity tariffInfoEntity = TariffInfoEntity.builder()
                .cntrtId(reqTariffHeaderPostDto.getCntrtId())
                .svcTcd(reqTariffHeaderPostDto.getSvcTcd())
                .trffNm(reqTariffHeaderPostDto.getTrffNm())
                .trffDesc(reqTariffHeaderPostDto.getTrffDesc())
                .bizTcd(reqTariffHeaderPostDto.getBizTcd())
                .arApCcd(reqTariffHeaderPostDto.getArApCcd())
                .detlSvcTcd(reqTariffHeaderPostDto.getDetlSvcTcd())
                .corpId("PI")
                .delYn("N")
                .insDate(new SimpleDateFormat("yyyyMMdd").format(today))
                .insTime(new SimpleDateFormat("HHmmss").format(today))
                .insPersonId("202207130002") // 원래는 로그인 한 사용자의 id값(token에서 꺼내오면 될듯)
                .updDate(new SimpleDateFormat("yyyyMMdd").format(today))
                .updTime(new SimpleDateFormat("HHmmss").format(today))
                .updPersonId("202207130002") // 원래는 로그인 한 사용자의 id값(token에서 꺼내오면 될듯)
                .build();

        log.info(String.valueOf(tariffInfoEntity));
        tariffInfoEntity = tariffInfoRepository.save(tariffInfoEntity);

        return new ResTariffHeaderDto(
                tariffInfoEntity.getTrffId(),
                tariffInfoEntity.getCntrtId(),
                tariffInfoEntity.getSvcTcd(),
                tariffInfoEntity.getTrffNm(),
                tariffInfoEntity.getTrffDesc(),
                tariffInfoEntity.getBizTcd(),
                tariffInfoEntity.getArApCcd(),
                tariffInfoEntity.getDetlSvcTcd()
        );
    }
}
