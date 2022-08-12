package com.scm.contract.tcom.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_lcc_info", schema="tcom")
@Data // @Getter/@Setter, @ToString 등 생성
public class LccInfoEntity {
    @Id
    @Column(name="seq_no")
    private Integer seqNo; // 일련번호
    @Column(name="lcc_cd")
    private String lccCd; // 물류비코드
    @Column(name="sub_lcc_cd")
    private String subLccCd; // 세부물류비코드
    @Column(name="lcc_cd_nm")
    private String lccCdNm; // 물류비코드명
    @Column(name="lcc_cd_desc")
    private String lccCdDesc; // 물류비코드설명
    @Column(name="trns_cost_tcd")
    private String trnsCostTcd; // 운송비유형코드
    @Column(name="trns_cost_sub_tcd")
    private String trnsCostSubTcd; // 세부운송비유형코드
    @Column(name="trff_use_yn")
    private String trffUseYn; // 요율사용여부
    @Column(name="net_amt_yn")
    private String netAmtYn; // 순액총액여부
    @Column(name="del_yn")
    private String delYn; // 삭제여부
    @Column(name="ins_date")
    private String insDate; // 입력일자
    @Column(name="ins_time")
    private String insTime; // 입력시간
    @Column(name="ins_person_id")
    private String insPersonId; //입력자ID
    @Column(name="upd_date")
    private String updDate; // 수정일자
    @Column(name="upd_time")
    private String updTime; // 수정시간
    @Column(name="upd_person_id")
    private String updPersonId; //수정자ID
}
