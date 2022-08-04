package com.scm.contract.tariff.service;

import com.scm.contract.tariff.repository.TariffCondHRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TariffCondHServiceImpl implements TariffCondHService{

    @Autowired
    TariffCondHRepository tariffCondHRepository;
}
