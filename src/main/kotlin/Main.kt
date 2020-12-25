import day21.AllergenAssessment
import day22.CrabCombat
import day22.Day22
import io.readFileAsStringArray
import util.println

fun main() {
    val inputStr = readFileAsStringArray("day22\\input.txt")
    val day = Day22(inputStr)
    day.solvePart2().println()
}
