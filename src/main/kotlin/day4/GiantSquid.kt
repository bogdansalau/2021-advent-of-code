package day4

class GiantSquid(input: String) {
    private val drawnNumbers = input.split("\n")[0].trim().split(",").map { it.toInt() }
    private val boards = input.split("\n\n").drop(1).map { it.toBoard() }.toMutableList()

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

    fun solvePart2(): Int {
        val orderedBoardsByWin = mutableListOf<Board>()

        drawnNumbers
            .forEach { newNumber ->
                boards.forEach { board ->
                    board.mark(newNumber)
                }

                val toRemove = mutableListOf<Board>()
                boards.forEach { board ->
                    if (board.hasWon()) {
                        toRemove.add(board)
                        orderedBoardsByWin.add(board)
                    }
                }

                boards.removeAll(toRemove)
            }
        return orderedBoardsByWin.last().getScore()
    }

}
