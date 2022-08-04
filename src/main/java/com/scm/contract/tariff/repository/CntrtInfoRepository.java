package com.scm.contract.tariff.repository;

import com.scm.contract.tariff.entity.CntrtInfoEntity;
import com.scm.contract.tariff.entity.TariffInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CntrtInfoRepository extends JpaRepository<CntrtInfoEntity, Integer> {
}
