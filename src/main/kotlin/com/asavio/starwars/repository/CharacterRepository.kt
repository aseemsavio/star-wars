package com.asavio.starwars.repository

import com.asavio.starwars.data.Character
import com.asavio.starwars.utils.*
import org.springframework.stereotype.Repository
import java.lang.RuntimeException
import java.util.UUID
import javax.annotation.PostConstruct

@Repository
class CharacterRepository(val characters: MutableMap<String, Character> = mutableMapOf()) {

    fun characters() = characters.values.toList()

    fun character(id: String) =
        characters[id] ?: throw RuntimeException("Could not find a character with the provided ID")

    @PostConstruct
    fun init() = readTextFromFile("source/characters.csv")
        .splitLines()
        .looseHeader()
        .getRowsAndColumns()
        .characters(characters)

}

private fun RowsAndColumns.characters(characters: MutableMap<String, Character>) {
    this.forEach {
        val id: String = UUID.randomUUID().toString()
        var name = ""
        var height: Float? = null
        var mass: Float? = null
        var hairColor: String? = null
        var skinColor: String? = null
        var eyeColor: String? = null
        var birthYear: String? = null
        var gender: String? = null
        var homeWorld: String? = null
        var species = ""
        it.forEachIndexed { index, value ->
            when (index) {
                0 -> name = value
                1 -> height = value.floatOrNull
                2 -> mass = value.floatOrNull
                3 -> hairColor = value.stringOrNull
                4 -> skinColor = value.stringOrNull
                5 -> eyeColor = value.stringOrNull
                6 -> birthYear = value.stringOrNull
                7 -> gender = value.stringOrNull
                8 -> homeWorld = value.stringOrNull
                9 -> species = value
            }
        }
        characters[id] = Character(
            id, name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender, homeWorld, species
        )
    }
}