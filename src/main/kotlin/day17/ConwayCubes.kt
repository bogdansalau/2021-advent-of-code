package day17

class ConwayCubes(val input: List<String>) {

    fun solvePart1(): Int = solve { x, y -> Point3D(x, y, 0) }

    fun solvePart2(): Int = solve { x, y -> Point4D(x, y, 0, 0) }

    private fun solve(rounds: Int = 6, pointFunction: (Int, Int) -> Point): Int {
        var conwayGrid = parseInput(input, pointFunction)
        repeat(rounds) {
            conwayGrid = conwayGrid.tick()
        }
        return conwayGrid.count { it.value }
    }

    private fun parseInput(input: List<String>, pointFunction: (Int, Int) -> Point): Map<Point, Boolean> {
        return input
            .flatMapIndexed { i, row ->
                row
                    .mapIndexed { j, point ->
                        pointFunction(i, j) to (point == '#')
                    }
            }.toMap()
    }

    private fun Map<Point, Boolean>.tick(): Map<Point, Boolean> {
        val newMap = this.toMutableMap()
        keys.forEach { p ->
            p.neighbours.forEach { neighbor ->
                newMap.putIfAbsent(neighbor, false)
            }
        }
        newMap.entries.forEach { (point, active) ->
            val activeNeighbours = point.neighbours.count { this.getOrDefault(it, false) }
            newMap[point] = when {
                active && activeNeighbours in setOf(2, 3) -> true
                !active && activeNeighbours == 3 -> true
                else -> false
            }
        }
        return newMap
    }

    interface Point {
        val neighbours: List<Point>
    }

    private data class Point3D(val x: Int, val y: Int, val z: Int) : Point {
        override val neighbours: List<Point> by lazy {
            (x - 1..x + 1).flatMap { dx ->
                (y - 1..y + 1).flatMap { dy ->
                    (z - 1..z + 1).mapNotNull { dz ->
                        Point3D(dx, dy, dz).takeUnless { it == this }
                    }
                }
            }
        }
    }

    private data class Point4D(val x: Int, val y: Int, val z: Int, val w: Int) : Point {
        override val neighbours: List<Point> by lazy {
            (x - 1..x + 1).flatMap { dx ->
                (y - 1..y + 1).flatMap { dy ->
                    (z - 1..z + 1).flatMap { dz ->
                        (w - 1..w + 1).mapNotNull { dw ->
                            Point4D(dx, dy, dz, dw).takeUnless { it == this }
                        }
                    }
                }
            }
        }
    }

    companion object {
        // static vars
    }
}
