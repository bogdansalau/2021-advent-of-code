import day1.SonarSweep
import io.readFileAsStringArray
import util.println

fun main() {
    val inputStr = readFileAsStringArray("day1\\input.txt")
    val day = SonarSweep(inputStr)
    day.solvePart2().println()


}
