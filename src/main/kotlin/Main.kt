import day1.findTriple
import io.readArray

fun main() {
    val inputArray = readArray("day1\\input.txt")
    val triple = findTriple(2020, inputArray)
    println(triple.first*triple.second*triple.third)
}
