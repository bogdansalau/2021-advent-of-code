import day20.JurassicJigsaw
import io.readFileAsString
import util.println

fun main() {
    val inputStr = readFileAsString("day20\\input.txt")
    val day = JurassicJigsaw(inputStr)
    day.solvePart2().println()

}
