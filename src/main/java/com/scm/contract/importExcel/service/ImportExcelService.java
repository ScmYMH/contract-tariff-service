package com.scm.contract.importExcel.service;


import com.scm.contract.importExcel.model.ImportExcelDto;

import java.util.List;

public interface ImportExcelService {

    List<ImportExcelDto> postImportExcelData();
}
