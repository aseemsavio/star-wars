package com.asavio.starwars.utils

fun String.splitLines(): List<String> = this.split("\n")

fun List<String>.looseHeader(): List<String> {
    val list = this.toMutableList()
    list.removeFirst()
    return list
}

fun List<String>.getRowsAndColumns(): List<List<String>> {
    val strings = mutableListOf<List<String>>()
    this.forEach {
        val stringsInEachRow = it.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)").toList()
        strings.add(stringsInEachRow)
    }
    return strings
}

val String.stringOrNull
    get(): String? {
        return if (this == "NA") null else this
    }

val String.intOrNull
    get(): Int? {
        return if (this == "NA") null else this.toInt()
    }