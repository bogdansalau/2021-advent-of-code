package day8

import java.util.EnumSet.range


class HandheldHalting(input: List<String>) {

    private val ops: MutableList<Operation> = parseInput(input)
    private var visited: MutableList<Boolean> = (ops.indices).map { false }.toMutableList()
    private var acc = 0

    private var loopFlag = false
    private var terminatedFlag = false

    fun solvePart1(): Int = exec(0)

    fun solvePart2(): Int {
        for (i in 0 until ops.size) {
            visited = visited.map { false }.toMutableList()
            acc = 0
            loopFlag = false
            terminatedFlag = false
            ops[i] = flip(ops[i])
            exec(0)
            if (terminatedFlag) {
                return acc
            } else {
                ops[i] = flip(ops[i])
            }
        }
        return 0
    }


    private fun exec(ptr: Int): Int {
        if (ptr == ops.size) {
            terminatedFlag = true
            return 0
        }
        if (loopFlag) return 0
        val op = ops[ptr]
        return when (op.opcode) {
            "nop" -> if (visited[ptr]) {
                loopFlag = true
                acc
            } else {
                visited[ptr] = true
                exec(ptr + 1)
            }
            "acc" -> if (visited[ptr]) {
                loopFlag = true
                acc
            } else {
                visited[ptr] = true
                acc += op.value
                exec(ptr + 1)
            }
            else -> {
                if (visited[ptr]) {
                    loopFlag = true
                    acc
                } else {
                    visited[ptr] = true
                    exec(ptr + op.value)
                }
            }
        }
    }


    private fun flip(op: Operation): Operation {
        return when (op.opcode) {
            "acc" -> op
            "jmp" -> Operation("nop", op.value)
            else -> {
                Operation("jmp", op.value)
            }
        }
    }


//
//    private fun baggageCost(bag: String = "shiny gold"): Int =
//        relationships
//            .filter { it.parent == bag }
//            .sumBy { it.cost * baggageCost(it.child) } + 1

    private fun parseInput(input: List<String>): MutableList<Operation> =
        input
            .map { row ->
                val components = row.trim().split(" ");

                val opcode = components[0];
                val value =
                    if (components[1][0] == '+') components[1].drop(1).toInt() else (-1) * components[1].drop(1).toInt()

                Operation(opcode, value)
            }.toMutableList()

    private data class Operation(val opcode: String, val value: Int)

    companion object {
        private val unusedText = """bags|bag|contain|,|\.""".toRegex()
        private val whitespace = """\s+""".toRegex()
    }
}


