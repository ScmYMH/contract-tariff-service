package com.scm.contract.tariff.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 계약타리프 테이블
@Entity
@Table(name="tb_cntrt_trff_info", schema="tcms",
        uniqueConstraints = @UniqueConstraint(columnNames={"cntrt_id", "trff_id"}))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TariffInfoEntity {
    @Id
    @GeneratedValue
    @Column(name="trff_id")
    private Integer trffId; // 타리프 ID
    @Column(name="cntrt_id")
    private String cntrtId; // 계약 ID
    @Column(name="svc_tcd")
    private String svcTcd;// 서비스유형코드
    @Column(name="trff_nm")
    private String trffNm; // 타리프
    @Column(name="trff_desc")
    private String trffDesc; // 타리프설명
    @Column(name="biz_tcd")
    private String bizTcd; // 사업유형코드
    @Column(name="ar_ap_ccd")
    private String arApCcd; // 매출매입구분코드
    @Column(name="biz_div_cd")
    private String bizDivCd; // 사업영역코드 (null)
    @Column(name="cust_id")
    private String custId; // 거래처 ID (null)
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
    @Column(name="detl_svc_tcd")
    private String detlSvcTcd; // 상세 서비스 유형 코드

}
