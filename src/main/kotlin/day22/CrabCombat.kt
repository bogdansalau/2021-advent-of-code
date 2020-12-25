package day22

import java.util.*
import javax.naming.directory.NoSuchAttributeException

typealias Deck = MutableList<Int>

class CrabCombat(val input: List<String>) {

    private val deck1: Deck = input.drop(1).takeWhile { it.isNotBlank() }.map { it.toInt() }.toMutableList()
    private val deck2: Deck = input.dropWhile { it.isNotBlank() }.drop(2).map { it.toInt() }.toMutableList()

    fun solvePart1(): Int = playGame(deck1, deck2)

    fun solvePart2(): Int = 2

    private fun playGame(deck1: Deck, deck2: Deck): Int {
        var p1 = deck1
        var p2 = deck2
        while (p1.size != 0 && p2.size != 0) {
            val c1 = p1[0]
            val c2 = p2[0]

            p1 = p1.drop(1).toMutableList()
            p2 = p2.drop(1).toMutableList()

            if (c1 > c2) {
                p1.add(c1)
                p1.add(c2)
            } else {
                p2.add(c2)
                p2.add(c1)
            }
        }

        val score = when {
            p1.size == 0 -> p2.score()
            p2.size == 0 -> p1.score()
            else -> throw NoSuchAttributeException()
        }
        return score
    }

    // static vars
    private fun Deck.score(): Int {
        return this.foldIndexed(0) { i, acc, curr -> acc + (curr * (size - i)) }
    }

    companion object {
    }

}
