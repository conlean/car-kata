package com.kata.car.core.actions

import com.kata.car.core.domain.entities.Car
import com.kata.car.core.domain.entities.CarColor
import com.kata.car.core.domain.entities.CarId
import com.kata.car.core.domain.repositories.CarRepository
import com.kata.car.infra.repositories.InMemoryCarRepository
import org.junit.Test

import org.mockito.Mockito.*


class CreateCarTest {

    private val car = Car(color = CarColor("black"), id = CarId(1L))
    private val anotherCar = Car(color = CarColor("red"), id = CarId(2L))
    private lateinit var carRepository: CarRepository
    private lateinit var createCarAction: CreateCar

    @Test
    fun `create a car successfully`() {

        givenACarRepository()
        givenAnAction(carRepository)

        whenCreateCarIsInvoked(with = car)

        thenCarIsCreated()

    }

    private fun givenACarRepository() {
        carRepository = mock(CarRepository::class.java)
        `when`(carRepository.count()).thenReturn(1)
    }

    @Test
    fun `create two cars successfully`() {

        givenAInMemoryCarRepository()
        givenAnAction(carRepository)

        whenCreateCarIsInvoked(car)
        whenCreateCarIsInvoked(anotherCar)

        thenCarIsCreatedTwice()

    }

    private fun givenAInMemoryCarRepository() {
        carRepository = InMemoryCarRepository()
    }

    private fun thenCarIsCreatedTwice() {
        assert(carRepository.count() == 2)
    }

    private fun thenCarIsCreated() {
        verify(carRepository, times(1)).save(car)
    }

    private fun whenCreateCarIsInvoked(with: Car) {
        createCarAction.invoke(with)
    }

    private fun givenAnAction(carRepository: CarRepository) {
        this.carRepository = carRepository
        createCarAction = CreateCar(carRepository)
    }


}
