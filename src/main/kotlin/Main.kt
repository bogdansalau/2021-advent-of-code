import day2.countValidPasswords
import day3.countTrees
import io.readFileDirectlyAsText
import io.readStringArray

fun main() {
    val inputStr = readStringArray("day3\\input.txt")
    println(countTrees(1, 2, inputStr))

    // 63, 181, 55, 67, 30
}
