package com.kata.car.domain.actions

import com.kata.car.domain.entities.Car
import com.kata.car.domain.entities.CarColor
import com.kata.car.domain.repositories.CarRepository
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*


class CreateCarTest {

    private val anotherCar = Car(color = CarColor("red"))
    private lateinit var carRepository: CarRepository
    private lateinit var createCarAction: CreateCar
    private val car = Car(color = CarColor("black"))

    @Test
    fun `create a car successfully`(){

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
    fun `create two cars successfully`(){

        givenACarRepository()
        givenAnAction(carRepository)

        whenCreateCarIsInvoked(car)
        whenCreateCarIsInvoked(anotherCar)

        thenCarIsCreatedTwice()

    }

    private fun thenCarIsCreatedTwice() {
        verify(carRepository, times(2)).save(any())
    }

    private fun thenCarIsCreated() {
        verify(carRepository, times(1)).save(car)
    }

    private fun whenCreateCarIsInvoked(with: Car) {
        createCarAction.invoke(car)
    }

    private fun givenAnAction(carRepository: CarRepository) {
        this.carRepository = carRepository
        createCarAction = CreateCar(carRepository)
    }


}
