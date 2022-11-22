package com.example.bootlab.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.http.ResponseEntity
import com.example.bootlab.customErrorMessage.CustomErrorMessage
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import java.util.LinkedHashMap

@ControllerAdvice
class ControllerExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    fun handleFlightNotFound(e: NotFoundException, request: WebRequest): ResponseEntity<CustomErrorMessage> {
        val body = CustomErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now(),
            e.message!!,
            request.getDescription(false)
        )
        return ResponseEntity(body, HttpStatus.NOT_FOUND)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest): ResponseEntity<Any> {
        
        val body: MutableMap<String, Any> = LinkedHashMap()
        body["status"] = status.value()
        body["timestamp"] = LocalDateTime.now()
        body["exception"] = ex.javaClass
        return ResponseEntity(body, headers, status)
    }
}