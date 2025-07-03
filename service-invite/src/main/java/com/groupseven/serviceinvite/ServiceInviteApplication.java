package com.groupseven.serviceinvite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceInviteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceInviteApplication.class, args);
    }

}
