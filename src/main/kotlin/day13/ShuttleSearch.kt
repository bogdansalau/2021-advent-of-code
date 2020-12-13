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
        val busses = input[1].trim().split(",").map {
            if (it == "x") 1
            else it.toInt()
        }
        var time = 99999999999393L
        var foundT = false
        var offset = 68

        while (!foundT) {
            var allGood = true
            var actualTime = time - offset
            for (i in busses.indices) {
                if(busses[i] == 733) println(i)
                if((actualTime + i).rem(busses[i]) != 0L) {
                    allGood = false
                    break
                }
            }
            if (allGood) foundT = true
            time += 733
            println(time)
        }
        return time - 1
    }

}
