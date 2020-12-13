package day13

class ShuttleSearch(val input: List<String>) {

    val startTime = input[0].trim().toInt()

    fun solvePart1(): Int {
        val busses = input[1].trim().split(",").filterNot { it == "x" }.map { it.toInt() }
        var busId = -1
        var time = startTime
        while (busId < 0) {
            for (i in busses) {
                if(time.rem(i) == 0) {
                    busId = i
                }
            }
            time ++
        }
        return busId * (time - startTime - 1)
    }

    fun solvePart2(): Long {
        val indexedBusses = input[1].trim().split(",").mapIndexedNotNull { index, s -> if (s == "x") null else IndexedBus(index, s.toLong()) }
        var stepSize = indexedBusses.first().bus
        var time = 0L
        indexedBusses.drop(1).forEach { (offset, bus) ->
            while ((time + offset) % bus != 0L) {
                time += stepSize
            }
            stepSize *= bus
        }
        return time
    }

    data class IndexedBus(val index: Int, val bus: Long)

}
