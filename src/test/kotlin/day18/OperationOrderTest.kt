package day18

import io.readStringArray
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 18")
class OperationOrderTest {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches my example 1`() {
            // Act
            val answer = OperationOrder(listOf("2+3")).solvePart1()

            //Assert
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Matches my example 2`() {
            // Act
            val answer = OperationOrder(listOf("2+3*2")).solvePart1()

            //Assert
            assertThat(answer).isEqualTo(10)
        }

        @Test
        fun `Matches my example 3`() {
            // Act
            val answer = OperationOrder(listOf("2+(3*2)")).solvePart1()

            //Assert
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Matches example 1`() {
            // Act
            val answer = OperationOrder(listOf("2 * 3 + (4 * 5)")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(26)
        }

        @Test
        fun `Matches example 2`() {
            // Act
            val answer = OperationOrder(listOf("5 + (8 * 3 + 9 + 3 * 4 * 3)")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(437)
        }

        @Test
        fun `Matches example 3`() {
            // Act
            val answer = OperationOrder(listOf("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(12_240)
        }


        @Test
        fun `Matches example 4`() {
            // Act
            val answer = OperationOrder(listOf("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(13_632)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = OperationOrder(readStringArray("day18\\input.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(98_621_258_158_412)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example 1`() {
            // Act
            val answer = OperationOrder(listOf("2 * 3 + (4 * 5)")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(46)
        }

        @Test
        fun `Matches example 2`() {
            // Act
            val answer = OperationOrder(listOf("5 + (8 * 3 + 9 + 3 * 4 * 3)")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_445)
        }

        @Test
        fun `Matches example 3`() {
            // Act
            val answer = OperationOrder(listOf("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(669_060)
        }


        @Test
        fun `Matches example 4`() {
            // Act
            val answer = OperationOrder(listOf("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(23_340)
        }


        @Test
        fun `Actual answer`() {
            // Act
            val answer = OperationOrder(readStringArray("day18\\input.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(241_216_538_527_890)
        }
    }
}
