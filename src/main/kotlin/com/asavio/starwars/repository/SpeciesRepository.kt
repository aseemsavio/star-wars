package com.asavio.starwars.repository

import com.asavio.starwars.data.Species
import com.asavio.starwars.utils.*
import org.springframework.stereotype.Repository
import java.lang.RuntimeException
import java.util.UUID
import javax.annotation.PostConstruct

@Repository
class SpeciesRepository(val species: MutableMap<String, Species> = mutableMapOf()) {

    fun species() = species.values.toList()

    fun singleSpecies(id: String) = species[id] ?: throw RuntimeException("Could not find a species with a provided ID.")

    @PostConstruct
    fun init() {
        readTextFromFile("/source/species.csv")
            .splitLines()
            .looseHeader()
            .getRowsAndColumns()
            .species(species)
    }

}

private fun List<List<String>>.species(species: MutableMap<String, Species>) {
    this.forEach {
        val id = UUID.randomUUID().toString()
        var name: String = ""
        var classification: String? = null
        var designation: String? = null
        var averageHeight: Int? = null
        var skinColors: String? = null
        var hairColors: String? = null
        var eyeColors: String? = null
        var averageLifespan: String? = null
        var language: String? = null
        var homeWorld: String? = null
        it.forEachIndexed { index, value ->
            when (index) {
                0 -> name = value
                1 -> classification = value.stringOrNull
                2 -> designation = value.stringOrNull
                3 -> averageHeight = value.intOrNull
                4 -> skinColors = value.stringOrNull
                5 -> hairColors = value.stringOrNull
                6 -> eyeColors = value.stringOrNull
                7 -> averageLifespan = value.stringOrNull
                8 -> language = value.stringOrNull
                9 -> homeWorld = value.stringOrNull
            }
        }
        species[id] = Species(
            id,
            name,
            classification,
            designation,
            averageHeight,
            skinColors,
            hairColors,
            eyeColors,
            averageLifespan,
            language,
            homeWorld
        )
    }
}
