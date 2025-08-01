package com.joaoalves.storeapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        // SpringApplication.run(StoreApplication.class, args);
        var user = User.builder()
                .name("Joao")
                .password("pass")
                .email("joaoalves1102@outlook.pt")
                .build();

        var address = Address.builder()
                .city("Porto")
                .state("Porto")
                .zip("4700")
                .street("Rua")
                .build();

        user.addAddress(address);
        System.out.println(user);
    }

}
