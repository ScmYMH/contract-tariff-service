package com.scm.contract.tcom.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_dest_info", schema="tcom")
@Data // @Getter/@Setter, @ToString 등 생성
public class DestInfoEntity {
    @Id
    @Column(name="node_cd")
    private String nodeCd; // 목적지코드
    @Column(name="node_desc")
    private String nodeDesc; // 목적지명
    @Column(name="delivery_area_cd")
    private String deliveryAreaCd; // 대권역
    @Column(name="boundary_cd")
    private String boundaryCd; // 소권역
    @Column(name="nation_cd")
    private String nationCd; // 국가코드
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
