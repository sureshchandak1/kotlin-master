package lecture128_Guess_Number_Higher_or_Lower

/**
 *    https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/
 *    T.C = O(n * n)
 *    S.C = O(n * n)
 */
fun main() {
    var n = 10
    println(solveMem(1, n, Array(n + 1) { IntArray(n + 1) { -1 } }))
    n = 1
    println(solveMem(1, n, Array(n + 1) { IntArray(n + 1) { -1 } }))
    n = 2
    println(solveMem(1, n, Array(n + 1) { IntArray(n + 1) { -1 } }))
    println(solveTab(10))
    println(solveTab(1))
    println(solveTab(2))
}

private fun solve(start: Int, end: Int): Int {

    // Base case
    if (start >= end) {
        return 0
    }

    var maxi = Int.MAX_VALUE
    for (i in start .. end) {
        val temp = Math.max(solve(start, i - 1), solve(i + 1, end))
        maxi = Math.min(maxi, i + temp)
    }

    return maxi
}

// Memorization
private fun solveMem(start: Int, end: Int, dp: Array<IntArray>): Int {

    // Base case
    if (start >= end) {
        return 0
    }

    if (dp[start][end] != -1) {
        return dp[start][end]
    }

    var maxi = Int.MAX_VALUE
    for (i in start .. end) {
        val temp = Math.max(solveMem(start, i - 1, dp), solveMem(i + 1, end, dp))
        maxi = Math.min(maxi, i + temp)
    }

    dp[start][end] = maxi

    return dp[start][end]
}

// Tabulation
private fun solveTab(n: Int): Int {

    val dp = Array(n + 2) { IntArray(n + 2) { 0 } }

    for (start in n downTo 1) {
        for (end in start .. n) {

            if (start == end) {
                continue
            } else {

                var maxi = Int.MAX_VALUE
                for (i in start .. end) {
                    val temp = Math.max(dp[start][i - 1], dp[i + 1][end])
                    maxi = Math.min(maxi, i + temp)
                }

                dp[start][end] = maxi

            }

        }
    }

    return dp[1][n]
}








