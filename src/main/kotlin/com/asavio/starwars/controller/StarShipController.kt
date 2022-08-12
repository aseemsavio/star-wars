package com.asavio.starwars.controller

import com.asavio.starwars.repository.StarShipRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class StarShipController(private val repository: StarShipRepository) {

    @QueryMapping
    fun starShips() = repository.starShips()

    @QueryMapping
    fun starShip(@Argument id: String) = repository.starShip(id)

}
