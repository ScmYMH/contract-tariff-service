package com.scm.contract.tariff.controller;

import com.scm.contract.tariff.dto.*;
import com.scm.contract.tariff.service.TariffCondHService;
import com.scm.contract.tariff.service.TariffCondValDService;
import com.scm.contract.tariff.service.TariffInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tariff")
@Slf4j
public class TariffController {

    @Autowired
    TariffInfoService tariffInfoService;

    @Autowired
    TariffCondHService tariffCondHService;

    @Autowired
    TariffCondValDService tariffCondValDService;

    @GetMapping("/header/{cntrtId}/{tariffId}")
    public ResTariffHeaderDto getTariffHeader(@PathVariable String cntrtId, @PathVariable Integer tariffId){
        return tariffInfoService.getTariffHeader(cntrtId, tariffId);
    }

    @PostMapping("/header")
    public ResTariffHeaderDto postTariffHeader(@RequestBody ReqTariffHeaderPostDto reqTariffHeaderPostDto){
        return tariffInfoService.postTariffHeader(reqTariffHeaderPostDto);
    }

    @GetMapping("/{cntrtId}/{tariffId}")
    public List<ResTariffCondHDto> getTariffCondH(@PathVariable String cntrtId, @PathVariable Integer tariffId){
        return tariffCondHService.getTariffCondH(cntrtId, tariffId);
    }

    @PostMapping("")
    public List<ResTariffCondHDto> postTariffCondH(@RequestBody ReqTariffCondHPostDto reqTariffCondHPostDto){
        return tariffCondHService.postTariffCondH(reqTariffCondHPostDto);
    }

    @DeleteMapping("/{seqNoParam}")
    public List<ResTariffCondHDto> deleteTariffCondH(@PathVariable String seqNoParam){
        return tariffCondHService.deleteTariffCondH(seqNoParam);
    }

    @GetMapping("/searchNode")
    public List<ResDestInfoGetDto> getAllDestInfo() {
        return tariffCondHService.getAllDestInfo();
    }


    @GetMapping("/searchLcc")
    public List<ResLccInfoGetDto> getLccInfo(@RequestParam String lccCd, @RequestParam String subLccCd, @RequestParam String lccCdNm) {
        return tariffCondHService.getLccInfo(lccCd, subLccCd, lccCdNm);
    }

}
