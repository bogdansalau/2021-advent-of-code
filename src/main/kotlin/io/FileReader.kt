package io

import java.io.File

fun readArray(file: String): List<Int> {
    return readFileDirectlyAsText(file)
        .trim()
        .split("\n") // add \r before \n if parsing doesn't work
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
