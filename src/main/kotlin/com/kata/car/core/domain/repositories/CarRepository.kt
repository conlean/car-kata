package com.kata.car.core.domain.repositories

import com.kata.car.core.domain.entities.Car
import com.kata.car.core.domain.entities.CarId

interface CarRepository {

    fun count(): Int
    fun save(car: Car)
    fun findById(carId: CarId): Car?

}
