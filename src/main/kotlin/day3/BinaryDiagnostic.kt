package day3

class BinaryDiagnostic(input: List<String>) {

    private val commands = input

    fun solvePart1(): Int {
        val gamma = getGamma(commands)
        val epsilon = getEpsilon(commands)

        return gamma * epsilon
    }

    fun getGamma(commands: List<String>) =
        getBitFrequency(commands, FrequencyStrategy.MOST_COMMON)
            .reduce { acc, c -> acc + c }
            .toInt(2)

    fun getEpsilon(commands: List<String>) =
        getBitFrequency(commands, FrequencyStrategy.LEAST_COMMON)
        .reduce { acc, c -> acc + c }
        .toInt(2)

    fun countChar(zeros: List<Int>, s: String, toCount: Char): List<Int> {
        return zeros.zip(s.toCharArray().asIterable()) { freq, char ->
            freq + if (char == toCount) 1 else 0
        }
    }

    fun solvePart2(): Int {
        val ogr = getOxygenGeneratorRating(commands)
        val csr = getCO2ScrubberRating(commands)
        return ogr*csr
    }

    fun getOxygenGeneratorRating(input: List<String>): Int {
        var remainingCommands = input
        var p = 0
        while (remainingCommands.size > 1) {
            remainingCommands = filterByBitCriteria(p, remainingCommands, FrequencyStrategy.MOST_COMMON)
            p++
        }
        return remainingCommands[0].toInt(2)
    }

    fun getCO2ScrubberRating(input: List<String>): Int {
        var remainingCommands = input
        var p = 0
        while (remainingCommands.size > 1) {
            remainingCommands = filterByBitCriteria(p, remainingCommands, FrequencyStrategy.LEAST_COMMON)
            p++
        }
        return remainingCommands[0].toInt(2)
    }

    fun filterByBitCriteria(p: Int, remainingCommands: List<String>, strategy: FrequencyStrategy): List<String> {
        val freq = getBitFrequency(remainingCommands, strategy)
        return remainingCommands.filter {
            it[p].toString() == freq[p]
        }
    }

    fun getBitFrequency(input: List<String>, strategy: FrequencyStrategy): List<String> {
        var zerosFreq = List(input[0].length) { 0 }
        var onesFreq = List(input[0].length) { 0 }

        input.forEach {
            zerosFreq = countChar(zerosFreq, it, '0')
            onesFreq = countChar(onesFreq, it, '1')
        }

        return zerosFreq.zip(onesFreq) { zero, one ->
            if(strategy == FrequencyStrategy.MOST_COMMON) {
                if (zero > one) "0" else "1"
            } else {
                if (zero <= one) "0" else "1"
            }
        }
    }

}
