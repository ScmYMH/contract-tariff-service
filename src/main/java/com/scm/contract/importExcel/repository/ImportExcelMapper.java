package com.scm.contract.importExcel.repository;

import com.scm.contract.importExcel.model.ImportExcelDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImportExcelMapper {

    List<ImportExcelDto> postImportExcelData();
}
