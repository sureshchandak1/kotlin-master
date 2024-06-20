package backTracking

/**
 *   https://leetcode.com/problems/n-queens/description/
 *   https://www.geeksforgeeks.org/problems/n-queen-problem0315/1
 *   Time complexity: O(N! * N)
 *   Space complexity: O(N)
 */
fun main() {
    println(solveNQueens(4).toString())
    println(solveNQueens(2).toString())
    println(solveNQueens(5).toString())
    println(solveNQueens(1).toString())
}

private val rowMap: MutableMap<Int, Boolean> = HashMap()
private val upDiagonalMap: MutableMap<Int, Boolean> = HashMap()
private val downDiagonalMap: MutableMap<Int, Boolean> = HashMap()

private fun solveNQueens(n: Int): List<List<String>> {

    val board: Array<CharArray> = Array(n) { CharArray(n) { '.' } }

    val ans = ArrayList<ArrayList<String>>()

    solve(0, ans, board, n)

    return ans

}

private fun solve(col: Int, ans: ArrayList<ArrayList<String>>, board: Array<CharArray>, n: Int) {

    // Base case
    if (col == n) {
        addAnswer(n, ans, board)
        return
    }

    for (row in 0 ..< n) {

        if (isSafe(row, col, n)) {

            board[row][col] = 'Q'
            rowMap[row] = true
            upDiagonalMap[(n - 1) + (col - row)] = true
            downDiagonalMap[(row + col)] = true

            solve(col + 1, ans, board, n)

            // backtrack
            board[row][col] = '.'
            rowMap[row] = false
            upDiagonalMap[(n - 1) + (col - row)] = false
            downDiagonalMap[(row + col)] = false
        }
    }
}

private fun isSafe(row: Int, col: Int, n: Int): Boolean {

    // row check
    if (rowMap.getOrDefault(row, false)) {
        return false
    }

    // up diagonal check
    var key = (n - 1) + (col - row)
    if (upDiagonalMap.getOrDefault(key, false)) {
        return false
    }

    // down diagonal check
    key = row + col
    if (downDiagonalMap.getOrDefault(key, false)) {
        return false
    }

    return true
}

private fun isSafe(row: Int, col: Int, board: Array<CharArray>, n: Int): Boolean {
    var x = row
    var y = col

    // check for same row
    while (y >= 0) {
        if (board[x][y] == 'Q') {
            return false
        }

        y--
    }

    x = row
    y = col

    // check for diagonal
    while (x >= 0 && y >= 0) {
        if (board[x][y] == 'Q') {
            return false
        }

        x--
        y--
    }

    x = row
    y = col

    while (x < n && y >= 0) {
        if (board[x][y] == 'Q') {
            return false
        }

        x++
        y--
    }

    return true
}

private fun addAnswer(n: Int, ans: ArrayList<ArrayList<String>>, board: Array<CharArray>) {

    val temp = ArrayList<String>()

    for (i in 0 ..< n) {
        val builder = StringBuilder()
        for (j in 0 ..< n) {
            if (board[i][j] == 'Q') {
                builder.append('Q')
            } else {
                builder.append('.')
            }
        }
        temp.add(builder.toString())
    }

    ans.add(temp)
}





