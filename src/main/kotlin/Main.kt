import day21.AllergenAssessment
import day22.CrabCombat
import day22.Day22
import day23.Day23
import day24.Day24
import day25.ComboBreaker
import io.readFileAsString
import io.readFileAsStringArray
import util.println

fun main() {
    val inputStr = readFileAsStringArray("day25\\input.txt")
    val day = ComboBreaker(inputStr)
    day.solvePart1().println()


}
