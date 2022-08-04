package com.scm.contract.tariff.repository;

import com.scm.contract.tariff.entity.TariffCondValDEntity;
import com.scm.contract.tariff.entity.TariffInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffCondValDRepository extends JpaRepository<TariffCondValDEntity, Integer> {
}
