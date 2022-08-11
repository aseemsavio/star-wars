package com.asavio.starwars.controller

import com.asavio.starwars.repository.PlanetRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class PlanetController(private val repository: PlanetRepository) {

    @QueryMapping
    fun planets() = repository.planets()

    @QueryMapping
    fun planet(@Argument id: String) = repository.planet(id)

}
