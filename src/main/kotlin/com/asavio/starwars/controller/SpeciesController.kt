package com.asavio.starwars.controller

import com.asavio.starwars.repository.SpeciesRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class SpeciesController(private val repository: SpeciesRepository) {

    @QueryMapping
    fun species() = repository.species()

    @QueryMapping
    fun singleSpecies(@Argument id: String) = repository.singleSpecies(id)

}
