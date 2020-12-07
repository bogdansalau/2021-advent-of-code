package day6

data class Group(val answers: Set<Char>)

/**
 * abcx
 * abcy
 * abcz
 * In this group, there are 6 questions to which anyone answered "yes": a, b, c, x, y, and z. (Duplicate answers to the same question don't count extra; each question counts at most once.)
 *
 * Another group asks for your help, then another, and eventually you've collected answers from every group on the plane (your puzzle input). Each group's answers are separated by a blank line, and within each group, each person's answers are on a single line. For example:
 *
 * abc
 *
 * a
 * b
 * c
 *
 * ab
 * ac
 *
 * a
 * a
 * a
 * a
 *
 * b
 * This list represents answers from five groups:
 *
 * The first group contains one person who answered "yes" to 3 questions: a, b, and c.
 * The second group contains three people; combined, they answered "yes" to 3 questions: a, b, and c.
 * The third group contains two people; combined, they answered "yes" to 3 questions: a, b, and c.
 * The fourth group contains four people; combined, they answered "yes" to only 1 question, a.
 * The last group contains one person who answered "yes" to only 1 question, b.
 * In this example, the sum of these counts is 3 + 3 + 3 + 1 + 1 = 11.
 *
 * For each group, count the number of questions to which anyone answered "yes". What is the sum of those counts?
 *
 * Part 2
 * As you finish the last group's customs declaration, you notice that you misread one word in the instructions:
 * You don't need to identify the questions to which anyone answered "yes"; you need to identify the questions to which everyone answered "yes"!
 * */
fun countQuestions(questions: String): Int {
    return parseInputAndExtractQuestionsAnsweredTrueByAll(questions).map { it.size }.sum()
    //    return parseInputAndExtractQuestionsAnsweredTrueByAll(questions).map { it.size }.sum()
}

private fun parseInputAndExtractSets(questions: String): List<Set<Char>> {
    return questions
        .split("\n\n")
        .map {
            it
                .split("\n")
                .reduce { a, b -> a + b }
        }.map {
            it.toCharArray().toSet()
        }
}

private fun parseInputAndExtractQuestionsAnsweredTrueByAll(questions: String): List<MutableSet<Char>> {
    return questions
        .removeSuffix("\n")
        .split("\n\n")
        .map {
            it
                .split("\n")
                .map { it.toCharArray().toMutableSet() }
                .reduce { a, b ->
                    a.intersect(b) as MutableSet<Char> }
        }
}
