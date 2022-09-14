package com.example.bootlab;

import com.example.bootlab.Async.AsyncPasswordGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final AsyncPasswordGenerator passwordGenerator;

    public Runner(AsyncPasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        this.passwordGenerator.generateLong();
        this.passwordGenerator.generateShort();
    }
}
