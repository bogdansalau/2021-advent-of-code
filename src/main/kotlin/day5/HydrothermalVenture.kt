package day5

class HydrothermalVenture(input: List<String>) {
    private val linesAsPointPair = input.map {
        val firstPairList = it.substringBefore("->").trim().split(",").map { nr -> nr.toInt() }
        val firstPoint = Point2D(firstPairList[0], firstPairList[1])

        val secondPairList = it.substringAfter("->").trim().split(",").map { nr -> nr.toInt() }
        val secondPoint = Point2D(secondPairList[0], secondPairList[1])

        Line2D(firstPoint, secondPoint)
    }

    private val horizontalAndVerticalLines = linesAsPointPair.filter { line2D ->
        line2D.isHorizontal() || line2D.isVertical()
    }

    fun solvePart1(): Int {
        var total = 0

        for (i in 0..1000) {
            for (j in 0..1000) {
                val count = horizontalAndVerticalLines.map {
                    it.contains(i, j)
                }.filter { it }.count()

                if (count >= 2) total += 1
            }
        }
        return total
    }

    fun solvePart2(): Int {
        var total = 0

        for (i in 0..1000) {
            for (j in 0..1000) {
                val count = linesAsPointPair.map {
                    it.contains(i, j)
                }.filter { it }.count()

                if (count >= 2) total += 1
            }
        }
        return total
    }

}
