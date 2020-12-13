package util

import kotlin.math.absoluteValue

data class Point2D(val x: Int, val y: Int) {
    operator fun plus(other: Point2D): Point2D =
        Point2D(x + other.x, y + other.y)

    operator fun times(by: Int): Point2D =
        Point2D(x * by, y * by)

    infix fun distanceTo(other: Point2D): Int =
        (x - other.x).absoluteValue + (y - other.y).absoluteValue

    fun rotateLeft(): Point2D =
        Point2D(x = y * -1, y = x)

    fun rotateRight(): Point2D =
        Point2D(x = y, y = x * -1)

    companion object {
        val ORIGIN = Point2D(0, 0)
    }
}
