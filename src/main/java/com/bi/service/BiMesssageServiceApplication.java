package com.bi.service;

import com.bisnode.microservice.config.MicroserviceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MicroserviceConfig.class)
public class BiMesssageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiMesssageServiceApplication.class, args);
    }
}
