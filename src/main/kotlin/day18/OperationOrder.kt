package day18

class OperationOrder(val input: List<String>) {


    fun solvePart1(): Long = input.map { it.replace(" ", "") }.map { it.iterator() }.map { evaluateExpression(it) }.sum()

    fun solvePart2(): Long = input.map { it.replace(" ", "") }.map { it.iterator() }.map { evaluateExpressionWithPrecedence(it) }.sum()

    private fun evaluateExpression(expression: CharIterator): Long {
        var acc = 0L
        var lastSymbol = '+'
        while (expression.hasNext()) {
            when (val next = expression.nextChar()) {
                '(' -> {
                    val paranthesisResult = evaluateExpression(expression)
                    acc = acc.apply(paranthesisResult, lastSymbol)
                }
                ')' -> return acc
                '*' -> lastSymbol = '*'
                '+' -> lastSymbol = '+'
                else -> {
                    acc = acc.apply(next.toLongNr(), lastSymbol)
                }
            }
        }
        return acc
    }

    private fun evaluateExpressionWithPrecedence(expression: CharIterator): Long {
        val toMultiply = mutableListOf<Long>()
        var acc = 0L
        while (expression.hasNext()) {
            val next = expression.nextChar()
            when {
                next == '(' -> acc += evaluateExpressionWithPrecedence(expression)
                next == ')' -> break
                next == '*' -> {
                    toMultiply.add(acc)
                    acc = 0L
                }
                next.isDigit() -> acc += next.toLongNr()
            }
        }
        toMultiply.add(acc)
        return toMultiply.fold(1L) {a, b -> a * b}
    }

    private fun Char.toLongNr(): Long {
        return this.toLong() - 48
    }

    private fun Long.apply(value: Long, op: Char): Long {
        return when (op) {
            '+' -> this + value
            else -> this * value
        }
    }

    private data class Pojo(val a: String, val b: Int)

    companion object {
        // static vars
    }

}
