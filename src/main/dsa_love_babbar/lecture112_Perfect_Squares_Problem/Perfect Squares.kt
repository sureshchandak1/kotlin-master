package lecture112_Perfect_Squares_Problem

/**
 *    https://leetcode.com/problems/perfect-squares/description/
 */
fun main() {
    println(numSquares(12))
    println(numSquares(13))
    println(numSquares(10000))
}

private fun numSquares(n: Int): Int {

    //return solve(n)

    //val dp = IntArray(n + 1) { -1 }
    //return solveMem(n, dp)

    return solveTab(n)
}

// Recursion
// T.C = exponentially
private fun solve(n: Int): Int {

    // Base case
    if (n == 0) return 0

    var ans = n
    var i = 1
    while (i*i <= n) {
        val temp = i * i
        ans = Math.min(ans, 1 + solve(n - temp))

        i++
    }

    return ans
}

// Memorization
// T.C = O(n), S.C = O(n) + O(n)
private fun solveMem(n: Int, dp: IntArray): Int {

    // Base case
    if (n == 0) return 0

    if (dp[n] != -1) return dp[n]

    var ans = n
    var i = 1
    while (i*i <= n) {
        val temp = i * i
        ans = Math.min(ans, 1 + solveMem(n - temp, dp))

        i++
    }

    dp[n] = ans
    return dp[n]
}

// Tabulation
// T.C = O(n), S.C = O(n)
private fun solveTab(n: Int): Int {

    val dp = IntArray(n + 1) { Int.MAX_VALUE }

    dp[0] = 0

    for (index in 1 .. n) {

        var i = 1
        while (i*i <= n) {
            val temp = i * i
            if (index - temp >= 0) {
                dp[index] = Math.min(dp[index], 1 + dp[index - temp])
            }

            i++
        }
    }

    return dp[n]
}



















