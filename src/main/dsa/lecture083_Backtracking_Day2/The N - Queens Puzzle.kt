package lecture083_Backtracking_Day2

/*
*   https://www.naukri.com/code360/problems/the-n-queens-puzzle_981286
* */
fun main() {
    println(nQueens(4).toString())
    println(nQueens(2).toString())
    println(nQueens(5).toString())
    println(nQueens(1).toString())
}

private val rowMap: MutableMap<Int, Boolean> = HashMap()
private val upDiagonalMap: MutableMap<Int, Boolean> = HashMap() // key = (n - 1) + (col - row)
private val downDiagonalMap: MutableMap<Int, Boolean> = HashMap() // key =  row + col

private fun nQueens(n: Int): ArrayList<ArrayList<Int>> {
    // Create board with default values
    val board = Array(n) { IntArray(n) }

    val ans = ArrayList<ArrayList<Int>>()

    solve(0, ans, board, n)

    return ans
}

private fun solve(col: Int, ans: ArrayList<ArrayList<Int>>, board: Array<IntArray>, n: Int) {

    // Base case
    if (col == n) {
        addSolution(ans, board, n)
        return
    }

    // solve 1 case and rest recursion will take care
    for (row in 0..< n) {
        if (isSafe(row, col, n)) {
            board[row][col] = 1

            rowMap[row] = true // row
            upDiagonalMap[(n - 1) + (col - row)] = true // key = (n - 1) + (col - row)
            downDiagonalMap[row + col] = true // key =  row + col

            solve(col + 1, ans, board, n)

            // backtrack
            board[row][col] = 0
            rowMap[row] = false // row
            upDiagonalMap[(n - 1) + (col - row)] = false // key = (n - 1) + (col - row)
            downDiagonalMap[row + col] = false // key =  row + col
        }
    }
}

private fun isSafe(row: Int, col: Int, board: Array<IntArray>, n: Int): Boolean {
    var x = row
    var y = col

    // check for same row
    while (y >= 0) {
        if (board[x][y] == 1) {
            return false
        }

        y--
    }

    x = row
    y = col

    // check for diagonal
    while (x >= 0 && y >= 0) {
        if (board[x][y] == 1) {
            return false
        }

        x--
        y--
    }

    x = row
    y = col

    while (x < n && y >= 0) {
        if (board[x][y] == 1) {
            return false
        }

        x++
        y--
    }

    return true
}

private fun isSafe(row: Int, col: Int, n: Int): Boolean {
    var safe = true

    // row check
    if (rowMap.containsKey(row) && rowMap[row]!!) {
        safe = false
    }

    // up diagonal check
    var key = (n - 1) + (col - row) // (n - 1) + (col - row)
    if (upDiagonalMap.containsKey(key) && upDiagonalMap[key]!!) {
        safe = false
    }

    // down diagonal check
    key = row + col // row + col
    if (downDiagonalMap.containsKey(key) && downDiagonalMap[key]!!) {
        safe = false
    }

    return safe
}

private fun addSolution(ans: ArrayList<ArrayList<Int>>, board: Array<IntArray>, n: Int) {
    val temp = ArrayList<Int>()

    for (i in 0..< n) {
        for (j in 0..< n) {
            temp.add(board[i][j])
        }
    }

    ans.add(temp)
}











