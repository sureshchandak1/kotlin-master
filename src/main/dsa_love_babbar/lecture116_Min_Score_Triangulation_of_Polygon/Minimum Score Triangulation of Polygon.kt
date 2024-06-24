package lecture116_Min_Score_Triangulation_of_Polygon

/**
 *    https://leetcode.com/problems/minimum-score-triangulation-of-polygon/description/
 *    T.C = O(n*n)
 *    S.C = O(n*n)
 */
fun main() {
    println(minScoreTriangulation(intArrayOf(1, 2, 3)))
    println(minScoreTriangulation(intArrayOf(3, 7, 4, 5)))
    println(minScoreTriangulation(intArrayOf(1, 3, 1, 4, 1, 5)))
}

private fun minScoreTriangulation(values: IntArray): Int {
    //val size = values.size
    //return solve(values, 0, size - 1)

    //val dp = Array(size) { IntArray(size) { -1 } }
    //return solveMem(values, 0, size - 1, dp)

    return solveTab(values)
}

// only Recursion
private fun solve(v: IntArray, i: Int, j: Int): Int {

    // Base case
    if (i + 1 == j) return 0

    var ans = Int.MAX_VALUE
    for (k in i + 1..<j) {
        val temp = v[i] * v[j] * v[k] + solve(v, i, k) + solve(v, k, j)
        ans = Math.min(ans, temp)
    }

    return ans
}

// Recursion + Memorization
private fun solveMem(v: IntArray, i: Int, j: Int, dp: Array<IntArray>): Int {

    // Base case
    if (i + 1 == j) return 0

    if (dp[i][j] != -1) {
        return dp[i][j]
    }

    var ans = Int.MAX_VALUE
    for (k in i + 1..<j) {
        val temp = v[i] * v[j] * v[k] + solveMem(v, i, k, dp) + solveMem(v, k, j, dp)
        ans = Math.min(ans, temp)
    }

    dp[i][j] = ans
    return dp[i][j]
}

// Tabulation
private fun solveTab(v: IntArray): Int {

    val size = v.size
    val dp = Array(size) { IntArray(size) { 0 } }

    for (i in size - 1 downTo 0) {
        for (j in i + 2..<size) {

            var ans = Int.MAX_VALUE
            for (k in i + 1..<j) {
                val temp = v[i] * v[j] * v[k] + dp[i][k] + dp[k][j]
                ans = Math.min(ans, temp)
            }

            dp[i][j] = ans

        }
    }

    return dp[0][size - 1]
}












