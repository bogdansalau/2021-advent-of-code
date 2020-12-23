import day16.TicketTranslation
import day17.ConwayCubes
import io.readFileDirectlyAsText
import io.readStringArray
import util.println

fun main() {
    val inputStr = readStringArray("day17\\input.txt")
    val day14 = ConwayCubes(inputStr)
    day14.solvePart2().println()
}
