package day19

class MonsterMessages(val input: List<String>) {

    private val rules: Map<Int, Rule> = parseRules(input)
    private val messages: List<String> = input.dropWhile { it.isNotBlank() }.drop(1)

    fun solvePart1(): Int {
        val rule0 = rules[0]
        var i = 0
        messages.forEach {
            val result = rule0!!.match(it.trim(), rules)
            if (result.first == Result.OK && result.second.isEmpty()) i++
        }
        return i
    }

    fun solvePart2(): Int {
        val newRules = rules.toMutableMap()
        val rule0 = newRules[0]
        newRules[8] = ComposedRule(8, listOf(42), listOf(42, 8))
        newRules[11] = ComposedRule(11, listOf(42, 31), listOf(42, 11, 31))
        var i = 0
        messages.forEach {
            val result = rule0!!.match(it.trim(), newRules)
            if (result.first == Result.OK && result.second.isEmpty()) i++
        }
        return i
    }
    private interface Rule {
        fun match(toMatch: String, rules: Map<Int, Rule>): Pair<Result, String>
        fun matchRuleList(toMatch: String, list: List<Int>, rules: Map<Int, Rule>): Pair<Result, String> {
            var str = toMatch
            for (i in list) {
                val rule = rules[i]
                val result = rule!!.match(str, rules)
                when (result.first) {
                    Result.OK -> str = result.second
                    Result.ERR -> {
                        return Pair(Result.ERR, str)
                    }
                }
            }
            return Pair(Result.OK, str)
        }
    }

    private data class SimpleRule(val id: Int, val char: Char) : Rule {
        override fun match(toMatch: String, rules: Map<Int, Rule>): Pair<Result, String> {
            return if (toMatch.startsWith(char)) {
                Pair(Result.OK, toMatch.drop(1))
            } else {
                Pair(Result.ERR, "")
            }
        }
    }

    private data class LinearRule(val id: Int, val a: List<Int>) : Rule {
        override fun match(toMatch: String, rules: Map<Int, Rule>): Pair<Result, String> {
            return matchRuleList(toMatch, a, rules)
        }
    }

    private data class ComposedRule(val id: Int, val a: List<Int>, val b: List<Int>) : Rule {
        override fun match(toMatch: String, rules: Map<Int, Rule>): Pair<Result, String> {
            val resultA = matchRuleList(toMatch, a, rules)
            val resultB = matchRuleList(toMatch, b, rules)

            return when {
                resultA.first == Result.OK -> resultA
                resultB.first == Result.OK -> resultB
                else -> Pair(Result.ERR, "")

            }
        }
    }

    private fun parseRules(input: List<String>): Map<Int, Rule> {
        return input
            .takeWhile { it.isNotBlank() }
            .map { line ->
                val (id, rules) = line.split(": ")
                val sides = rules.split("|")
                if (sides.size == 1) {
                    if (sides[0].trim().startsWith('"')) {
                        val char = sides[0].trim().replace("\"", "")[0]
                        id.toInt() to SimpleRule(id.toInt(), char)
                    } else {
                        val rulesList = sides[0].trim().split(" ").map { it.toInt() }
                        id.toInt() to LinearRule(id.toInt(), rulesList)
                    }
                } else {
                    val a = sides[0].trim().split(" ").map { it.toInt() }
                    val b = sides[1].trim().split(" ").map { it.toInt() }
                    id.toInt() to ComposedRule(id.toInt(), a, b)
                }
            }.toMap()
    }

    companion object {
        enum class Result { OK, ERR }
    }
}
