import day10.AdapterArray
import day8.HandheldHalting
import day9.EncodingError
import io.readArray
import io.readStringArray
import util.print
import util.println

fun main() {
    val inputStr = readArray("day10\\input.txt")
    val day10 = AdapterArray(inputStr)
    day10.solvePart2().print()
}
