package day4

typealias Matrix = List<List<Pair<Int, Boolean>>>

class Board(private var board: Matrix) {

    private var lastMarked = -1

    fun mark(toMark: Int) {
        lastMarked = toMark
        board = board
            .map {
                it.map { pair ->
                   if (pair.first == toMark) pair.first to true else pair
                }
            }
    }

    fun getByPos(i: Int, j: Int) = board[i][j]

    fun hasWon(): Boolean {
        var markedRow = 0
        var markedCol = 0
        for (i in 0..4) {
            for (j in 0..4) {
                if (board[i][j].second) markedRow += 1
                if (board[j][i].second) markedCol += 1
            }
            if (markedRow == 5) return true
            if (markedCol == 5) return true
            markedRow = 0
            markedCol = 0
        }
        return false
    }

    fun getScore() = board
            .flatten()
            .filter { !it.second }
            .map { it.first }
            .sum().times(lastMarked)

}

fun String.toBoard(): Board = Board(
    trim().split("\n")
        .map { row ->
            row.trim().split(" ")
                .filter { it != "" }
                .map {
                    it.toInt() to false
                }.toMutableList()
        }
)
