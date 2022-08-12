package com.scm.contract.tariff.controller;

import com.scm.contract.tariff.dto.*;
import com.scm.contract.tariff.entity.CntrtInfoEntity;
import com.scm.contract.tariff.entity.TariffInfoEntity;
import com.scm.contract.tariff.service.TariffCondHService;
import com.scm.contract.tariff.service.TariffCondValDService;
import com.scm.contract.tariff.service.TariffInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("contract/tariff")
@Slf4j
public class TariffController {

    @Autowired
    TariffInfoService tariffInfoService;

    @Autowired
    TariffCondHService tariffCondHService;

    @Autowired
    TariffCondValDService tariffCondValDService;

    @GetMapping("/header/cond")
    public ResTariffHeaderCondGetDto getTariffHeaderCond(){
        return tariffInfoService.getTariffHeaderCond();
    }

    @PostMapping("/header")
    public ResTariffHeaderPostDto postTariffHeader(@RequestBody ReqTariffHeaderPostDto reqTariffHeaderPostDto){
        return tariffInfoService.postTariffHeader(reqTariffHeaderPostDto);
    }

    @GetMapping("/searchNode")
    public List<ResDestInfoGetDto> getAllDestInfo() {
        return tariffCondHService.getAllDestInfo();
    }


    @GetMapping("/searchLcc")
    public List<ResLccInfoGetDto> getLccInfo(@RequestParam String lccCd, @RequestParam String subLccCd, @RequestParam String lccCdNm) {
        return tariffCondHService.getLccInfo(lccCd, subLccCd, lccCdNm);
    }

    @GetMapping("/{cntrtId}")
    public List<CntrtInfoEntity> getAllCntrtInfo(@PathVariable String cntrtId){
        return tariffCondHService.getAllCntrtInfo(cntrtId);
    }
}
