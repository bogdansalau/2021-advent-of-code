import day6.countQuestions
import io.readFileDirectlyAsText

fun main() {
    val inputStr = readFileDirectlyAsText("day6\\input.txt")
    println(countQuestions(inputStr))

    // 63, 181, 55, 67, 30
}
