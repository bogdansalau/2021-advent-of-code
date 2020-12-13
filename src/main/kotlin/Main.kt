import day12.RainRisk
import day13.ShuttleSearch
import io.readStringArray
import util.println

fun main() {
    val inputStr = readStringArray("day12\\input.txt")
    val day13 = RainRisk(inputStr)
    day13.solvePart2().println()

}
