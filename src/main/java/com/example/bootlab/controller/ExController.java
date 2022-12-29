package com.example.bootlab.controller;

import com.example.bootlab.annotation.SomeAnnotation;
import com.example.bootlab.model.Ex;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExController {
    List<Ex> exList = new ArrayList<>();

    @PostMapping("/post")
    public void postSome(@RequestBody Ex ex) {
        exList.add(ex);
    }

    @GetMapping("/get/{id}")
    @SomeAnnotation
    public Ex getSome(@PathVariable int id) {
        return exList.get(id-1);
    }
}
