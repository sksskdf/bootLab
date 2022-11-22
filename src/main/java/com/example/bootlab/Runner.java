package com.example.bootlab;

import com.example.bootlab.async.AsyncPasswordGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//@Component
public class Runner implements CommandLineRunner {
    private final AsyncPasswordGenerator passwordGenerator;

    public Runner(AsyncPasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        CompletableFuture<String> longPassFuture = this.passwordGenerator.generateLong();
        CompletableFuture<String> shortPassFuture = this.passwordGenerator.generateShort();

        try {
            String longPass = longPassFuture.get();
            String shortPass = shortPassFuture.get();

            System.out.println(longPass);
            System.out.println(shortPass);

        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }
    }
}
