package com.asavio.starwars.utils

import java.lang.NumberFormatException

fun String.splitLines(): List<String> = this.split("\n")

fun List<String>.looseHeader(): List<String> {
    val list = this.toMutableList()
    list.removeFirst()
    return list
}

fun List<String>.getRowsAndColumns(): RowsAndColumns {
    val strings = mutableListOf<List<String>>()
    this.forEach {
        val stringsInEachRow = it.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)".toRegex())
        strings.add(stringsInEachRow)
    }
    return strings
}

val String.stringOrNull
    get(): String? {
        return if (this.isNA()) null else this
    }

val String.intOrNull
    get(): Int? = value(String::toInt)

val String.floatOrNull
    get(): Float? = value(String::toFloat)

val String.longOrNull
    get(): Long? = value(String::toLong)

private inline fun <T : Number> String.value(toT: String.() -> T): T? = if (this.isNA()) null else {
    try {
        toT()
    } catch (e: NumberFormatException) {
        replaceCommasAndQuotes().toT()
    }
}

typealias RowsAndColumns = List<List<String>>

private fun String.isNA() = this == "NA" || this == "N/A" || this == "n/a"

private fun String.replaceCommasAndQuotes() = this.replace(",", "").replace("\"", "")
