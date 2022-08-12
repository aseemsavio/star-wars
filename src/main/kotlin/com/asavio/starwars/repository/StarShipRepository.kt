package com.asavio.starwars.repository

import com.asavio.starwars.data.StarShip
import com.asavio.starwars.utils.*
import org.springframework.stereotype.Repository
import java.lang.RuntimeException
import java.util.*
import javax.annotation.PostConstruct

@Repository
class StarShipRepository(val starShips: MutableMap<String, StarShip>) {

    fun starShips() = starShips.values.toList()

    fun starShip(id: String) =
        starShips[id] ?: throw RuntimeException("Could not find a star ship with teh provided ID.")

    @PostConstruct
    fun init() {
        readTextFromFile("/source/starships.csv")
            .splitLines()
            .looseHeader()
            .getRowsAndColumns()
            .starShips(starShips)
    }

}

private fun List<List<String>>.starShips(starShips: MutableMap<String, StarShip>) {
    this.forEach {
        val id = UUID.randomUUID().toString()
        var name = ""
        var model: String? = null
        var manufacturer: String? = null
        var costInCredit: String? = null
        var length: Float? = null
        var maxSpeed: String? = null
        var crew: String? = null
        var passengers: String? = null
        var cargoCapacity: String? = null
        var consumables: String? = null
        it.forEachIndexed { index, value ->
            when (index) {
                0 -> name = value
                1 -> model = value.stringOrNull
                2 -> manufacturer = value.stringOrNull
                3 -> costInCredit = value.stringOrNull
                4 -> length = value.floatOrNull
                5 -> maxSpeed = value.stringOrNull
                6 -> crew = value.stringOrNull
                7 -> passengers = value.stringOrNull
                8 -> cargoCapacity = value.stringOrNull
                9 -> consumables = value.stringOrNull
            }
        }
        starShips[id] = StarShip(
            id,
            name,
            model,
            manufacturer,
            costInCredit,
            length,
            maxSpeed,
            crew,
            passengers,
            cargoCapacity,
            consumables
        )
    }
}
