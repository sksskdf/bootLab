package com.example.bootlab.controller

import com.example.bootlab.exception.NotFoundException
import com.example.bootlab.model.Address
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap
import javax.validation.Valid

@RestController
class AddressController {
    private val addressBook = ConcurrentHashMap<Int, Address>()

    @PostMapping("/addresses")
    fun postAddress(@RequestBody @Valid address: Address): ResponseEntity<Address?> {
        addressBook[address.id] = address
        return ResponseEntity(addressBook[address.id], HttpStatus.OK)
    }

    @GetMapping("/addresses/{id}")
    fun getAddress(@PathVariable id: Int): ResponseEntity<Address?> {
        if (id == 4) {
            throw NotFoundException("Not Found !")
        }
        return ResponseEntity(addressBook[id], HttpStatus.OK)
    }

    @DeleteMapping("/addresses")
    fun removeAddress(@RequestParam id: Int): String {
        addressBook.remove(id)
        return "${addressBook[id]} removed from address book!"
    }

    @PutMapping("/addresses/{id}")
    fun putAddress(@PathVariable id: Int, @RequestBody address: Address): Address {
        addressBook[id] = address
        return address
    }

//    @ExceptionHandler(NotFoundException::class)
//    fun handleFlightNotFound(e: NotFoundException, request: WebRequest): ResponseEntity<CustomErrorMessage> {
//        val body = CustomErrorMessage(
//            HttpStatus.NOT_FOUND.value(),
//            LocalDateTime.now(),
//            e.message!!,
//            request.getDescription(false)
//        )
//        return ResponseEntity(body, HttpStatus.NOT_FOUND)
//    }
}