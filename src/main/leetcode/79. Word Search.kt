/**
 *   https://leetcode.com/problems/word-search/description/
 */
fun main() {
    val board: Array<CharArray> = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E')
    )
    var word = "ABCCED"
    println(wordSearch(board, word))

    word = "SEE"
    println(wordSearch(board, word))
}

private fun wordSearch(board: Array<CharArray>, word: String): Boolean {
    val rows = board.size
    val cols = board[0].size

    for (r in 0..<rows) {
        for (c in 0..<cols) {
            if (board[r][c] == word[0]) {
                val found = dfs(board, r, c, word, 0)
                if (found) {
                    return true
                }
            }
        }
    }

    return false
}

private fun dfs(board: Array<CharArray>, row: Int, col: Int, word: String, wordIndex: Int): Boolean {
    // Base case
    // valid case
    if (word.length == wordIndex) {
        return true
    }
    // out of bound cases
    val rows = board.size
    val cols = board[0].size
    if (row < 0 || col < 0 || row >= rows || col >= cols) {
        return false
    }
    // invalid case
    if (board[row][col] == ' ' || board[row][col] != word[wordIndex]) {
        return false
    }

    // mark as visited
    val ch: Char = board[row][col]
    board[row][col] = ' '

    // dfs calls
    // Up, Right, Down, Left
    if (dfs(board, row - 1, col, word, wordIndex + 1) ||
        dfs(board, row, col + 1, word, wordIndex + 1) ||
        dfs(board, row + 1, col, word, wordIndex + 1) ||
        dfs(board, row, col - 1, word, wordIndex + 1)
    ) {
        return true
    }

    // backtracking
    board[row][col] = ch

    return false
}


