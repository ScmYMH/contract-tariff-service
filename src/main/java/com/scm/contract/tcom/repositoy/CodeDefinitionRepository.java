package com.scm.contract.tcom.repositoy;

import com.scm.contract.tcom.entity.CodeDefinitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeDefinitionRepository extends JpaRepository<CodeDefinitionEntity, Integer> {

    @Query("SELECT tb.cdVMeaning FROM CodeDefinitionEntity tb WHERE tb.cdV = :cdV")
    Optional<String> findCdVMeaningByCdV(@Param("cdV") String cdV);

    @Query("SELECT tb.cdV FROM CodeDefinitionEntity tb WHERE tb.cdVMeaning = :cdVMeaning")
    Optional<String> findCdVByCdVMeaning(@Param("cdVMeaning") String cdVMeaning);

//    @Query("SELECT new map(tb.cdV as cdV, tb.cdVMeaning as cdVMeaning) FROM CodeDefinitionEntity tb WHERE tb.cdTpMeaning = :cdTpMeaning")
//    List<Map<String,String>> findAllCdVByCdTpMeaning(@Param("cdTpMeaning") String cdTpMeaning);

}
