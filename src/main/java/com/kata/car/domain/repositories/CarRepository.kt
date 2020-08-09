package com.kata.car.domain.repositories

import com.kata.car.domain.entities.Car

interface CarRepository {

    fun count(): Int
    fun save(car: Car)

}
