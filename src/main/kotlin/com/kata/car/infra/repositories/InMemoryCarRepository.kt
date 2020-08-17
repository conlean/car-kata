package com.kata.car.infra.repositories

import com.kata.car.core.domain.entities.Car
import com.kata.car.core.domain.entities.CarId
import com.kata.car.core.domain.repositories.CarRepository

class InMemoryCarRepository(var cars: MutableMap<CarId, Car> = mutableMapOf()) : CarRepository {

    override fun count() = cars.size

    override fun save(car: Car) {
        cars[car.id] = car
    }

    override fun findById(carId: CarId): Car? {
        return cars[carId]
    }
}