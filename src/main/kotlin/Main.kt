import day21.AllergenAssessment
import day22.CrabCombat
import day22.Day22
import day23.Day23
import io.readFileAsString
import io.readFileAsStringArray
import util.println

fun main() {
    val inputStr = readFileAsString("day23\\input.txt")
    val day = Day23(inputStr.trim())
    day.solvePart2(10_000_000).println()
}
