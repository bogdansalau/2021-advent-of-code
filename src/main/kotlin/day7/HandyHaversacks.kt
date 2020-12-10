package day7

/**
 * For example, consider the following rules:
 *
 * light red bags contain 1 bright white bag, 2 muted yellow bags.
 * dark orange bags contain 3 bright white bags, 4 muted yellow bags.
 * bright white bags contain 1 shiny gold bag.
 * muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
 * shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
 * dark olive bags contain 3 faded blue bags, 4 dotted black bags.
 * vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
 * faded blue bags contain no other bags.
 * dotted black bags contain no other bags.
 * These rules specify the required contents for 9 bag types. In this example, every faded blue bag is empty, every vibrant plum bag contains 11 bags (5 faded blue and 6 dotted black), and so on.
 *
 * You have a shiny gold bag. If you wanted to carry it in at least one other bag, how many different bag colors would be valid for the outermost bag? (In other words: how many colors can, eventually, contain at least one shiny gold bag?)
 *
 * In the above rules, the following options would be available to you:
 *
 * A bright white bag, which can hold your shiny gold bag directly.
 * A muted yellow bag, which can hold your shiny gold bag directly, plus some other bags.
 * A dark orange bag, which can hold bright white and muted yellow bags, either of which could then hold your shiny gold bag.
 * A light red bag, which can hold bright white and muted yellow bags, either of which could then hold your shiny gold bag.
 * So, in this example, the number of bag colors that can eventually contain at least one shiny gold bag is 4.
 *
 * How many bag colors can eventually contain at least one shiny gold bag? (The list of rules is quite long; make sure you get all of it.)
 * */

class HandyHaversacks(input: List<String>) {

    private val relationships: Set<BagRule> = parseInput(input)

    fun solvePart1(): Int =
        findParents().size - 1

    fun solvePart2(): Int =
        baggageCost() - 1

    private fun findParents(bag: String = "shiny gold"): Set<String> =
        relationships
            .filter { it.child == bag }
            .flatMap { findParents(it.parent) }.toSet() + bag

    private fun baggageCost(bag: String = "shiny gold"): Int =
        relationships
            .filter { it.parent == bag }
            .sumBy { it.cost * baggageCost(it.child) } + 1

    private fun parseInput(input: List<String>): Set<BagRule> =
        input.filterNot { it.contains("no other") }.flatMap { row ->
            val parts = row.replace(unusedText, "").split(whitespace)
            val parent = parts.take(2).joinToString(" ")
            parts.drop(2).windowed(3, 3, false).map { child ->
                BagRule(
                    parent,
                    child.first().toInt(),
                    child.drop(1).joinToString(" ")
                )
            }
        }.toSet()

    private data class BagRule(val parent: String, val cost: Int, val child: String)

    companion object {
        private val unusedText = """bags|bag|contain|,|\.""".toRegex()
        private val whitespace = """\s+""".toRegex()
    }
}
