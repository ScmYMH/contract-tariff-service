package com.scm.contract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ContractTariffServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContractTariffServiceApplication.class, args);
    }

}
