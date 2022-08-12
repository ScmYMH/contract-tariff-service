package com.scm.contract.importExcel.service;

import com.scm.contract.importExcel.model.ImportExcelDto;
import com.scm.contract.importExcel.repository.ImportExcelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportExcelServiceImpl implements ImportExcelService {

    @Autowired
    ImportExcelMapper importExcelMapper;

    @Override
    public List<ImportExcelDto> postImportExcelData() {

        return importExcelMapper.postImportExcelData();
    }

}
