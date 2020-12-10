import day7.HandyHaversacks
import io.readStringArray

fun main() {
    val inputStr = readStringArray("day7\\input.txt")
    val day7 = HandyHaversacks(inputStr)
    day7.solvePart2().print()
}

fun Int.print() {
    print(this)
}
