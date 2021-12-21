package day2

class Dive(input: List<String>) {


    private val commands = input.map { Pair(it.split(' ')[0], it.split(' ')[1].toInt()) }

    fun solvePart1(): Int {
        var h = 0
        var d = 0

        commands.forEach{
            when(it.first){
                "forward" -> h += it.second
                "down" -> d += it.second
                "up" -> d -= it.second
            }
        }

        return h*d
    }

    fun solvePart2(): Int {
        var h = 0
        var d = 0
        var aim = 0

        commands.forEach{
            when(it.first){
                "forward" -> {
                    d += aim*it.second
                    h += it.second
                }
                "down" -> aim += it.second
                "up" -> aim -= it.second
            }
        }

        return h*d
    }

}
