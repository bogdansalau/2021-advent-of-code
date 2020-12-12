import day8.HandheldHalting
import day9.EncodingError
import io.readArray
import io.readStringArray
import util.print
import util.println

fun main() {
    val inputStr = readArray("day9\\input.txt")
    val day9 = EncodingError(inputStr)
    day9.solvePart2().print()
}
