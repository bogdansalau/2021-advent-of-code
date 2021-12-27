package day6

import java.math.BigInteger


class Lanternfish(input: List<String>, private val daysToSimulate: Int) {
    private val fish = input[0].split(",").map { it.toInt() }
    private val fishDueDates = ArrayDeque<BigInteger>(9)
        .apply {
            repeat(9) {
                this.add(BigInteger.ZERO)
            }
        }
        .apply {
            fish.forEach {
                this[it] = this[it].inc()
            }
        }

    fun solvePart1(ticks: Int): Int {
        var state = fish

        (0 until ticks).forEach { _ ->
            state = tick(state)
        }

        return state.size
    }

    private fun tick(currentState: List<Int>): List<Int> {
        val nextState = mutableListOf<Int>()
        currentState.forEach {
            when (it) {
                in 1..8 -> nextState.add(it - 1)
                0 -> {
                    nextState.add(8)
                    nextState.add(6)
                }
            }
        }
        return nextState.toList()
    }

    fun solvePart2(): BigInteger {
        return simulateDays(fishDueDates, daysToSimulate)
    }

    private fun simulateDays(fishDueDates: ArrayDeque<BigInteger>, daysToSimulate: Int): BigInteger {
        repeat(daysToSimulate) {
            val dueNow = fishDueDates.removeFirst()
            fishDueDates[6] = fishDueDates[6].add(dueNow)
            fishDueDates.addLast(dueNow)
        }
        return fishDueDates.sumOf { it }
    }

}
