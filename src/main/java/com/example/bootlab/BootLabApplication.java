package com.example.bootlab;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BootLabApplication {
    public static void main(String[] args) {
        var ac = SpringApplication.run(BootLabApplication.class, args);
    }
}
