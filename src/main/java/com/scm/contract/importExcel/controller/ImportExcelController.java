package com.scm.contract.importExcel.controller;

import com.scm.contract.importExcel.model.ImportExcelDto;
import com.scm.contract.importExcel.service.ImportExcelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("contract/tariff/import")
@Slf4j
public class ImportExcelController {

    @Autowired
    ImportExcelServiceImpl importExcelService;

    @PostMapping("")
    public List<ImportExcelDto> postImportExcelData(@RequestBody Map<String, List<ImportExcelDto>> mapImportExcelDto) {

        List<ImportExcelDto> importExcelDto = mapImportExcelDto.get("data");

        return importExcelService.postImportExcelData(importExcelDto);
    }

}
