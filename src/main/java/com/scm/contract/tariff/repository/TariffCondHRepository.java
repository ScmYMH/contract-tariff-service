package com.scm.contract.tariff.repository;

import com.scm.contract.tariff.entity.TariffCondHEntity;
import com.scm.contract.tariff.entity.TariffInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffCondHRepository extends JpaRepository<TariffCondHEntity, Integer> {
    List<TariffCondHEntity> findByCntrtIdAndTrffId(String cntrtId, Integer tariffId);

}
