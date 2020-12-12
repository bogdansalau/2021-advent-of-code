package day9

class EncodingError(private val input: List<Int>) {

    private val preamble = 25
    private val illegalNr = 20874512

    fun solvePart1(): Int =
        input.windowed(preamble + 1, 1, false).filterNot { isSumOfPreviousPairs(it) }.first().drop(preamble)[0]

    fun solvePart2(): Int = sequenceSum(input)

    private fun isSumOfPreviousPairs(it: List<Int>): Boolean {
        val target = it[preamble]
        val others = it.take(preamble)

        var can = false
        for (i in 0 until (others.size - 1)) {
            for (j in (i + 1) until others.size) {
                if (others[i] + others[j] == target && others[i] != others[j]) can = true
            }
        }
        return can
    }

    private fun sequenceSum(it: List<Int>): Int {
        for (i in 0 until (it.size - 1)) {
            for (j in (i + 1) until it.size) {
                val subList = it.slice(i .. j)
                if (subList.sum() == illegalNr) {
                    return subList.maxOf { it } + subList.minOf { it }
                }
            }
        }
        return 0;
    }


}
