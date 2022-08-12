package com.asavio.starwars.repository

import com.asavio.starwars.data.Planet
import com.asavio.starwars.utils.*
import org.springframework.stereotype.Repository
import java.lang.RuntimeException
import java.util.*
import javax.annotation.PostConstruct

@Repository
class PlanetRepository(val planets: MutableMap<String, Planet>) {

    fun planets() = planets.values.toList()

    fun planet(id: String) = planets[id] ?: throw RuntimeException("Could not find planet for the provided ID.")

    @PostConstruct
    fun init() = readTextFromFile("source/planets.csv")
        .splitLines()
        .looseHeader()
        .getRowsAndColumns()
        .planets(planets)

}

private fun RowsAndColumns.planets(planets: MutableMap<String, Planet>) {
    this.forEach {
        var id: String = UUID.randomUUID().toString()
        var name: String = ""
        var rotationPeriod: Int? = null
        var orbitalPeriod: Int? = null
        var diameter: String? = null
        var climate: String? = null
        var gravity: String? = null
        var terrain: String? = null
        var surfaceWater: Float? = null
        var population: String? = null
        for ((index, value) in it.withIndex()) {
            when (index) {
                0 -> name = value
                1 -> rotationPeriod = value.intOrNull
                2 -> orbitalPeriod = value.intOrNull
                3 -> diameter = value.stringOrNull
                4 -> climate = value.stringOrNull
                5 -> gravity = value.stringOrNull
                6 -> terrain = value.stringOrNull
                7 -> surfaceWater = value.floatOrNull
                8 -> population = value.stringOrNull
            }
        }
        planets[id] = Planet(
            id,
            name,
            rotationPeriod,
            orbitalPeriod,
            diameter,
            climate,
            gravity,
            terrain,
            surfaceWater,
            population
        )
    }
}
