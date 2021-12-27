package day6

import io.readFileAsStringArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigInteger

internal class LanternfishTest {
    @Test
    fun `example1 input part1`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day6\\example.txt")
        val lanternfish = Lanternfish(exampleInput, 80)

        val result = lanternfish.solvePart1(18)

        assertEquals(26, result)
    }

    @Test
    fun `example2 input part1`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day6\\example.txt")
        val lanternfish = Lanternfish(exampleInput, 80)

        val result = lanternfish.solvePart1(80)

        assertEquals(5934, result)
    }

    @Test
    fun `official input part1`() {
        val officialInput = readFileAsStringArray("src\\test\\resources\\day6\\input.txt")
        val lanternfish = Lanternfish(officialInput, 80)

        val result = lanternfish.solvePart1(80)

        assertEquals(380243, result)
    }

    //    ----- Part 2

    @Test
    fun `example input part2`() {
        val exampleInput = readFileAsStringArray("src\\test\\resources\\day6\\example.txt")
        val lanternfish = Lanternfish(exampleInput, 256)

        val result = lanternfish.solvePart2()

        assertEquals(BigInteger("26984457539"), result)
    }

    @Test
    fun `official input part2`() {
        val officialInput = readFileAsStringArray("src\\test\\resources\\day6\\input.txt")
        val lanternfish = Lanternfish(officialInput, 256)

        val result = lanternfish.solvePart2()

        assertEquals(BigInteger("1708791884591"), result)
    }
}
