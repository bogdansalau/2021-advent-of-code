import day13.ShuttleSearch
import io.readStringArray
import util.println

fun main() {
    val inputStr = readStringArray("day13\\input.txt")
    val day13 = ShuttleSearch(inputStr)
    day13.solvePart2().println()

}
