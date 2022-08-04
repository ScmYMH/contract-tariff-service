package com.scm.contract.tariff.service;

import com.scm.contract.tariff.repository.TariffInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TariffInfoServiceImpl implements TariffInfoService{

    @Autowired
    TariffInfoRepository tariffInfoRepository;
}
