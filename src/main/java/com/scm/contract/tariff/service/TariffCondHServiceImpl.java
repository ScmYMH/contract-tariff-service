package com.scm.contract.tariff.service;

import com.scm.contract.config.SecurityService;
import com.scm.contract.tariff.dto.*;
import com.scm.contract.tariff.entity.TariffCondHEntity;
import com.scm.contract.tariff.entity.TariffCondValDEntity;
import com.scm.contract.tariff.repository.CntrtInfoRepository;
import com.scm.contract.tariff.repository.TariffCondHRepository;
import com.scm.contract.tariff.repository.TariffCondValDRepository;
import com.scm.contract.tcom.entity.DestInfoEntity;
import com.scm.contract.tcom.entity.LccInfoEntity;
import com.scm.contract.tcom.repositoy.CodeDefinitionRepository;
import com.scm.contract.tcom.repositoy.DestInfoRepository;
import com.scm.contract.tcom.repositoy.LccInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class TariffCondHServiceImpl implements TariffCondHService{
    @Autowired
    SecurityService securityService;
    @Autowired
    TariffCondHRepository tariffCondHRepository;
    @Autowired
    TariffCondValDRepository tariffCondValDRepository;
    @Autowired
    DestInfoRepository destInfoRepository;
    @Autowired
    CodeDefinitionRepository codeDefinitionRepository;
    @Autowired
    LccInfoRepository lccInfoRepository;
    @Autowired
    CntrtInfoRepository cntrtInfoRepository;

    public List<ResTariffCondHDto> getTariffCondH(String cntrtId, Integer tariffId){
        List<TariffCondHEntity> tariffCondHEntityList = tariffCondHRepository.findByCntrtIdAndTrffId(cntrtId, tariffId);

        List<ResTariffCondHDto> resTariffCondHDtoList = new ArrayList<>();

        for(int i = 0; i < tariffCondHEntityList.size(); i++){
            if(tariffCondHEntityList.get(i).getDelYn().equals("Y")) continue;

            TariffCondHEntity tche = tariffCondHEntityList.get(i);
            int seqNo = tche.getSeqNo();
            System.out.println("seqNo : "+ seqNo);
            Optional<TariffCondValDEntity> tariffCondValDEntity = tariffCondValDRepository.findById(seqNo);

            if(tariffCondValDEntity.isPresent()){
                ResTariffCondHDto tariffCondHGetDto = ResTariffCondHDto.builder()
                        .seqNo(seqNo)
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

        resTariffCondHDtoList.sort(new Comparator<ResTariffCondHDto>() {
            @Override
            public int compare(ResTariffCondHDto o1, ResTariffCondHDto o2) {
                if(o1.getArrCd().compareTo(o1.getArrCd()) == 0)
                    return Integer.parseInt(o2.getTrffEndDate()) - Integer.parseInt(o1.getTrffEndDate());
                else
                    return o2.getArrCd().compareTo(o1.getArrCd());
            }
        });
        return resTariffCondHDtoList;
    }

    public List<ResTariffCondHDto> postTariffCondH(ReqTariffCondHPostDto reqTariffCondHPostDto){
        ResTariffCondHDto[] trffCondHDtoList = reqTariffCondHPostDto.getTrffCondHDtoList();
        AddRowTariffCondHDto[] addRowTrffCondHDtoList = reqTariffCondHPostDto.getAddRowTrffCondHDtoList();

        Date today = new Date();

        String userId = securityService.getIdAtToken();

        for(int i = 0; i < trffCondHDtoList.length; i++){
            Optional<TariffCondHEntity> optTariffCondHEntity =  tariffCondHRepository.findById(trffCondHDtoList[i].getSeqNo());
            if(optTariffCondHEntity.isPresent()){
                TariffCondHEntity tariffCondHEntity = optTariffCondHEntity.get();
                tariffCondHEntity.setSeqNo(trffCondHDtoList[i].getSeqNo());
                tariffCondHEntity.setCntrtId(trffCondHDtoList[i].getCntrtId());
                tariffCondHEntity.setTrffId(trffCondHDtoList[i].getTrffId());
                tariffCondHEntity.setDepCd(trffCondHDtoList[i].getDepCd());
                tariffCondHEntity.setDepNm(trffCondHDtoList[i].getDepNm());
                tariffCondHEntity.setArrCd(trffCondHDtoList[i].getArrCd());
                tariffCondHEntity.setArrNm(trffCondHDtoList[i].getArrNm());
                tariffCondHEntity.setLccCd(trffCondHDtoList[i].getLccCd());
                tariffCondHEntity.setSubLccCd(trffCondHDtoList[i].getSubLccCd());
                tariffCondHEntity.setLccCdDesc(trffCondHDtoList[i].getLccCdDesc());
                tariffCondHEntity.setTrffStatDate(trffCondHDtoList[i].getTrffStatDate());
                tariffCondHEntity.setTrffEndDate(trffCondHDtoList[i].getTrffEndDate());
                tariffCondHEntity.setCntrtCurrCd(trffCondHDtoList[i].getCntrtCurrCd());
                tariffCondHEntity.setPayCurrCd(trffCondHDtoList[i].getPayCurrCd());
                tariffCondHEntity.setIncoCd(trffCondHDtoList[i].getIncoCd());
                tariffCondHEntity.setProdGcd(trffCondHDtoList[i].getProdGcd());
                tariffCondHEntity.setDelYn("N");
                tariffCondHEntity.setUpdDate(new SimpleDateFormat("yyyyMMdd").format(today));
                tariffCondHEntity.setUpdTime(new SimpleDateFormat("HHmmss").format(today));
                tariffCondHEntity.setUpdPersonId(userId); // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                tariffCondHRepository.save(tariffCondHEntity);

                Optional<TariffCondValDEntity> optTariffCondValDEntity = tariffCondValDRepository.findById(trffCondHDtoList[i].getSeqNo());
                if(optTariffCondValDEntity.isPresent()){
                    TariffCondValDEntity tariffCondValDEntity = optTariffCondValDEntity.get();
                    tariffCondValDEntity.setCalUnitCd(trffCondHDtoList[i].getCalUnitCd());
                    tariffCondValDEntity.setCntrtCurrCd(trffCondHDtoList[i].getCntrtCurrCd());
                    tariffCondValDEntity.setPayCurrCd(trffCondHDtoList[i].getPayCurrCd());
                    tariffCondValDEntity.setUnitPrice(trffCondHDtoList[i].getUnitPrice());
                    tariffCondValDEntity.setDelYn("N");
                    tariffCondValDEntity.setUpdDate(new SimpleDateFormat("yyyyMMdd").format(today));
                    tariffCondValDEntity.setUpdTime(new SimpleDateFormat("HHmmss").format(today));
                    tariffCondValDEntity.setUpdPersonId(userId); // 로그인 한 사용자의 id값(token에서 꺼내온 값)
                    tariffCondValDRepository.save(tariffCondValDEntity);
                }
            }
        }

        for(int i = 0; i < addRowTrffCondHDtoList.length; i++){
            TariffCondHEntity tariffCondHEntity = TariffCondHEntity.builder()
                    .cntrtId(addRowTrffCondHDtoList[i].getCntrtId())
                    .trffId(addRowTrffCondHDtoList[i].getTrffId())
                    .depCd(addRowTrffCondHDtoList[i].getDepCd())
                    .depNm(addRowTrffCondHDtoList[i].getDepNm())
                    .arrCd(addRowTrffCondHDtoList[i].getArrCd())
                    .arrNm(addRowTrffCondHDtoList[i].getArrNm())
                    .lccCd(addRowTrffCondHDtoList[i].getLccCd())
                    .subLccCd(addRowTrffCondHDtoList[i].getSubLccCd())
                    .lccCdDesc(addRowTrffCondHDtoList[i].getLccCdDesc())
                    .trffStatDate(addRowTrffCondHDtoList[i].getTrffStatDate())
                    .trffEndDate(addRowTrffCondHDtoList[i].getTrffEndDate())
                    .cntrtCurrCd(addRowTrffCondHDtoList[i].getCntrtCurrCd())
                    .payCurrCd(addRowTrffCondHDtoList[i].getPayCurrCd())
                    .incoCd(addRowTrffCondHDtoList[i].getIncoCd())
                    .prodGcd(addRowTrffCondHDtoList[i].getProdGcd())
                    .laneCd("*")
                    .laneId("*")
                    .calMthdCd("*")
                    .corpId("PI")
                    .delYn("N")
                    .insDate(new SimpleDateFormat("yyyyMMdd").format(today))
                    .insTime(new SimpleDateFormat("HHmmss").format(today))
                    .insPersonId(userId) // 원래는 로그인 한 사용자의 id값(token에서 꺼내오면 될듯)
                    .updDate(new SimpleDateFormat("yyyyMMdd").format(today))
                    .updTime(new SimpleDateFormat("HHmmss").format(today))
                    .updPersonId(userId) // 원래는 로그인 한 사용자의 id값(token에서 꺼내오면 될듯)
                    .build();
            TariffCondHEntity newTariffCondHEntity = tariffCondHRepository.save(tariffCondHEntity);

            System.out.println("tariffCondHEntity seqNo : " + tariffCondHEntity.getSeqNo());

            TariffCondValDEntity tariffCondValDEntity = TariffCondValDEntity.builder()
                    .seqNo(newTariffCondHEntity.getSeqNo())
                    .cntrtId(addRowTrffCondHDtoList[i].getCntrtId())
                    .trffId(addRowTrffCondHDtoList[i].getTrffId())
                    .valSeqNo(1)
                    .currCnt(1)
                    .condYn("N")
                    .priceTcd("AMT")
                    .calUnitCd(addRowTrffCondHDtoList[i].getCalUnitCd())
                    .cntrtCurrCd(addRowTrffCondHDtoList[i].getCntrtCurrCd())
                    .payCurrCd(addRowTrffCondHDtoList[i].getPayCurrCd())
                    .unitPrice(addRowTrffCondHDtoList[i].getUnitPrice())
                    .corpId("PI")
                    .delYn("N")
                    .insDate(new SimpleDateFormat("yyyyMMdd").format(today))
                    .insTime(new SimpleDateFormat("HHmmss").format(today))
                    .insPersonId(userId) // 원래는 로그인 한 사용자의 id값(token에서 꺼내오면 될듯)
                    .updDate(new SimpleDateFormat("yyyyMMdd").format(today))
                    .updTime(new SimpleDateFormat("HHmmss").format(today))
                    .updPersonId(userId) // 원래는 로그인 한 사용자의 id값(token에서 꺼내오면 될듯)
                    .build();
            TariffCondValDEntity newTariffCondValDEntity = tariffCondValDRepository.save(tariffCondValDEntity);
            System.out.println("newTariffCondValDEntity seqNo : " + newTariffCondValDEntity.getSeqNo());
        }

        List<TariffCondHEntity> tariffCondHEntityList;
        if(trffCondHDtoList.length != 0) {
            tariffCondHEntityList = tariffCondHRepository.findByCntrtIdAndTrffId(trffCondHDtoList[0].getCntrtId(), trffCondHDtoList[0].getTrffId());
        }else{
            tariffCondHEntityList = tariffCondHRepository.findByCntrtIdAndTrffId(addRowTrffCondHDtoList[0].getCntrtId(), addRowTrffCondHDtoList[0].getTrffId());
        }

        List<ResTariffCondHDto> resTariffCondHDtoList = new ArrayList<>();

        for(int i = 0; i < tariffCondHEntityList.size(); i++){
            if(tariffCondHEntityList.get(i).getDelYn().equals("Y")) continue;

            TariffCondHEntity tche = tariffCondHEntityList.get(i);
            int seqNo = tche.getSeqNo();
            System.out.println("seqNo : "+ seqNo);
            Optional<TariffCondValDEntity> tariffCondValDEntity = tariffCondValDRepository.findById(seqNo);

            if(tariffCondValDEntity.isPresent()){
                ResTariffCondHDto tariffCondHGetDto = ResTariffCondHDto.builder()
                        .seqNo(seqNo)
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

        resTariffCondHDtoList.sort(new Comparator<ResTariffCondHDto>() {
            @Override
            public int compare(ResTariffCondHDto o1, ResTariffCondHDto o2) {
                if(o1.getArrCd().compareTo(o1.getArrCd()) == 0)
                    return Integer.parseInt(o2.getTrffEndDate()) - Integer.parseInt(o1.getTrffEndDate());
                else
                    return o2.getArrCd().compareTo(o1.getArrCd());
            }
        });
        return resTariffCondHDtoList;


    }

    public List<ResTariffCondHDto> deleteTariffCondH(String seqNoParam){
        String[] seqNoArray = seqNoParam.split(",");

        for(int i = 0; i < seqNoArray.length; i++){
            Optional<TariffCondHEntity> optTariffCondHEntity = tariffCondHRepository.findById(Integer.parseInt(seqNoArray[i]));
            if(optTariffCondHEntity.isPresent()){
                optTariffCondHEntity.get().setDelYn("Y");
                tariffCondHRepository.save(optTariffCondHEntity.get());

                Optional<TariffCondValDEntity> optTariffCondValDEntity = tariffCondValDRepository.findById(Integer.parseInt(seqNoArray[i]));
                if(optTariffCondValDEntity.isPresent()){
                    optTariffCondValDEntity.get().setDelYn("Y");
                    tariffCondValDRepository.save(optTariffCondValDEntity.get());
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }

        TariffCondHEntity tce = tariffCondHRepository.findById(Integer.parseInt(seqNoArray[0])).get();
        List<TariffCondHEntity> tariffCondHEntityList = tariffCondHRepository.findByCntrtIdAndTrffId(tce.getCntrtId(), tce.getTrffId());

        List<ResTariffCondHDto> resTariffCondHDtoList = new ArrayList<>();

        for(int i = 0; i < tariffCondHEntityList.size(); i++){
            if(tariffCondHEntityList.get(i).getDelYn().equals("Y")) continue;

            TariffCondHEntity tche = tariffCondHEntityList.get(i);
            int seqNo = tche.getSeqNo();
            System.out.println("seqNo : "+ seqNo);
            Optional<TariffCondValDEntity> tariffCondValDEntity = tariffCondValDRepository.findById(seqNo);

            if(tariffCondValDEntity.isPresent()){
                ResTariffCondHDto tariffCondHGetDto = ResTariffCondHDto.builder()
                        .seqNo(seqNo)
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

        resTariffCondHDtoList.sort(new Comparator<ResTariffCondHDto>() {
            @Override
            public int compare(ResTariffCondHDto o1, ResTariffCondHDto o2) {
                if(o1.getArrCd().compareTo(o1.getArrCd()) == 0)
                    return Integer.parseInt(o2.getTrffEndDate()) - Integer.parseInt(o1.getTrffEndDate());
                else
                    return o2.getArrCd().compareTo(o1.getArrCd());
            }
        });
        return resTariffCondHDtoList;
    }


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
