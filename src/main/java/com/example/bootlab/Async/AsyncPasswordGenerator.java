package com.example.bootlab.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AsyncPasswordGenerator {
    private PasswordGenerator passwordGenerator;

    public AsyncPasswordGenerator(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    @Async
    public void generateLong() throws InterruptedException {
        System.out.println("A long password: " + passwordGenerator.generate(10));
        System.out.println(Thread.currentThread());
    }

    @Async
    public void generateShort() throws InterruptedException {
        System.out.println("A short password: " + passwordGenerator.generate(5));
        System.out.println(Thread.currentThread());
    }
}
