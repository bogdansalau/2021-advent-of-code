package io

import java.io.File

fun readFileAsStringArray(file: String): List<String> {
    return readFileAsString(file)
        .trim()
        .split("\n")
}

fun readFileAsString(fileName: String): String = File(fileName).readText(Charsets.UTF_8)
