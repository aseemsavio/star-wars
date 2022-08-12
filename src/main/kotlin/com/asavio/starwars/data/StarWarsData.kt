package com.asavio.starwars.data

data class Character(
    val id: String,
    val name: String,
    val height: Float?,
    val mass: Float?,
    val hairColor: String?,
    val skinColor: String?,
    val eyeColor: String?,
    val birthYear: String?,
    val gender: String?,
    val homeWorld: String?,
    val species: String?
)

data class Planet(
    val id: String,
    val name: String,
    val rotationPeriod: Int?,
    val orbitalPeriod: Int?,
    val diameter: String?,
    val climate: String?,
    val gravity: String?,
    val terrain: String?,
    val surfaceWater: Float?,
    val population: String?
)

data class Species(
    val id: String,
    val name: String,
    val classification: String?,
    val designation: String?,
    val averageHeight: Int?,
    val skinColors: String?,
    val hairColors: String?,
    val eyeColors: String?,
    val averageLifespan: String?,
    val language: String?,
    val homeWorld: String?
)


data class StarShip(
    val id: String,
    val name: String,
    val model: String?,
    val manufacturer: String?,
    val costInCredit: String?,
    val length: Float?,
    val maxSpeed: String?,
    val crew: String?,
    val passengers: String?,
    val cargoCapacity: String?,
    val consumables: String?
)

