package com.asavio.starwars.repository

import com.asavio.starwars.data.Vehicle
import com.asavio.starwars.utils.*
import org.springframework.stereotype.Repository
import java.lang.RuntimeException
import java.util.UUID
import javax.annotation.PostConstruct

@Repository
class VehicleRepository(private val vehicles: MutableMap<String, Vehicle>) {

    fun vehicles() = vehicles.values.toList()

    fun vehicle(id: String) = vehicles[id] ?: throw RuntimeException("Could not find a vehicle with a given ID.")

    @PostConstruct
    @Suppress("unused")
    fun init() = readTextFromFile("/source/vehicles.csv")
        .splitLines()
        .looseHeader()
        .getRowsAndColumns()
        .vehicles(vehicles)
}

private fun RowsAndColumns.vehicles(vehicles: MutableMap<String, Vehicle>) = forEach {
    val id = UUID.randomUUID().toString()
    var name = ""
    var model = ""
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
            1 -> model = value
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
    vehicles[id] = Vehicle(
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

