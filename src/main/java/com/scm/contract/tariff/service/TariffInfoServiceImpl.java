package com.scm.contract.tariff.service;

import com.scm.contract.config.SecurityService;
import com.scm.contract.tariff.dto.*;
import com.scm.contract.tariff.entity.TariffCondHEntity;
import com.scm.contract.tariff.entity.TariffCondValDEntity;
import com.scm.contract.tariff.repository.TariffCondHRepository;
import com.scm.contract.tariff.repository.TariffCondValDRepository;
import com.scm.contract.tcom.repositoy.CodeDefinitionRepository;
import com.scm.contract.tariff.entity.TariffInfoEntity;
import com.scm.contract.tariff.repository.TariffInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TariffInfoServiceImpl implements TariffInfoService{

    @Autowired
    SecurityService securityService;

    @Autowired
    TariffInfoRepository tariffInfoRepository;

    @Autowired
    CodeDefinitionRepository codeDefinitionRepository;

    @Autowired
    TariffCondHRepository tariffCondHRepository;

    @Autowired
    TariffCondValDRepository tariffCondValDRepository;

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

        String userId = securityService.getIdAtToken();
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
                .insPersonId(userId) // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                .updDate(new SimpleDateFormat("yyyyMMdd").format(today))
                .updTime(new SimpleDateFormat("HHmmss").format(today))
                .updPersonId(userId) // 로그인 한 사용자의 id값(token에서 꺼내온 값)
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

    public List<AllTariffInfoDto> getAllTariffInfo(String cntrtId){
        List<TariffInfoEntity> tariffInfoEntityList = tariffInfoRepository.findByCntrtId(cntrtId);

        List<AllTariffInfoDto> allTariffInfoDtoList = new ArrayList<>();

        for(int i = 0; i < tariffInfoEntityList.size(); i++){
            AllTariffInfoDto allTariffInfoDto = new AllTariffInfoDto();

            ResTariffHeaderDto resTariffHeaderDto = ResTariffHeaderDto.builder()
                    .cntrtId(tariffInfoEntityList.get(i).getCntrtId())
                    .trffId(tariffInfoEntityList.get(i).getTrffId())
                    .svcTcd(tariffInfoEntityList.get(i).getSvcTcd())
                    .trffNm(tariffInfoEntityList.get(i).getTrffNm())
                    .trffDesc(tariffInfoEntityList.get(i).getTrffDesc())
                    .bizTcd(tariffInfoEntityList.get(i).getBizTcd())
                    .arApCcd(tariffInfoEntityList.get(i).getArApCcd())
                    .detlSvcTcd(tariffInfoEntityList.get(i).getDetlSvcTcd())
                    .build();

            allTariffInfoDto.setResTariffHeaderDto(resTariffHeaderDto);

            List<ResTariffCondHDto> resTariffCondHDtoList = new ArrayList<>();

            List<TariffCondHEntity> tariffCondHEntityList = tariffCondHRepository
                    .findByCntrtIdAndTrffId(resTariffHeaderDto.getCntrtId(), resTariffHeaderDto.getTrffId());

            for(int j = 0; j < tariffCondHEntityList.size(); j++){
                if(tariffCondHEntityList.get(j).getDelYn().equals("Y")) continue;

                TariffCondHEntity tche = tariffCondHEntityList.get(j);
                Optional<TariffCondValDEntity> tariffCondValDEntity = tariffCondValDRepository.findById(tche.getSeqNo());
                if(tariffCondValDEntity.isPresent()){
                    ResTariffCondHDto tariffCondHGetDto = ResTariffCondHDto.builder()
                            .seqNo(tche.getSeqNo())
                            .cntrtId(tche.getCntrtId())
                            .trffId(tche.getTrffId())
                            .depCd(tche.getDepCd())
                            .depNm(tche.getDepNm())
                            .arrCd(tche.getArrCd())
                            .arrNm(tche.getArrNm())
                            .lccCd(tche.getLccCd())
                            .subLccCd(tche.getSubLccCd())
                            .lccCdDesc(tche.getLccCdDesc())
                            .trffStatDate(tche.getTrffStatDate())
                            .trffEndDate(tche.getTrffEndDate())
                            .cntrtCurrCd(tche.getCntrtCurrCd())
                            .payCurrCd(tche.getPayCurrCd())
                            .prodGcd(tche.getProdGcd())
                            .incoCd(tche.getIncoCd())
                            .unitPrice(tariffCondValDEntity.get().getUnitPrice())
                            .calUnitCd(tariffCondValDEntity.get().getCalUnitCd())
                            .condId(tariffCondValDEntity.get().getCondId())
                            .condNm(tariffCondValDEntity.get().getCondNm())
                            .build();
                    resTariffCondHDtoList.add(tariffCondHGetDto);
                }
            }
            allTariffInfoDto.setTariffCondHDtoList(resTariffCondHDtoList);

            allTariffInfoDtoList.add(allTariffInfoDto);
        }

        return allTariffInfoDtoList;
    }


    public boolean postContractCopy(ReqAllTariffInfoDto reqAllTariffInfoDto){
        String newCntrtId = reqAllTariffInfoDto.getCntrtId();
        for(int i = 0; i < reqAllTariffInfoDto.getAllTariffInfoList().size(); i++){
            ResTariffHeaderDto tariffHeaderDto = reqAllTariffInfoDto.getAllTariffInfoList().get(i).getResTariffHeaderDto();

            today = new Date();

            String userId = securityService.getIdAtToken();

            // bizDivCd, custId => null
            TariffInfoEntity tariffInfoEntity = TariffInfoEntity.builder()
                    .cntrtId(newCntrtId)
                    .svcTcd(tariffHeaderDto.getSvcTcd())
                    .trffNm(tariffHeaderDto.getTrffNm())
                    .trffDesc(tariffHeaderDto.getTrffDesc())
                    .bizTcd(tariffHeaderDto.getBizTcd())
                    .arApCcd(tariffHeaderDto.getArApCcd())
                    .detlSvcTcd(tariffHeaderDto.getDetlSvcTcd())
                    .corpId("PI")
                    .delYn("N")
                    .insDate(new SimpleDateFormat("yyyyMMdd").format(today))
                    .insTime(new SimpleDateFormat("HHmmss").format(today))
                    .insPersonId(userId) // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                    .updDate(new SimpleDateFormat("yyyyMMdd").format(today))
                    .updTime(new SimpleDateFormat("HHmmss").format(today))
                    .updPersonId(userId) // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                    .build();

            log.info(String.valueOf(tariffInfoEntity));
            tariffInfoEntity = tariffInfoRepository.save(tariffInfoEntity);

            Optional<TariffInfoEntity> tariffInfoEntityOpt = tariffInfoRepository.findById(tariffInfoEntity.getTrffId());

            if(tariffInfoEntityOpt.isPresent()){
                List<ResTariffCondHDto> tariffCondHDtoList = reqAllTariffInfoDto.getAllTariffInfoList().get(i).getTariffCondHDtoList();
                Integer newTrffId = tariffInfoEntityOpt.get().getTrffId();
                for(int j = 0; j < tariffCondHDtoList.size(); j++){
                    TariffCondHEntity tariffCondHEntity = TariffCondHEntity.builder()
                            .cntrtId(newCntrtId)
                            .trffId(newTrffId)
                            .depCd(tariffCondHDtoList.get(j).getDepCd())
                            .depNm(tariffCondHDtoList.get(j).getDepNm())
                            .arrCd(tariffCondHDtoList.get(j).getArrCd())
                            .arrNm(tariffCondHDtoList.get(j).getArrNm())
                            .lccCd(tariffCondHDtoList.get(j).getLccCd())
                            .subLccCd(tariffCondHDtoList.get(j).getSubLccCd())
                            .lccCdDesc(tariffCondHDtoList.get(j).getLccCdDesc())
                            .trffStatDate(tariffCondHDtoList.get(j).getTrffStatDate())
                            .trffEndDate(tariffCondHDtoList.get(j).getTrffEndDate())
                            .cntrtCurrCd(tariffCondHDtoList.get(j).getCntrtCurrCd())
                            .payCurrCd(tariffCondHDtoList.get(j).getPayCurrCd())
                            .incoCd(tariffCondHDtoList.get(j).getIncoCd())
                            .prodGcd(tariffCondHDtoList.get(j).getProdGcd())
                            .laneCd("*")
                            .laneId("*")
                            .calMthdCd("*")
                            .corpId("PI")
                            .delYn("N")
                            .insDate(new SimpleDateFormat("yyyyMMdd").format(today))
                            .insTime(new SimpleDateFormat("HHmmss").format(today))
                            .insPersonId(userId) // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                            .updDate(new SimpleDateFormat("yyyyMMdd").format(today))
                            .updTime(new SimpleDateFormat("HHmmss").format(today))
                            .updPersonId(userId) // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                            .build();
                    TariffCondHEntity newTariffCondHEntity = tariffCondHRepository.save(tariffCondHEntity);

                    System.out.println("tariffCondHEntity seqNo : " + tariffCondHEntity.getSeqNo());

                    TariffCondValDEntity tariffCondValDEntity = TariffCondValDEntity.builder()
                            .seqNo(newTariffCondHEntity.getSeqNo())
                            .cntrtId(newCntrtId)
                            .trffId(newTrffId)
                            .valSeqNo(1)
                            .currCnt(1)
                            .condYn("N")
                            .priceTcd("AMT")
                            .calUnitCd(tariffCondHDtoList.get(j).getCalUnitCd())
                            .cntrtCurrCd(tariffCondHDtoList.get(j).getCntrtCurrCd())
                            .payCurrCd(tariffCondHDtoList.get(j).getPayCurrCd())
                            .unitPrice(tariffCondHDtoList.get(j).getUnitPrice())
                            .corpId("PI")
                            .delYn("N")
                            .insDate(new SimpleDateFormat("yyyyMMdd").format(today))
                            .insTime(new SimpleDateFormat("HHmmss").format(today))
                            .insPersonId(userId) // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                            .updDate(new SimpleDateFormat("yyyyMMdd").format(today))
                            .updTime(new SimpleDateFormat("HHmmss").format(today))
                            .updPersonId(userId) // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                            .build();
                    TariffCondValDEntity newTariffCondValDEntity = tariffCondValDRepository.save(tariffCondValDEntity);
                    System.out.println("newTariffCondValDEntity seqNo : " + newTariffCondValDEntity.getSeqNo());
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
