import day16.TicketTranslation
import io.readFileDirectlyAsText
import util.println

fun main() {
    val inputStr = readFileDirectlyAsText("day16\\input.txt")
    val day14 = TicketTranslation(inputStr)
    day14.solvePart2().println()
}
