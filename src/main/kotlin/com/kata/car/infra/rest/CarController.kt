package com.kata.car.infra.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CarController {

    @GetMapping("/hello")
    fun hello()  = "Hello Car Kata"

}