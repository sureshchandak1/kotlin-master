package lecture108_Count_derangements


private const val MOD: Long = 1000000007

/**
 *    https://www.naukri.com/code360/problems/count-derangements_873861
 */
fun main() {
    println(countDerangements(2))
    println(countDerangements(3))
    println(countDerangements(1))
    println(countDerangements(4))
}

private fun countDerangements(n: Int): Long {

    /*val dp = LongArray(n + 1)
    Arrays.fill(dp, -1)
    return solveMem(n, dp)*/

    //return solveTab(n)

    return solveOptimize(n)
}

// Recursion
// T.C = exponentially
private fun solve(n: Int): Long {

    // Base case
    if (n == 1) {
        return 0
    }
    if (n == 2) {
        return 1
    }

    val ans = ((n - 1) % MOD * (solve(n - 1) % MOD + solve(n - 2) % MOD)) % MOD

    return ans
}

// Memoization
// T.C = O(n), S.C = O(n) + O(n)
private fun solveMem(n: Int, dp: LongArray): Long {

    // Base case
    if (n == 1) {
        return 0
    }
    if (n == 2) {
        return 1
    }

    if (dp[n] != -1L) {
        return dp[n]
    }

    dp[n] = (((n - 1) % MOD) * ((solveMem(n - 1, dp) % MOD) + (solveMem(n - 2, dp) % MOD)) % MOD)

    return dp[n]
}

// Tabulation
// T.C = O(n), S.C = O(n)
private fun solveTab(n: Int): Long {

    val dp = LongArray(n + 1)

    dp[1] = 0
    dp[2] = 1

    for (i in 3..n) {
        val first = dp[i - 1] % MOD
        val second = dp[i - 2] % MOD
        val sum = (first + second) % MOD

        val ans = ((i - 1) * sum) % MOD

        dp[i] = ans
    }

    return dp[n]
}

// Space Optimization
// T.C = O(n), S.C = O(1)
private fun solveOptimize(n: Int): Long {

    if (n == 1) {
        return 0
    }

    var prev2: Long = 0
    var prev1: Long = 1

    for (i in 3..n) {
        val first = prev1 % MOD
        val second = prev2 % MOD
        val sum = (first + second) % MOD

        val ans = ((i - 1) * sum) % MOD

        prev2 = prev1
        prev1 = ans
    }

    return prev1
}








