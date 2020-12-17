package day16

class TicketTranslation(val input: String) {

    private val smallsplit = "\n"
    private val bigsplit = "\n\n"

    private val rules = input
        .split(bigsplit)[0]
        .split(smallsplit)
        .map {
            val name = it.substringBefore(":")

            val firstRangeAsStr = it.substringAfter(":").substringBefore("or").trim().split("-")
            val firstRange = firstRangeAsStr[0].toInt()..firstRangeAsStr[1].toInt()

            val secondRangeAsStr = it.split(" or ")[1].split("-")
            val secondRange = secondRangeAsStr[0].toInt()..secondRangeAsStr[1].toInt()

            Rule(name, firstRange, secondRange)
        }

    private val myTicket = input
        .split(bigsplit)[1]
        .split(smallsplit)[1]
        .split(",").map { it.toInt() }

    private val tickets = input
        .substringAfter("nearby tickets:$smallsplit")
        .trim()
        .split(smallsplit)
        .map { it.split(",").map { a -> a.toInt() } }

    fun solvePart1() = tickets.flatten().filterNot { obeysRules(it) }.sum()

    fun solvePart2(): Long {
        val validTickets = tickets.filter {
            isTicketValid(it)
        }
        var ruleMap = mutableMapOf<Int, MutableList<Rule>>()
        var goodRules = mutableListOf<Rule>()
        for (i in validTickets[0].indices) {
            var currentRule = rules.toMutableList().subtract(goodRules).toMutableList()
            for (j in validTickets.indices) {
                currentRule = currentRule.toMutableList().filter { it.covers(validTickets[j][i]) }.toMutableList()
            }
            ruleMap[i] = currentRule
        }

        val result = reduceRules(ruleMap)
        val columns = result.entries.filter { (_, ticket) -> ticket.name.startsWith("departure") }
            .map { (column, ticket) -> column }

        return columns.map { myTicket[it] }.map { it.toLong() }.also { println(it) }.reduce { a, b -> a * b }
    }

    private fun reduceRules(possibleRules: Map<Int, MutableList<Rule>>): MutableMap<Int, Rule> {
        val foundRules = mutableMapOf<Int, Rule>()
        while (foundRules.size < possibleRules.size) {
            possibleRules.entries
                .filter { (_, possibleValues) -> possibleValues.size == 1 }
                .forEach { (rule, possibleValues) ->
                    val columnNumber = possibleValues.first()
                    foundRules[rule] = columnNumber
                    possibleRules.values.forEach { it.remove(columnNumber) }
                }
        }
        return foundRules
    }

    private fun isTicketValid(ticket: List<Int>): Boolean {
        for (nr in ticket) {
            if (!obeysRules(nr)) return false
        }
        return true
    }

    private fun obeysRules(n: Int): Boolean {
        for (r in rules) {
            if (n in r.range1 || n in r.range2) return true
        }
        return false
    }

    private fun Rule.covers(n: Int): Boolean {
        return n in this.range1 || n in this.range2
    }

    private data class Rule(val name: String, val range1: IntRange, val range2: IntRange)
    private data class Ticket(val nrs: List<Int>)

    companion object {
        // static vars
    }
}
