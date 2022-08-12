package com.scm.contract.tcom.repositoy;

import com.scm.contract.tcom.entity.CodeDefinitionEntity;
import com.scm.contract.tcom.entity.DestInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestInfoRepository extends JpaRepository<DestInfoEntity, String> {
    List<DestInfoEntity> findByNodeCdContainingAndNodeDescContainingAndNationCdContaining(String nodeCd, String nodeDesc, String nationCd);
}
