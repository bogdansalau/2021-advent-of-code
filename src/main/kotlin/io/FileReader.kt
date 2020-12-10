package io

import java.io.File

fun readArray(file: String): List<Int> {
    return readFileDirectlyAsText(file)
        .trim()
        .split("\n")
        .map {
            try {
                it.toInt()
            } catch (e: NumberFormatException) {
                Integer.MAX_VALUE
            }
        }
}

fun readStringArray(file: String): List<String> {
    return readFileDirectlyAsText(file)
        .trim()
        .split("\n")
}

fun readFileDirectlyAsText(fileName: String): String = File(fileName).readText(Charsets.UTF_8)
