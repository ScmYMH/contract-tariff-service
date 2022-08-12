package com.scm.contract.importExcel.controller;

import com.scm.contract.importExcel.model.ImportExcelDto;
import com.scm.contract.importExcel.service.ImportExcelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("contract/tariff/import")
@Slf4j
public class ImportExcelController {

    @Autowired
    ImportExcelServiceImpl importExcelService;

    @PostMapping("")
    public List<ImportExcelDto> postImportExcelData() {
        ImportExcelDto importExcelDto = new ImportExcelDto();

        return importExcelService.postImportExcelData();
    }

}
