package com.scm.contract.tariff.repository;

import com.scm.contract.tariff.entity.TariffInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffInfoRepository extends JpaRepository<TariffInfoEntity, Integer> {
}
