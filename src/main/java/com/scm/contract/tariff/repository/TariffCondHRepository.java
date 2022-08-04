package com.scm.contract.tariff.repository;

import com.scm.contract.tariff.entity.TariffCondHEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffCondHRepository extends JpaRepository<TariffCondHEntity, Integer> {
}
