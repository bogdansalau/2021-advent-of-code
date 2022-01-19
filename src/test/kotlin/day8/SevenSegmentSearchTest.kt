package day8

import io.readFileAsStringArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SevenSegmentSearchTest {

    @Test
    fun `example input part1`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day8\\example.txt")
        val sevenSegmentSearch = SevenSegmentSearch(exampleInput)

        val result = sevenSegmentSearch.solvePart1()

        assertEquals(26, result)
    }

    @Test
    fun `official input part1`() {
        val officialInput = readFileAsStringArray("src\\test\\resources\\day8\\input.txt")
        val sevenSegmentSearch = SevenSegmentSearch(officialInput)

        val result = sevenSegmentSearch.solvePart1()

        assertEquals(288, result)
    }

    //    ----- Part 2

    @Test
    fun `example input part2`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day8\\example.txt")
        val sevenSegmentSearch = SevenSegmentSearch(exampleInput)

        val result = sevenSegmentSearch.solvePart2()

        assertEquals(168, result)
    }

    @Test
    fun `official input part2`() {
        val officialInput = readFileAsStringArray("src\\test\\resources\\day8\\input.txt")
        val sevenSegmentSearch = SevenSegmentSearch(officialInput)

        val result = sevenSegmentSearch.solvePart2()

        assertEquals(92676646, result)
    }
}
