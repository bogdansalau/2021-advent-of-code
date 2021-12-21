package day3

import io.readFileAsStringArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

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
        val zeros = listOf(1, 0, 0)
        val ones = listOf(0, 1, 1)

        val result = binaryDiagnostic.getGamma(zeros, ones)

        assertEquals(3, result)
    }

    @Test
    fun `getEpsilon returns decimal formed with least common bit in input`() {
        val zeros = listOf(1, 0, 0)
        val ones = listOf(0, 1, 1)

        val result = binaryDiagnostic.getEpsilon(zeros, ones)

        assertEquals(4, result)
    }

    @Test
    fun `example input`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day3\\example.txt")
        val binaryDiagnostic = BinaryDiagnostic(exampleInput)

        val result = binaryDiagnostic.solvePart1()

        assertEquals(198, result)
    }

    @Test
    fun `official input`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day3\\input.txt")
        val binaryDiagnostic = BinaryDiagnostic(exampleInput)

        val result = binaryDiagnostic.solvePart1()

        assertEquals(2003336, result)
    }
}
