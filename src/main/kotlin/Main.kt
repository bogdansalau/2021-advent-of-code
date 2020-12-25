import day21.AllergenAssessment
import io.readFileAsStringArray
import util.println

fun main() {
    val inputStr = readFileAsStringArray("day21\\input.txt")
    val day = AllergenAssessment(inputStr)
    day.solvePart2().println()

}
