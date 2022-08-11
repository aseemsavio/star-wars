package com.asavio.starwars.repository

import com.asavio.starwars.data.Character
import com.asavio.starwars.utils.*
import org.springframework.stereotype.Repository
import java.util.UUID
import javax.annotation.PostConstruct

@Repository
class CharacterRepository(val characters: MutableList<Character> = mutableListOf()) {

    @PostConstruct
    fun init() {
        val characters = readTextFromFile("source/characters.csv")
            .splitLines()
            .looseHeader()
            .getRowsAndColumns()
            .characters(characters)

        println(characters)
    }

}

private fun List<List<String>>.characters(characters: MutableList<Character>): List<Character> {
    this.forEach {
        var id: String = UUID.randomUUID().toString()
        var name = ""
        var height: Int? = null
        var mass: Int? = null
        var hairColor: String? = null
        var skinColor: String? = null
        var eyeColor: String? = null
        var birthYear: String? = null
        var gender: String? = null
        var homeWorld: String? = null
        var species = ""
        for ((index, value) in it.withIndex()) {
            when (index) {
                0 -> name = value
                1 -> height = value.intOrNull
                2 -> mass = value.intOrNull
                3 -> hairColor = value.stringOrNull
                4 -> skinColor = value.stringOrNull
                5 -> eyeColor = value.stringOrNull
                6 -> birthYear = value.stringOrNull
                7 -> gender = value.stringOrNull
                8 -> homeWorld = value.stringOrNull
                9 -> species = value
            }
            characters += Character(
                id, name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender, homeWorld, species
            )
        }
    }
    return characters
}