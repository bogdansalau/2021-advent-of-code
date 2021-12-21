package day3

import io.readFileAsStringArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BinaryDiagnosticTest {
    private val input = listOf("000111")

    private val binaryDiagnostic = BinaryDiagnostic(input)

    @Test
    fun `countChars increments zeros number in frequency vector`() {
        val zeros = List(6) { 0 }

        val result = binaryDiagnostic.countChar(zeros, "000111", '0')

        assertEquals(listOf(1, 1, 1, 0, 0, 0), result)
    }

    @Test
    fun `countChars increments ones number in frequency vector`() {
        val zeros = List(6) { 0 }

        val result = binaryDiagnostic.countChar(zeros, "000111", '1')

        assertEquals(listOf(0, 0, 0, 1, 1, 1), result)
    }

    @Test
    fun `getGamma returns decimal formed with most common bit in input`() {
        val commands = listOf("011", "100", "011")

        val result = binaryDiagnostic.getGamma(commands)

        assertEquals(3, result)
    }

    @Test
    fun `getEpsilon returns decimal formed with least common bit in input`() {
        val commands = listOf("011", "100", "011")

        val result = binaryDiagnostic.getEpsilon(commands)

        assertEquals(4, result)
    }

    @Test
    fun `example input part1`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day3\\example.txt")
        val binaryDiagnostic = BinaryDiagnostic(exampleInput)

        val result = binaryDiagnostic.solvePart1()

        assertEquals(198, result)
    }

    @Test
    fun `official input part1`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day3\\input.txt")
        val binaryDiagnostic = BinaryDiagnostic(exampleInput)

        val result = binaryDiagnostic.solvePart1()

        assertEquals(2003336, result)
    }

//    ----- Part 2

    @Test
    fun `getBitFrequency gets most frequent bit`() {
        val input = listOf("01", "00")

        val result = binaryDiagnostic.getBitFrequency(input, FrequencyStrategy.MOST_COMMON)

        assertEquals(listOf("0", "1"), result)
    }

    @Test
    fun `getBitFrequency gets least frequent bit`() {
        val input = listOf("01", "00")

        val result = binaryDiagnostic.getBitFrequency(input, FrequencyStrategy.LEAST_COMMON)

        assertEquals(listOf("1", "0"), result)
    }

    @Test
    fun `filterByBitCriteria filters out commands that don't match most common bit`() {
        val input = listOf("01", "10")

        val result = binaryDiagnostic.filterByBitCriteria(0, input, FrequencyStrategy.MOST_COMMON)

        assertEquals(listOf("10"), result)
    }

    @Test
    fun `filterByBitCriteria filters out commands that don't match least common bit`() {
        val input = listOf("01", "10", "00")

        val result = binaryDiagnostic.filterByBitCriteria(0, input, FrequencyStrategy.LEAST_COMMON)

        assertEquals(listOf("10"), result)
    }

    @Test
    fun `getOxygenGeneratorRating gets Oxygen Generator Rating`() {
        val input = listOf("011", "101", "001")

        val result = binaryDiagnostic.getOxygenGeneratorRating(input)

        assertEquals(3, result)
    }

    @Test
    fun `getCO2ScrubberRating gets CO2 Scrubber Rating`() {
        val input = listOf("011", "101", "001")

        val result = binaryDiagnostic.getCO2ScrubberRating(input)

        assertEquals(5, result)
    }

    @Test
    fun `example input part2`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day3\\example.txt")
        val binaryDiagnostic = BinaryDiagnostic(exampleInput)

        val result = binaryDiagnostic.solvePart2()

        assertEquals(230, result)
    }

    @Test
    fun `official input part2`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day3\\input.txt")
        val binaryDiagnostic = BinaryDiagnostic(exampleInput)

        val result = binaryDiagnostic.solvePart2()

        assertEquals(1877139, result)
    }

}
