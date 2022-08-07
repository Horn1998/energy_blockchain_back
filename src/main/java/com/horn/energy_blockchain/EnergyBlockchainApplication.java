package com.horn.energy_blockchain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.horn.energy_blockchain.mapper")
public class EnergyBlockchainApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnergyBlockchainApplication.class, args);
    }

}
