package com.personal.status;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
public class MsaServiceCoffeeStatusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaServiceCoffeeStatusApplication.class, args);
    }

}
