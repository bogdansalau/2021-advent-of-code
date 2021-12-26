package day5

import java.lang.Math.abs

data class Line2D(val a: Point2D, val b: Point2D) {
    fun contains(i: Int, j: Int): Boolean {
        return isOnSegment(Point2D(i, j))
    }

    fun isOnSegment(c: Point2D): Boolean {
        val crossproduct = (c.y - a.y) * (b.x - a.x) - (c.x - a.x) * (b.y - a.y)

        // compare versus epsilon for floating point values, or != 0 if using integers
        if (abs(crossproduct) > 0) return false

        val dotproduct = (c.x - a.x) * (b.x - a.x) + (c.y - a.y) * (b.y - a.y)
        if (dotproduct < 0) return false

        val squaredlengthba = (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y)
        if (dotproduct > squaredlengthba) return false

        return true
    }

    fun isVertical(): Boolean = a.x == b.x

    fun isHorizontal(): Boolean = a.y == b.y
}
