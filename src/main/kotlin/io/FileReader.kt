package io

import java.io.File

fun readArray(file: String): List<Int> {
    return readFileDirectlyAsText(file)
        .split("\n")
        .map { try { it.toInt() } catch (e: NumberFormatException) { Integer.MAX_VALUE } }
}

fun readFileDirectlyAsText(fileName: String): String
        = File(fileName).readText(Charsets.UTF_8)
