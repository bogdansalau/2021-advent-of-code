package day14

import util.pow
import java.util.*

class DockingData(val input: List<String>) {

    private val instructions: List<Instruction> = input.map { if (it[1] == 'e') parseMem(it) else parseMask(it) }

    private val mem: MutableMap<Long, Long> = mutableMapOf()
    private var mask: Mask = instructions[0] as Mask

    fun solvePart1() = instructions
        .map {
            if (it is Mask) {
                mask = it
            } else if (it is Mem) {
                val res = it.applyMask()
                mem[res.addr] = res.value
            }
        }
        .also {
            mem.map { (_, value) -> value }.sum().also { print(it) }
        }

    fun solvePart2(): Long {
        var mask = DEFAULT_MASK
        input.forEach { instruction ->
            if (instruction.startsWith("mask")) {
                mask = instruction.substringAfter("= ")
            } else {
                val unmaskedAddress = instruction.substringAfter("[").substringBefore("]")
                val value = instruction.substringAfter("= ").toLong()
                unmaskedAddress.generateAddressMasks(mask).forEach { address ->
                    mem[address] = value
                }

            }
        }

        return mem.values.sum()
    }

    private fun parseMask(it: String): Instruction {
        return Mask(it.trim().split(" ")[2].toCharArray())
    }

    private fun parseMem(it: String): Instruction {
        val addr = it.trim().split(" ")[0].drop(4).dropLast(1).toLong()
        val value = it.trim().split(" ")[2].toLong()
        return Mem(addr, value)
    }

    private fun String.generateAddressMasks(mask: String): List<Long> {
        val addresses = mutableListOf(this.toBinary().toCharArray())
        mask.forEachIndexed { idx, bit ->
            when (bit) {
                '1' -> addresses.forEach { it[idx] = '1' }
                'X' -> {
                    addresses.forEach { it[idx] = '1' }
                    addresses.addAll(
                        addresses.map {
                            it.copyOf().apply {
                                this[idx] = '0'
                            }
                        }
                    )
                }
            }
        }
        return addresses.map { it.joinToString("").toLong(2) }
    }

    private fun String.toBinary(): String =
        this.toLong().toString(2).padStart(36, '0')

    private interface Instruction

    private data class Mask(val bits: CharArray) : Instruction {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Mask

            if (!bits.contentEquals(other.bits)) return false

            return true
        }

        override fun hashCode(): Int {
            return bits.contentHashCode()
        }
    }

    private data class Mem(val addr: Long, val value: Long) : Instruction

    private fun Mem.applyMask(): Mem {
        var result = this.value
        for(c in mask.bits.size - 1 downTo 0L) {
            when (mask.bits[c.toInt()]) {
                '1' -> result = setBit(mask.bits.size - c - 1, result)
                '0' -> result = disableBit(mask.bits.size - c - 1, result)
                else -> {}
            }
        }
        return Mem(this.addr, result)
    }

    private fun setBit(bit: Long, nr: Long): Long {
        return nr.or(2L.pow(bit))
    }

    private fun disableBit(bit: Long, nr: Long): Long {
        return nr.and(2L.pow(bit).inv())
    }

    companion object {
        const val DEFAULT_MASK = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
    }

}


