package com.scm.contract.tariff.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 계약요율조건 HEADER 정보
@Entity
@Table(name="tb_cntrt_trff_cond_h", schema="tcms")
@Data
public class TariffCondHEntity {
    @Id
    @Column(name="seq_no")
    private Integer seqNo; // 일련번호
    @Column(name="cntrt_id")
    private String cntrtId; // 계약 ID
    @Column(name="trff_id")
    private Integer trffId; // 타리프 ID
    @Column(name="lcc_cd")
    private String lccCd; // 물류비코드
    @Column(name="sub_lcc_cd")
    private String subLccCd; // 세부물류비코드
    @Column(name="lane_cd")
    private String laneCd; // 구간코드
    @Column(name="lane_id")
    private String laneId; // 구간ID
    @Column(name="cal_mthd_cd")
    private String calMthdCd; // 계산방법코드
    @Column(name="trff_stat_date")
    private String trffStatDate; // 타리프시작일자
    @Column(name="trff_end_date")
    private String trffEndDate; // 타리프종료일자
    @Column(name="cntrt_curr_cd")
    private String cntrtCurrCd; // 계약통화코드
    @Column(name="pay_curr_cd")
    private String payCurrCd; //지불통화코드
    @Column(name="inco_cd")
    private String incoCd; // 인도조건코드
    @Column(name="prod_gcd")
    private String prodGcd; // 제품그룹코드
    @Column(name="dep_cd")
    private String depCd; // 출발지 코드
    @Column(name="dep_nm")
    private String depNm; // 출발지명
    @Column(name="arr_cd")
    private String arrCd; // 목적지
    @Column(name="arr_nm")
    private String arrNm; // 목적지명
    @Column(name="corp_id")
    private String corpId; // 법인 ID
    @Column(name="del_yn")
    private String delYn; // 삭제여부
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
}
