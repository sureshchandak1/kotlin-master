package lecture084_Backtracking_Day3

import lecture023_2D_arrays.printArray2D

/*
*   https://www.naukri.com/code360/problems/sudoku-solver_699919
* */
fun main() {
    val sudoku = arrayOf(
        intArrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
        intArrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
        intArrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
        intArrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
        intArrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
        intArrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
        intArrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0)
    )

    printArray2D(sudoku)
    println("----------------- Solution -----------------")

    solveSudoku(sudoku)

    printArray2D(sudoku)
}

private fun solveSudoku(sudoku: Array<IntArray>) {
    solve(sudoku, sudoku[0].size)
}

private fun solve(board: Array<IntArray>, n: Int): Boolean {

    for (row in 0..< n) {
        for (col in 0..< n) {

            // empty box
            if (board[row][col] == 0) {

                for (value in 1..9) {
                    if (isSafe(row, col, board, value, n)) {
                        board[row][col] = value

                        // recursive call
                        val remainingBoxs = solve(board, n)
                        if (remainingBoxs) {
                            return true
                        } else {
                            // backtrack
                            board[row][col] = 0
                        }
                    }
                }

                return false
            }
        }
    }

    return true
}

private fun isSafe(row: Int, col: Int, board: Array<IntArray>, value: Int, n: Int): Boolean {

    for (i in 0..< n) {

        // row check
        if (board[row][i] == value) {
            return false
        }
        // col check
        if (board[i][col] == value) {
            return false
        }

        // 3*3 matrix check
        if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value) {
            return false
        }
    }

    return true
}




