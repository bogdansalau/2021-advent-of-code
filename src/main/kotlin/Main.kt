import day8.HandheldHalting
import io.readStringArray
import util.print
import util.println

fun main() {
    val inputStr = readStringArray("day8\\input.txt")
    val day7 = HandheldHalting(inputStr)
    day7.solvePart2().print()
}
