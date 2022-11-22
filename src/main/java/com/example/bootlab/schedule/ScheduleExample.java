package com.example.bootlab.schedule;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@EnableAsync
public class ScheduleExample {

//    @Scheduled(fixedRate = 1000)
//    @Async
//    public void sayHi() throws InterruptedException {
//        System.out.println("hi");
//    }

    private ab a;

    public ScheduleExample(ab ab) {
        this.a = ab;
    }
}
