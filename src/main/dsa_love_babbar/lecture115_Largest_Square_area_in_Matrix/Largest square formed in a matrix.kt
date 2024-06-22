package lecture115_Largest_Square_area_in_Matrix

/**
 *    https://www.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1
 */
fun main() {
    var mat = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
    println(maxSquare(mat.size, mat[0].size, mat))

    mat = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
    println(maxSquare(mat.size, mat[0].size, mat))
}

private var maxi = 0

private fun maxSquare(n: Int, m: Int, mat: Array<IntArray>): Int {

    /*maxi = 0
    solve(mat, 0, 0)
    return maxi*/

    /*maxi = 0
    val dp = Array(n) { IntArray(m) { -1 } }
    solveMem(mat, 0, 0, dp)
    return maxi*/

    /*maxi = 0
    solveTab(n, m, mat)
    return maxi*/

    maxi = 0
    solveOptimize(n, m, mat)
    return maxi
}

private fun solve(mat: Array<IntArray>, row: Int, col: Int): Int {

    // base case
    if (row >= mat.size || col >= mat[0].size) {
        return 0
    }

    val right = solve(mat, row, col + 1)
    val diagonal = solve(mat, row + 1, col + 1)
    val down = solve(mat, row + 1, col)

    if (mat[row][col] == 1) {
        val ans = (1 + Math.min(right, Math.min(diagonal, down)))
        maxi = Math.max(maxi, ans)
        return ans
    } else {
        return 0
    }
}

private fun solveMem(mat: Array<IntArray>, row: Int, col: Int, dp: Array<IntArray>): Int {

    // base case
    if (row >= mat.size || col >= mat[0].size) {
        return 0
    }

    if (dp[row][col] != -1) {
        return dp[row][col]
    }

    val right = solveMem(mat, row, col + 1, dp)
    val diagonal = solveMem(mat, row + 1, col + 1, dp)
    val down = solveMem(mat, row + 1, col, dp)

    if (mat[row][col] == 1) {
        dp[row][col] = (1 + Math.min(right, Math.min(diagonal, down)))
        maxi = Math.max(maxi, dp[row][col])
        return dp[row][col]
    } else {
        dp[row][col] = 0
        return dp[row][col]
    }
}

private fun solveTab(n: Int, m: Int, mat: Array<IntArray>): Int {

    val dp = Array(n + 1) { IntArray(m + 1) { 0 } }

    dp[n][m] = 0

    for (row in n - 1 downTo 0) {
        for (col in m - 1 downTo 0) {

            val right = dp[row][col + 1]
            val diagonal = dp[row + 1][col + 1]
            val down = dp[row + 1][col]

            if (mat[row][col] == 1) {
                dp[row][col] = (1 + Math.min(right, Math.min(diagonal, down)))
                maxi = Math.max(maxi, dp[row][col])
            } else {
                dp[row][col] = 0
            }
        }
    }

    return -1
}

private fun solveOptimize(n: Int, m: Int, mat: Array<IntArray>): Int {

    val curr = IntArray(m + 1)
    var next = IntArray(m + 1)

    for (row in n - 1 downTo 0) {
        for (col in m - 1 downTo 0) {

            val right = curr[col + 1]
            val diagonal = next[col + 1]
            val down = next[col]

            if (mat[row][col] == 1) {
                curr[col] = (1 + Math.min(right, Math.min(diagonal, down)))
                maxi = Math.max(maxi, curr[col])
            } else {
                curr[col] = 0
            }
        }

        next = curr.copyOf(curr.size)
    }

    return -1
}







