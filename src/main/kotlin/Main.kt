import day3.countTrees
import day4.countValidPassports
import io.readFileDirectlyAsText
import io.readStringArray

fun main() {
    val inputStr = readFileDirectlyAsText("day4\\input.txt")
    println(countValidPassports(inputStr))

    // 63, 181, 55, 67, 30
}
