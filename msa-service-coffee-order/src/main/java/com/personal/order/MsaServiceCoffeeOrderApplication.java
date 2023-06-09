package com.personal.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
public class MsaServiceCoffeeOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaServiceCoffeeOrderApplication.class, args);
    }

}
