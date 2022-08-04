package com.scm.contract.tariff.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_cntrt_info", schema="tcms")
@Data // @Getter/@Setter, @ToString 등 생성
public class CntrtInfoEntity {
    @Id
    @Column(name="cntrt_id")
    private String cntrtId; // 계약 ID
    @Column(name="cntrt_tcd")
    private String cntrtTcd; // 계약 유형코드
    @Column(name="cntrt_nm")
    private String cntrtNm; // 계약명
    @Column(name="cntrt_scd")
    private String cntrtScd; // 계약 상태코드(Open, ReOpen)
    @Column(name="cre_person_id")
    private String crePersonId; // 계약 담당자 ID
    @Column(name="cntrt_start_date")
    private String cntrtStartDate; // 계약 시작일
    @Column(name="cntrt_end_date")
    private String cntrtEndDate; // 계약 종료일
    @Column(name="cntrt_curr_cd")
    private String cntrtCurrCd; // 계약 통화코드
    @Column(name="del_yn")
    private String delYn;
    @Column(name="ins_date")
    private String insDate;
    @Column(name="ins_time")
    private String insTime;
    @Column(name="ins_person_id")
    private String insPersonId;
    @Column(name="upd_date")
    private String updDate;
    @Column(name="upd_time")
    private String updTime;
    @Column(name="upd_person_id")
    private String updPersonId;
    @Column(name="corp_id")
    private String corpId;
}
