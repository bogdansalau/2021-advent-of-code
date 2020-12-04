package day2

import java.util.*

data class Password(val lowerBound: Int, val upperBound: Int, val char: Char, val value: String)

/**
 * Example:
 * 1-3 a: abcde
 * 1-3 b: cdefg
 * 2-9 c: ccccccccc
 *
 * Each line gives the password policy and then the password.
 * The password policy indicates the lowest and highest number
 * of times a given letter must appear for the password to be valid.
 * For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.
 *
 * In the above example, 2 passwords are valid.
 * The middle password, cdefg, is not; it contains no instances of b, but needs at least 1.
 * The first and third passwords are valid: they contain one a or nine c, both within the limits of their respective policies.
 */
fun countValidPasswords(passwords: String): Int {
    return parsePasswords(passwords).filter { validatePassPolicy2(it) }.count()
}

private fun validatePassPolicy1(pass: Password): Boolean {
    val i = pass.value.toCharArray().filter { it == pass.char }.count()
    return i in pass.lowerBound..pass.upperBound
}

fun validatePassPolicy2(pass: Password): Boolean {
    val isInFirstPos = try { pass.value[pass.lowerBound - 1] == pass.char } catch (e: Exception) { false }
    val isInSecondPos = try { pass.value[pass.upperBound - 1] == pass.char } catch (e: Exception) { false }
    return isInFirstPos.xor(isInSecondPos)
}

private fun parsePasswords(passwords: String): List<Password> {
    return passwords
        .trim()
        .split("\n")
        .filter { it != ""}
        .map {
            val scanner = Scanner(it)

            val bounds = scanner.next()
            val lowerBound = bounds.split("-")[0].toInt()
            val upperBound = bounds.split("-")[1].toInt()

            val char = scanner.next().removeSuffix(":")[0]
            val value = scanner.next()
            Password(lowerBound, upperBound, char, value)
        }
}

