package day5

import day4.GiantSquid
import io.readFileAsString
import io.readFileAsStringArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HydrothermalVentureTest{
    @Test
    fun `example input part1`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day5\\example.txt")
        val hydrothermalVenture = HydrothermalVenture(exampleInput)

        val result = hydrothermalVenture.solvePart1()

        assertEquals(5, result)
    }

    @Test
    fun `official input part1`() {
        val officialInput = readFileAsStringArray("src\\test\\resources\\day5\\input.txt")
        val hydrothermalVenture = HydrothermalVenture(officialInput)

        val result = hydrothermalVenture.solvePart1()

        assertEquals(6225, result)
    }

    //    ----- Part 2

    @Test
    fun `example input part2`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day5\\example.txt")
        val hydrothermalVenture = HydrothermalVenture(exampleInput)

        val result = hydrothermalVenture.solvePart2()

        assertEquals(12, result)
    }

    @Test
    fun `official input part2`() {
        val officialInput = readFileAsStringArray("src\\test\\resources\\day5\\input.txt")
        val hydrothermalVenture = HydrothermalVenture(officialInput)

        val result = hydrothermalVenture.solvePart2()

        assertEquals(22116, result)
    }
}
