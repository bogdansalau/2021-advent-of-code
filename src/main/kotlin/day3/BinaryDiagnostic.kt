package day3

class BinaryDiagnostic(input: List<String>) {

    private val commands = input

    fun solvePart1(): Int {
        var zeros = List(commands[0].length) { 0 }
        var ones = List(commands[0].length) { 0 }

        commands.forEach {
            zeros = countChar(zeros, it, '0')
            ones = countChar(ones, it, '1')
        }

        val gamma = getGamma(zeros, ones)

        val epsilon = getEpsilon(zeros, ones)

        return gamma * epsilon
    }

    fun getGamma(
        zeros: List<Int>,
        ones: List<Int>
    ) = zeros.zip(ones) { zero, one -> if (zero > one) "0" else "1" }
        .reduce { acc, c -> acc + c }
        .toInt(2)

    fun getEpsilon(
        zeros: List<Int>,
        ones: List<Int>
    ) = zeros.zip(ones) { zero, one -> if (zero <= one) "0" else "1" }
        .reduce { acc, c -> acc + c }
        .toInt(2)

    fun countChar(zeros: List<Int>, s: String, toCount: Char): List<Int> {
        return zeros.zip(s.toCharArray().asIterable()) { freq, char ->
            freq + if (char == toCount) 1 else 0
        }
    }

//    fun solvePart2(): Int {
//
//    }

}
