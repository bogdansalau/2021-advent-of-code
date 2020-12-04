package day1

/**
 * find pair in
 * @param array that sums up to
 * @param sum
 *
 * all elements of the array a are positive, no duplicates
 *
 * there can be only one pair
 */
fun findPair(sum: Int, array: List<Int>): Pair<Int, Int> {
    array.forEach { if (array.contains(sum - it)) return Pair(it, sum - it) }
    return Pair(-1, -1)
}

/**
 * find triple in
 * @param array that sums up to
 * @param sum
 *
 * all elements of the array a are positive, no duplicates
 *
 * there can be only one triple
 */
fun findTriple(sum: Int, array: List<Int>): Triple<Int, Int, Int> {
    for (a in array) {
        for (b in array) {
            for(c in array) {
                if (a + b + c == sum) return Triple(a, b, c)
            }
        }
    }
    return Triple(-1, -1, -1)
}
