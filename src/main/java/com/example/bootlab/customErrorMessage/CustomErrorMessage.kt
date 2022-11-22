package com.example.bootlab.customErrorMessage

import java.time.LocalDateTime

class CustomErrorMessage (
    var statusCode:Int,
    var timeStamp: LocalDateTime,
    var message:String,
    var description:String
        )