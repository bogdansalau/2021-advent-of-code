import day19.Day19
import day19.MonsterMessages
import io.readFileAsString
import io.readFileAsStringArray
import util.println

fun main() {
    val inputStr = readFileAsStringArray("day19\\input.txt")
    val day = MonsterMessages(inputStr)
    day.solvePart2().println()



}
