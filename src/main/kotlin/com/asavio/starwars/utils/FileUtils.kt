package com.asavio.starwars.utils

import org.springframework.core.io.ClassPathResource
import java.io.File
import java.nio.file.Files

/**
 * Reads and returns the content as a [String].
 */
fun readTextFromFile(path: String): String {
    val resource: File = ClassPathResource(path).file
    return String(Files.readAllBytes(resource.toPath()))
}
