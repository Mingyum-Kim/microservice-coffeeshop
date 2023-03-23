package com.personal.msaservicecoffeemember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEurekaClient
@SpringBootApplication
public class MsaServiceCoffeeMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaServiceCoffeeMemberApplication.class, args);
    }

}
