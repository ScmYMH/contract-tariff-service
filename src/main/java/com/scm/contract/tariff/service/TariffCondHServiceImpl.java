package com.scm.contract.tariff.service;

import com.scm.contract.tariff.dto.ResDestInfoGetDto;
import com.scm.contract.tariff.dto.ResLccInfoGetDto;
import com.scm.contract.tariff.entity.CntrtInfoEntity;
import com.scm.contract.tariff.repository.CntrtInfoRepository;
import com.scm.contract.tariff.repository.TariffCondHRepository;
import com.scm.contract.tcom.entity.DestInfoEntity;
import com.scm.contract.tcom.entity.LccInfoEntity;
import com.scm.contract.tcom.repositoy.CodeDefinitionRepository;
import com.scm.contract.tcom.repositoy.DestInfoRepository;
import com.scm.contract.tcom.repositoy.LccInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TariffCondHServiceImpl implements TariffCondHService{

    @Autowired
    TariffCondHRepository tariffCondHRepository;

    @Autowired
    DestInfoRepository destInfoRepository;

    @Autowired
    CodeDefinitionRepository codeDefinitionRepository;

    @Autowired
    LccInfoRepository lccInfoRepository;

    @Autowired
    CntrtInfoRepository cntrtInfoRepository;

    public List<ResDestInfoGetDto> getAllDestInfo(){

        List<ResDestInfoGetDto> resDestInfoGetDtoList = new ArrayList<>();

        List<DestInfoEntity> destInfoEntityList = destInfoRepository.findAll();

        for(int i = 0; i < destInfoEntityList.size(); i++){
            String nationNm = codeDefinitionRepository.findCdVMeaningByCdV(destInfoEntityList.get(i).getNationCd()).get(); // 코드값 -> 코드 의미 가져오기

            ResDestInfoGetDto rdigd = new ResDestInfoGetDto(
                    destInfoEntityList.get(i).getNodeCd(),
                    destInfoEntityList.get(i).getNodeDesc(),
                    nationNm,
                    destInfoEntityList.get(i).getNationCd(),
                    destInfoEntityList.get(i).getDeliveryAreaCd(),
                    destInfoEntityList.get(i).getBoundaryCd(),
                    destInfoEntityList.get(i).getDelYn()
            );
            resDestInfoGetDtoList.add(rdigd);
        }

        return resDestInfoGetDtoList;

    }

    public List<CntrtInfoEntity> getAllCntrtInfo(String cntrtId){
        return cntrtInfoRepository.findAll();
    }


    public List<ResLccInfoGetDto> getLccInfo(String lccCd, String subLccCd, String lccCdNm){

        List<ResLccInfoGetDto> resLccInfoGetDtoList = new ArrayList<>();

        List<LccInfoEntity> lccInfoEntityList = lccInfoRepository.findByLccCdContainingAndSubLccCdContainingAndLccCdNmContaining(lccCd, subLccCd, lccCdNm);

        for(int i = 0; i < lccInfoEntityList.size(); i++){
            ResLccInfoGetDto rligd = new ResLccInfoGetDto(
                    lccInfoEntityList.get(i).getSeqNo(),
                    lccInfoEntityList.get(i).getLccCd(),
                    lccInfoEntityList.get(i).getSubLccCd(),
                    lccInfoEntityList.get(i).getLccCdNm(),
                    lccInfoEntityList.get(i).getLccCdDesc(),
                    lccInfoEntityList.get(i).getTrnsCostTcd(),
                    lccInfoEntityList.get(i).getTrnsCostSubTcd(),
                    lccInfoEntityList.get(i).getTrffUseYn(),
                    lccInfoEntityList.get(i).getNetAmtYn(),
                    lccInfoEntityList.get(i).getDelYn()
            );
            resLccInfoGetDtoList.add(rligd);
        }

        return resLccInfoGetDtoList;

    }
}
