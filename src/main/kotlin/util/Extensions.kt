package util

fun Int.println() {
    println(this)
}

fun Long.println() {
    println(this)
}

fun String.println() {
    println(this)
}

fun Long.pow(power: Long): Long {
    if (power == 0L) return 1
    if (power == 1L) return this
    var acc = 1L
    for(i in 0 until power) {
        acc *= this
    }
    return acc
}
