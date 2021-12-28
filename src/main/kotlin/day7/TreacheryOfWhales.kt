package day7

import kotlin.math.abs

class TreacheryOfWhales(input: String) {

    private val positions = input.trim().split(",").map { it.toInt() }

    fun solvePart1(): Int =
        (0..positions.maxOf { it })
            .map { pivot ->
                positions
                    .map {
                        abs(pivot - it)
                    }.sum()
            }.minOf { it }

    fun solvePart2(): Int =
        (0..positions.maxOf { it })
            .map { pivot ->
                positions
                    .map {
                        val abs = abs(pivot - it)
                        abs.times(abs + 1) / 2
                    }.sum()
            }.minOf { it }

}
