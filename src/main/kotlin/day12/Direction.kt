package day12

import util.Point2D

sealed class Direction {
    abstract val turnLeft: Direction
    abstract val turnRight: Direction
    abstract val offset: Point2D

    operator fun invoke(dir: String): Direction =
        when (dir) {
            "N" -> North
            "S" -> South
            "E" -> East
            "W" -> West
            else -> throw IllegalArgumentException("No such direction $dir")
        }

    object North : Direction() {
        override val turnLeft = West
        override val turnRight = East
        override val offset = Point2D(-1, 0)
    }

    object South : Direction() {
        override val turnLeft = East
        override val turnRight = West
        override val offset = Point2D(1, 0)
    }

    object West : Direction() {
        override val turnLeft = South
        override val turnRight = North
        override val offset = Point2D(0, -1)
    }

    object East : Direction() {
        override val turnLeft = North
        override val turnRight = South
        override val offset = Point2D(0, 1)
    }
}
