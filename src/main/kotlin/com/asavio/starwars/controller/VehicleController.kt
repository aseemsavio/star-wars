package com.asavio.starwars.controller

import com.asavio.starwars.repository.VehicleRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class VehicleController(private val repository: VehicleRepository) {

    @QueryMapping
    fun vehicles() = repository.vehicles()

    @QueryMapping
    fun vehicle(@Argument id: String) = repository.vehicle(id)

}
