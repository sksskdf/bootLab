package com.example.bootlab.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class NotFoundException(cause:String) : RuntimeException(cause)