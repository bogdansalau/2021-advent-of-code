package day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PasswordPhilosophyTest {

    @Test
    fun `second policy test`() {
        val pass = Password(1, 3, 'a', "abcde")

        val policyResult = validatePassPolicy2(pass)

        assertEquals(true, policyResult)
    }

}
