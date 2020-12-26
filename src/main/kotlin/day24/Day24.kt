package day24
/*
 * Copyright (c) 2020 by Todd Ginsberg
 */

/**
 * Advent of Code 2020, Day 24 - Lobby Layout
 * Problem Description: http://adventofcode.com/2020/day/24
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2020/day24/
 */

class Day24(private val input: List<String>) {

    fun solvePart1(): Int =
        decorateFloor().size

    fun solvePart2(): Int =
        generateSequence(decorateFloor()) { it.nextFloor() }
            .drop(100)
            .first()
            .size

    private fun Set<Point3D>.nextFloor(): Set<Point3D> {
        val pointsToEvaluate = this + (this.flatMap { point -> point.hexNeighbors })
        return pointsToEvaluate.filter { tile ->
            val adjacentBlackTiles = tile.hexNeighbors.count { it in this }
            val black = tile in this
            when {
                black && (adjacentBlackTiles == 0 || adjacentBlackTiles > 2) -> false
                !black && adjacentBlackTiles == 2 -> true
                else -> black
            }
        }.toSet()
    }

    private fun decorateFloor(): Set<Point3D> =
        input
            .map { it.walkPath() }
            .groupBy { it }
            .filter { it.value.size % 2 == 1  }
            .keys

    private fun String.walkPath(): Point3D =
        splitPattern
            .findAll(this)
            .map { it.value }
            .fold(Point3D.ORIGIN) { last, dir ->
                last.hexNeighbor(dir)
            }

    companion object {
        private val splitPattern = "([ns]?[ew])".toRegex()
    }

}

interface Point {
    val neighbors: List<Point>
}

data class Point3D(val x: Int, val y: Int, val z: Int) : Point {
    override val neighbors: List<Point3D> by lazy {
        (x - 1..x + 1).flatMap { dx ->
            (y - 1..y + 1).flatMap { dy ->
                (z - 1..z + 1).mapNotNull { dz ->
                    Point3D(dx, dy, dz).takeUnless { it == this }
                }
            }
        }
    }

    val hexNeighbors: List<Point3D> by lazy {
        HEX_OFFSETS.map { this + it.value }
    }

    operator fun plus(other: Point3D): Point3D =
        Point3D(x + other.x, y + other.y, z + other.z)

    fun hexNeighbor(dir: String): Point3D =
        if (dir in HEX_OFFSETS) HEX_OFFSETS.getValue(dir) + this
        else throw IllegalArgumentException("No dir: $dir")

    companion object {
        val ORIGIN = Point3D(0, 0, 0)
        val HEX_OFFSETS = mapOf(
            "e" to Point3D(1, -1, 0),
            "w" to Point3D(-1, 1, 0),
            "ne" to Point3D(1, 0, -1),
            "nw" to Point3D(0, 1, -1),
            "se" to Point3D(0, -1, 1),
            "sw" to Point3D(-1, 0, 1),
        )
    }
}

