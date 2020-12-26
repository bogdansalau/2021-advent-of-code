import day21.AllergenAssessment
import day22.CrabCombat
import day22.Day22
import day23.Day23
import day24.Day24
import io.readFileAsString
import io.readFileAsStringArray
import util.println

fun main() {
//    val inputStr = readFileAsStringArray("day24\\input.txt")
//    val day = Day24(inputStr)
//    day.solvePart2().println()


    val splitPattern = "([ns]?[ew])".toRegex()
    val seq = splitPattern.findAll("eenweesewseweene").map { it.value }
    println()
}
