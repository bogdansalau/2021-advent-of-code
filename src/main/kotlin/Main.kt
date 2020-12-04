import day2.countValidPasswords
import io.readFileDirectlyAsText

fun main() {
    val inputStr = readFileDirectlyAsText("day2\\input.txt")
    println(countValidPasswords(inputStr))
}
