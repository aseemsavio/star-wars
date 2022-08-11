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
