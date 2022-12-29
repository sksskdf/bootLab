package com.example.bootlab.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AOP {
    @Around("@annotation(com.example.bootlab.annotation.SomeAnnotation)")
    public void logging() {
        log.info("aop execution");
    }
}
