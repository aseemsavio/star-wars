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
    val diameter: Long?,
    val climate: String?,
    val gravity: String?,
    val terrain: String?,
    val surfaceWater: Float?,
    val population: Long?
)

