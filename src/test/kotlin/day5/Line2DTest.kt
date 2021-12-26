package day5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Line2DTest {

    @Test
    fun `isOnSegment returns false if point not on segment`() {
        val line = Line2D(Point2D(0, 9), Point2D(5, 9))

        val result = line.isOnSegment(Point2D(0, 0))

        assertFalse(result)
    }

    @Test
    fun `isOnSegment returns false if point not on segment but on extended line`() {
        val line = Line2D(Point2D(0, 9), Point2D(5, 9))

        val result = line.isOnSegment(Point2D(6, 9))

        assertFalse(result)
    }

    @Test
    fun `isOnSegment returns true if point is the right extremity of the segment`() {
        val line = Line2D(Point2D(0, 9), Point2D(5, 9))

        val result = line.isOnSegment(Point2D(0, 9))

        assertTrue(result)
    }

    @Test
    fun `isOnSegment returns true if point is the left extremity of the segment`() {
        val line = Line2D(Point2D(0, 9), Point2D(5, 9))

        val result = line.isOnSegment(Point2D(5, 9))

        assertTrue(result)
    }

    @Test
    fun `isOnSegment returns true if point is on the segment`() {
        val line = Line2D(Point2D(0, 9), Point2D(5, 9))

        val result = line.isOnSegment(Point2D(4, 9))

        assertTrue(result)
    }
}
