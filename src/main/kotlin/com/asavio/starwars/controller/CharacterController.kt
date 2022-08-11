package com.asavio.starwars.controller

import com.asavio.starwars.repository.CharacterRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class CharacterController(private val repository: CharacterRepository) {

    @QueryMapping
    fun characters() = repository.characters()

    @QueryMapping
    fun character(@Argument id: String) = repository.character(id)

}