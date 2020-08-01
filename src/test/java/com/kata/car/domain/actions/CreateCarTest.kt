package com.kata.car.domain.actions

import com.kata.car.domain.entities.Car
import com.kata.car.domain.entities.CarColor
import com.kata.car.domain.repositories.CarRepository
import com.kata.car.domain.repositories.InMemoryCarRepository
import junit.framework.Assert.assertTrue
import org.junit.Test


class CreateCarTest {

    private val anotherCar = Car(color = CarColor("red"))
    private lateinit var carRepository: CarRepository
    private lateinit var createCarAction: CreateCar
    private val car = Car(color = CarColor("black"))

    @Test
    fun `create a car successfully`(){

        givenAnAction(InMemoryCarRepository(mutableMapOf(1L to car)))

        whenCreateCarIsInvoked(with = car)

        // then
        thenCountIs(value = 1)

    }

    @Test
    fun `create two cars successfully`(){

        givenAnAction(InMemoryCarRepository())

        whenCreateCarIsInvoked(car)
        whenCreateCarIsInvoked(anotherCar)

        thenCountIs(value = 2)

    }

    private fun thenCountIs(value: Int) {
        assertTrue(carRepository.count() == value)
    }

    private fun whenCreateCarIsInvoked(with: Car) {
        createCarAction.invoke(car)
    }

    private fun givenAnAction(carRepository: CarRepository) {
        this.carRepository = carRepository
        createCarAction = CreateCar(carRepository)
    }


}
