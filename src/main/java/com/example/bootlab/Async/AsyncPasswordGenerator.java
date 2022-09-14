package com.example.bootlab.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@EnableAsync
public class AsyncPasswordGenerator {
    private PasswordGenerator generator;

    public AsyncPasswordGenerator(PasswordGenerator generator) {
        this.generator = generator;
    }

//    @Async
//    public void generateLong() throws InterruptedException {
//        System.out.println("A long password: " + passwordGenerator.generate(10));
//        System.out.println(Thread.currentThread());
//    }
//
//    @Async
//    public void generateShort() throws InterruptedException {
//        System.out.println("A short password: " + passwordGenerator.generate(5));
//        System.out.println(Thread.currentThread());
//    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> generateLong() throws InterruptedException {
        System.out.println(Thread.currentThread());
        return CompletableFuture.completedFuture(("A long password: " + generator.generate(10)));
    }

    @Async
    public CompletableFuture<String> generateShort() throws InterruptedException {
        System.out.println(Thread.currentThread());
        return CompletableFuture.completedFuture("A short password: " + generator.generate(5));
    }
}
