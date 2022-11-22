package com.example.bootlab.controller

import com.example.bootlab.model.UserInfo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserInfoController {

    @PostMapping("/user")
    fun userStatus(@RequestBody user: UserInfo): String {
        return if (user.enabled == true) {
            String.format("Hello! %s. Your account is enabled.", user.name)
        } else {
            String.format(
                "Hello! Nice to see you, %s! Your account is disabled",
                user.name
            )
        }
    }
}