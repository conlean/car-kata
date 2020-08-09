package com.kata.car.domain.repositories

import com.kata.car.domain.entities.Car

class InMemoryCarRepository(private var cars: Map<Long, Car> = mutableMapOf()) : CarRepository {
    override fun count() = cars.size
    override fun save(car: Car) {
        TODO("Not yet implemented")
    }
}