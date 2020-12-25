package day19

import day18.OperationOrder
import io.readFileAsString
import io.readFileAsStringArray
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 19")
class MonsterMessagesTest {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example 1`() {
            // Act
            val answer = MonsterMessages(readFileAsStringArray("day19\\in1.txt")).solvePart1()

            //Assert
            Assertions.assertThat(answer).isEqualTo(1)
        }

        @Test
        fun `Matches example 2`() {
            // Act
            val answer = MonsterMessages(readFileAsStringArray("day19\\in2.txt")).solvePart1()

            //Assert
            Assertions.assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = MonsterMessages(readFileAsStringArray("day19\\input.txt")).solvePart1()

            //Assert
            Assertions.assertThat(answer).isEqualTo(184)
        }

    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example 1`() {
            // Act
            val answer = MonsterMessages(readFileAsStringArray("day19\\in3.txt")).solvePart2()

            //Assert
            Assertions.assertThat(answer).isEqualTo(1)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = MonsterMessages(readFileAsStringArray("day19\\input.txt")).solvePart2()

            //Assert
            Assertions.assertThat(answer).isEqualTo(184)
        }
    }
}
