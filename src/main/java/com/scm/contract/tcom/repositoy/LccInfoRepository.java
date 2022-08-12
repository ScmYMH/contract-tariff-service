package com.scm.contract.tcom.repositoy;

import com.scm.contract.tcom.entity.LccInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LccInfoRepository extends JpaRepository<LccInfoEntity, Integer> {
    List<LccInfoEntity> findByLccCdContainingAndSubLccCdContainingAndLccCdNmContaining(String lccCd, String subLccCd, String lccCdNm);
}
