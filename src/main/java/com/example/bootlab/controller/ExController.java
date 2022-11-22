package com.example.bootlab.controller;

import com.example.bootlab.model.Ex;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Ex getSome(@PathVariable int id) {
        return exList.get(id-1);
    }
}
