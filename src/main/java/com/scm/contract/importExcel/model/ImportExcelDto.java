package com.scm.contract.importExcel.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ImportExcelDto {

    private String cntrt_id; //계약Id
    private String trff_id; //타리프Id
    private Integer val_seq_no; //일련번호(seq 발번)
    private String lcc_cd; //물류비 코드
    private String sub_lcc_cd; //세부물류비 코드
    private String trff_stat_date; //타리프 시작일
    private String trf_end_date; //타리프 종료일
    private String cntrt_curr_cd; //계약통화코드
    private String pay_curr_cd; //지불통화코드
    private String inco_cd; //인도조건코드
    private String prod_gcd; //제품그룹코드
    private String arr_cd; //목적지 코드
    private String del_yn; //삭제여부
    private String ins_date; //입력일자
    private String ins_time; //입력시각
    private String ins_person_id; //입력자Id
    private String dep_cd; //출발지 코드
    private String dep_nm; //출발지명
    private String arr_nm; //도착지명

    private String cond_id; //조건Id
    private String cal_unit_cd; //계산단위
    private Integer unit_price; //계약단가
    private String corp_id;
}
