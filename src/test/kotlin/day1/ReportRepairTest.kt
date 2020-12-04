package day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReportRepairTest {
    @Test
    fun `findPair returns pair of -1 if pair not found`() {
        val pair = findPair(2020, listOf(1, 2, 3, 4))

        assertEquals(Pair(-1, -1), pair)
    }

    @Test
    fun `findPair returns pair`() {
        val pair = findPair(10, listOf(1, 2, 3, 4, 5, 6))

        assertEquals(Pair(4, 6), pair)
    }

    @Test
    fun `findTriple returns triple of -1 if triple not found`() {
        val triple = findTriple(2020, listOf(1, 2, 3, 4))

        assertEquals(Triple(-1, -1, -1), triple)
    }

    @Test
    fun `findTriple returns triple`() {
        val triple = findTriple(10, listOf(1, 2, 3, 4, 5, 6))

        assertEquals(Triple(1, 3, 6), triple)
    }
}
