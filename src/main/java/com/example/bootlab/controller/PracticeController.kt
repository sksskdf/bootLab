package com.example.bootlab.controller

import com.example.bootlab.model.Task
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PracticeController {
    val taskList = mutableListOf(
        Task(1, "task1", "A first test task", false),
        Task(2, "task2", "A second test task", true)
    )


//    @GetMapping("/tasks/{id}")
//    fun getTask(@PathVariable id: Int): Task? {
//        return taskList[id - 1] // list indices start from 0
//    }

    @GetMapping("/tasks/{id}")
    fun getTasks(@PathVariable id: Int): ResponseEntity<Task?> {
        return ResponseEntity(taskList[id - 1], HttpStatus.ACCEPTED)
    }

    @PostMapping("/tasks")
    fun postTasks(@RequestParam id: Int, @RequestBody task: Task): ResponseEntity<Task?> {
        taskList.add(task)
        return ResponseEntity(taskList[id-1], HttpStatus.OK)
    }
}