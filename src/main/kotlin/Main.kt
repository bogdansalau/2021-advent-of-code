import day16.TicketTranslation
import day17.ConwayCubes
import day18.OperationOrder
import io.readFileDirectlyAsText
import io.readStringArray
import util.println

fun main() {
    val inputStr = readStringArray("day18\\input.txt")
    val day = OperationOrder(listOf("2*3+4"))
    day.solvePart2().println()
}
