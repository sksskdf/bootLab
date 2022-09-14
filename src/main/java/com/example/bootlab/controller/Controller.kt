package com.example.bootlab.controller

import com.example.bootlab.model.Task
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    val taskList = listOf(
        Task(1, "task1", "A first test task", false),
        Task(2, "task2", "A second test task", true))


    @GetMapping("/tasks/{id}")
    fun getTask(@PathVariable id: Int): Task? {
        return taskList[id - 1] // list indices start from 0
    }

}