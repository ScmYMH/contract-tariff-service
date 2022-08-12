package com.scm.contract.tariff.service;

import com.scm.contract.tcom.repositoy.CodeDefinitionRepository;
import com.scm.contract.tariff.dto.ReqTariffHeaderPostDto;
import com.scm.contract.tariff.dto.ResTariffHeaderCondGetDto;
import com.scm.contract.tariff.dto.ResTariffHeaderPostDto;
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

    public ResTariffHeaderCondGetDto getTariffHeaderCond(){
        ResTariffHeaderCondGetDto resTariffHeaderCondGetDto = new ResTariffHeaderCondGetDto();
//        resTariffHeaderCondGetDto.setBizTcdArr(codeDefinitionRepository.findAllCdVByCdTpMeaning("사업지역"));
//        resTariffHeaderCondGetDto.setSvcTcdArr(codeDefinitionRepository.findAllCdVByCdTpMeaning("서비스유형"));
//        resTariffHeaderCondGetDto.setArApCcdArr(codeDefinitionRepository.findAllCdVByCdTpMeaning("매출매입구분"));
//        resTariffHeaderCondGetDto.setDetlSvcTcdArr(codeDefinitionRepository.findAllCdVByCdTpMeaning("상세서비스유형"));
//        System.out.println(resTariffHeaderCondGetDto.toString());
        return resTariffHeaderCondGetDto;
    }

    public ResTariffHeaderPostDto postTariffHeader(ReqTariffHeaderPostDto reqTariffHeaderPostDto){

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

        return new ResTariffHeaderPostDto(
                tariffInfoEntity.getTrffId(),
                tariffInfoEntity.getCntrtId(),
                tariffInfoEntity.getSvcTcd(),
                tariffInfoEntity.getTrffNm(),
                tariffInfoEntity.getTrffDesc(),
                tariffInfoEntity.getBizTcd(),
                tariffInfoEntity.getArApCcd(),
                tariffInfoEntity.getDetlSvcTcd(),
                tariffInfoEntity.getBizDivCd(),
                tariffInfoEntity.getCustId(),
                tariffInfoEntity.getCorpId(),
                tariffInfoEntity.getDelYn()
        );
    }
}
