package com.scm.contract.tariff.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

// 계약요율 조건별 운임상세
@Entity
@Table(name="tb_cntrt_trff_cond_val_d", schema="tcms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TariffCondValDEntity {
    @Id
//    @GeneratedValue
    @Column(name="seq_no")
    private Integer seqNo; // 일련번호
    @Column(name="cntrt_id", insertable = true, updatable = false)
    private String cntrtId; // 계약 ID
    @Column(name="trff_id", insertable = true, updatable = false)
    private Integer trffId; // 타리프 ID
    @Column(name="val_seq_no", insertable = true, updatable = false)
    private Integer valSeqNo; // 일련번호(SEQ발번)
    @Column(name="curr_cnt", insertable = true, updatable = false)
    private Integer currCnt; // SEQ_NO에 매달린 VAL_SEQ_NO의 개수
    @Column(name="cond_yn", insertable = true, updatable = false)
    private String condYn; // 조건등록여부
    @Column(name="cond_id", insertable = true, updatable = false)
    private String condId; // 조건 ID
    @Column(name="cond_nm", insertable = true, updatable = false)
    private String condNm; // 조건명
    @Column(name="price_tcd", insertable = true, updatable = false)
    private String priceTcd; // 금액단위
    @Column(name="cal_unit_cd")
    private String calUnitCd; // 계산단위
    @Column(name="cntrt_curr_cd")
    private String cntrtCurrCd; // 게약통화
    @Column(name="pay_curr_cd")
    private String payCurrCd; // 지불통화
    @Column(name="unit_price")
    private BigDecimal unitPrice; // 계약단가
    @Column(name="corp_id", insertable = true, updatable = false)
    private String corpId; // 법인 ID
    @Column(name="del_yn")
    private String delYn; // 삭제여부
    @Column(name="ins_date", insertable = true, updatable = false)
    private String insDate;
    @Column(name="ins_time", insertable = true, updatable = false)
    private String insTime;
    @Column(name="ins_person_id", insertable = true, updatable = false)
    private String insPersonId;
    @Column(name="upd_date")
    private String updDate;
    @Column(name="upd_time")
    private String updTime;
    @Column(name="upd_person_id")
    private String updPersonId;
}
