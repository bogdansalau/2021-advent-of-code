package day15

class RambunctiousRecitation() {

    private val input = mutableListOf(1,20,8,12,0,14)
    private val n1 = 2020 // 2020-th nr for part 1
    private val n2 = 30000000 // 30 000 000-th nr for part 1



    fun solvePart1(): Int {
        while (input.size < n1) {
            val last = input.last()
            val prevIndex = input.dropLast(1).lastIndexOf(last)
            if (prevIndex == -1) input.add(0) else input.add(input.size - prevIndex - 1)
        }
        return input[n1-1]
    }


    fun solvePart2(): Int {
        val mem = input.mapIndexed { i, e -> e to (i+1) }.toMap().toMutableMap()
        var curr = 0
        var index = input.size + 1
        while (index < n2) {
            val lastIndex = mem[curr]
            if (lastIndex == null) {
                mem[curr] = index
                curr = 0
                index ++
            } else {
                mem[curr] = index
                curr = index - lastIndex
                index ++
            }
//            println(curr)
        }

        return curr
    }


    private data class Pojo(val a: String, val b: Int)

    companion object {
        // static vars
    }
}
