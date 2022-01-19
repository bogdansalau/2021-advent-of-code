package day8

import java.math.BigInteger

class SevenSegmentSearch(input: List<String>) {

    private val segments =
        input
            .map {
                val splitInput = it.substringBefore("|").trim().split(" ")
                val splitOutput = it.substringAfter("|").trim().split(" ")

                splitInput to splitOutput
            }

    fun solvePart1(): Int =
        segments
            .asSequence()
            .map { it.second }
            .flatten()
            .filter { s -> s.length in setOf(2, 4, 3, 7) }
            .count()

    fun solvePart2(): Int {
        return 9
    }

}
