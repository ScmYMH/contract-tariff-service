package com.scm.contract.importExcel.service;

import com.scm.contract.importExcel.model.ImportExcelDto;
import com.scm.contract.importExcel.repository.ImportExcelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ImportExcelServiceImpl implements ImportExcelService {

    @Autowired
    ImportExcelMapper importExcelMapper;

    @Override
    public List<ImportExcelDto> postImportExcelData(List<ImportExcelDto> importExcelDto) {

        Date today = new Date();

        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setDel_yn("N"));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setIns_date(new SimpleDateFormat("yyyyMMdd").format(today)));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setIns_time(new SimpleDateFormat("HHmmss").format(today)));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setIns_person_id("202207130004"));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setArr_cd(importExcelDto1.getArr_cd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setArr_nm(importExcelDto1.getArr_nm()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setDep_cd(importExcelDto1.getDep_cd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setDep_nm(importExcelDto1.getDep_nm()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setProd_gcd(importExcelDto1.getProd_gcd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setInco_cd(importExcelDto1.getInco_cd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setPay_curr_cd(importExcelDto1.getPay_curr_cd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setCntrt_curr_cd(importExcelDto1.getCntrt_curr_cd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setTrf_end_date(importExcelDto1.getTrf_end_date()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setTrff_stat_date(importExcelDto1.getTrff_stat_date()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setSub_lcc_cd(importExcelDto1.getSub_lcc_cd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setLcc_cd(importExcelDto1.getLcc_cd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setTrff_id("271313"));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setCntrt_id("20220501000003"));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setVal_seq_no(1));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setCond_id(importExcelDto1.getCond_id()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setCal_unit_cd(importExcelDto1.getCal_unit_cd()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setUnit_price(importExcelDto1.getUnit_price()));
        importExcelDto.forEach(importExcelDto1 -> importExcelDto1.setCorp_id("PI"));


        return importExcelMapper.postImportExcelData(importExcelDto);
    }

}
