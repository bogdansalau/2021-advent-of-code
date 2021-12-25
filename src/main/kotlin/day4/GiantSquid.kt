package day4

class GiantSquid(input: String) {
    private val drawnNumbers = input.split("\n")[0].trim().split(",").map { it.toInt() }
    private val boards = input.split("\n\n").drop(1).map { it.toBoard() }

    fun solvePart1(): Int {
        drawnNumbers
            .forEach { newNumber ->
                boards.forEach { board ->
                    board.mark(newNumber)
                }

                boards.forEach { board ->
                    if (board.hasWon()) return board.getScore()
                }
            }
        return 0
    }

}
