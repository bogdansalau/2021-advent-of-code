package day1

class SonarSweep(input: List<String>) {

    private val numbers = input.map { it.toInt() }

    fun solvePart1(): Int {
        var total = 0
        var prev = -1
        numbers.forEach {
            if (it > prev && prev != -1) total++
            prev = it
        }

        return total
    }

    fun solvePart2(): Int {
        val windowSize = 3
        var total = 0
        var prev = -1

        for (i in (windowSize - 1 until numbers.size)) {
            val window = window(i)
            if (window > prev && prev != -1) total++
            prev = window
        }

        return total
    }

    private fun window(i: Int): Int {
        return numbers[i] + numbers[i - 1] + numbers[i - 2]
    }

}
