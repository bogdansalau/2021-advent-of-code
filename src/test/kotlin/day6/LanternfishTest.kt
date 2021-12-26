package day6

import io.readFileAsStringArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LanternfishTest {
    @Test
    fun `example input part1`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day6\\example.txt")
        val lanternfish = Lanternfish(exampleInput)

        val result = lanternfish.solvePart1()

        assertEquals(5, result)
    }

    @Test
    fun `official input part1`() {
        val officialInput = readFileAsStringArray("src\\test\\resources\\day6\\input.txt")
        val lanternfish = Lanternfish(officialInput)

        val result = lanternfish.solvePart1()

        assertEquals(6225, result)
    }

    //    ----- Part 2

    @Test
    fun `example input part2`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day6\\example.txt")
        val lanternfish = Lanternfish(exampleInput)

        val result = lanternfish.solvePart2()

        assertEquals(12, result)
    }

    @Test
    fun `official input part2`() {
        val officialInput = readFileAsStringArray("src\\test\\resources\\day6\\input.txt")
        val lanternfish = Lanternfish(officialInput)

        val result = lanternfish.solvePart2()

        assertEquals(22116, result)
    }
}
