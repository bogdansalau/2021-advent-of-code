package day7

import day4.GiantSquid
import io.readFileAsString
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TreacheryOfWhalesTest {

    @Test
    fun `example input part1`() {
            val exampleInput = readFileAsString("src\\test\\resources\\day7\\example.txt")
        val treacheryOfWhales = TreacheryOfWhales(exampleInput)

        val result = treacheryOfWhales.solvePart1()

        assertEquals(37, result)
    }

    @Test
    fun `official input part1`() {
        val officialInput = readFileAsString("src\\test\\resources\\day7\\input.txt")
        val treacheryOfWhales = TreacheryOfWhales(officialInput)

        val result = treacheryOfWhales.solvePart1()

        assertEquals(336131, result)
    }

    //    ----- Part 2

    @Test
    fun `example input part2`() {
        val exampleInput = readFileAsString("src\\test\\resources\\day7\\example.txt")
        val treacheryOfWhales = TreacheryOfWhales(exampleInput)

        val result = treacheryOfWhales.solvePart2()

        assertEquals(168, result)
    }

    @Test
    fun `official input part2`() {
        val officialInput = readFileAsString("src\\test\\resources\\day7\\input.txt")
        val treacheryOfWhales = TreacheryOfWhales(officialInput)

        val result = treacheryOfWhales.solvePart2()

        assertEquals(92676646, result)
    }

}
