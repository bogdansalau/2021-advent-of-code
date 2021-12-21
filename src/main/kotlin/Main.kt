import day2.Dive
import io.readFileAsStringArray
import util.println

fun main() {
    val inputStr = readFileAsStringArray("day2\\input.txt")
    val day = Dive(inputStr)
    day.solvePart2().println()


}
