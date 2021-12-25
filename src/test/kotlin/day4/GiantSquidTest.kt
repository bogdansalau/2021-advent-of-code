package day4

import day3.BinaryDiagnostic
import io.readFileAsString
import io.readFileAsStringArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class GiantSquidTest {

    @Test
    fun `toBoard parses String into board`() {
        val boardAsStr = """22 13
              8  2"""

        val result = boardAsStr.toBoard()

        val expectedBoard = Board(
            listOf(
                mutableListOf(22 to false, 13 to false),
                mutableListOf(8 to false, 2 to false),
            )
        )

        assertEquals(expectedBoard.getByPos(0, 0), result.getByPos(0, 0))
        assertEquals(expectedBoard.getByPos(0, 1), result.getByPos(0, 1))
        assertEquals(expectedBoard.getByPos(1, 0), result.getByPos(1, 0))
        assertEquals(expectedBoard.getByPos(1, 1), result.getByPos(1, 1))
    }

    @Test
    fun `mark marks number on board`() {
        val boardAsStr = """22 13
              8  2"""
        val result = boardAsStr.toBoard()

        result.mark(22)

        val expectedBoard = Board(
            listOf(
                mutableListOf(22 to true, 13 to false),
                mutableListOf(8 to false, 2 to false),
            )
        )

        assertEquals(expectedBoard.getByPos(0, 0), result.getByPos(0, 0))
        assertEquals(expectedBoard.getByPos(0, 1), result.getByPos(0, 1))
        assertEquals(expectedBoard.getByPos(1, 0), result.getByPos(1, 0))
        assertEquals(expectedBoard.getByPos(1, 1), result.getByPos(1, 1))
    }

    @Test
    fun `hasWon computes row condition correctly`() {
        val boardAsStr = """22 13 17 11  0
                             8  2 23  4 24
                            21  9 14 16  7
                             6 10  3 18  5
                             1 12 20 15 19"""
        val board = boardAsStr.toBoard()
        board.mark(22)
        board.mark(13)
        board.mark(17)
        board.mark(11)
        board.mark(0)

        val result = board.hasWon()

        assertTrue(result)
    }

    @Test
    fun `hasWon computes col condition correctly`() {
        val boardAsStr = """22 13 17 11  0
                             8  2 23  4 24
                            21  9 14 16  7
                             6 10  3 18  5
                             1 12 20 15 19"""
        val board = boardAsStr.toBoard()
        board.mark(22)
        board.mark(8)
        board.mark(21)
        board.mark(6)
        board.mark(1)

        val result = board.hasWon()

        assertTrue(result)
    }

    @Test
    fun `hasWon computes returns false if condition not met`() {
        val boardAsStr = """22 13 17 11  0
                             8  2 23  4 24
                            21  9 14 16  7
                             6 10  3 18  5
                             1 12 20 15 19"""
        val board = boardAsStr.toBoard()
        board.mark(22)
        board.mark(8)
        board.mark(21)
        board.mark(6)

        val result = board.hasWon()

        assertFalse(result)
    }

    @Test
    fun `getScore computes board score`() {
        val boardAsStr = """22 13
                             8  2 """
        val board = boardAsStr.toBoard()
        board.mark(22)
        board.mark(13)

        val result = board.getScore()

        assertEquals(130, result)
    }

    @Test
    fun `example input part1`() {
        val exampleInput = readFileAsString("src\\test\\resources\\day4\\example.txt")
        val giantSquid = GiantSquid(exampleInput)

        val result = giantSquid.solvePart1()

        assertEquals(4512, result)
    }

    @Test
    fun `official input part2`() {
        val officialInput = readFileAsString("src\\test\\resources\\day4\\input.txt")
        val giantSquid = GiantSquid(officialInput)

        val result = giantSquid.solvePart1()

        assertEquals(22680, result)
    }

    //    ----- Part 2

}
