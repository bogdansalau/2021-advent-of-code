package day3

import day2.Dive
import io.readFileAsStringArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import util.println

internal class BinaryDiagnosticTest{
    @Test
    fun `first test`() {
        assertEquals(1, 1)
    }

    @Test
    fun `file text`() {
        val inputStr = readFileAsStringArray("day2\\input.txt")
        val day = Dive(inputStr)
        day.solvePart2().println()
    }
}
