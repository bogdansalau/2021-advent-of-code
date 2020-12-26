package day25

import util.println

class ComboBreaker(input: List<String>) {

    private val cardPk = input.first().trim().toLong()
    private val doorPk = input.last().trim().toLong()

    fun solvePart1(): Long {
        val cardLoop = cardPk.findLoop()
        val doorLoop = doorPk.findLoop()

        val privateKey0 = cardLoop.toLong().transform(doorPk)
        val privateKey1 = doorLoop.toLong().transform(cardPk)
        return privateKey0
    }

    fun solvePart2(): Int = 2

    private fun Long.findLoop(subject: Long = 7): Int {
        var i = 0
        var r = 1L
        while (this != r) {
            r *= subject
            r %= 20201227
            i++
        }
        return i
    }

    fun Long.transform(subject: Long = 7): Long {
        var r = 1L
        for (i in 1..this) {
            r *= subject
            r %= 20201227
        }
        return r
    }

    private data class Pojo(val a: String, val b: Int)

    companion object {
        // static vars
    }
}
