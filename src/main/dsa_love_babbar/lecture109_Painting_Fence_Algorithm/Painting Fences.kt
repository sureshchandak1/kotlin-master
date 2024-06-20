package lecture109_Painting_Fence_Algorithm

import java.util.*

private const val MOD: Long = 1000000007

/**
 *    https://www.naukri.com/code360/problems/ninja-and-the-fence_3210208
 */
fun main() {
    println(numberOfWays(1, 1))
    println(numberOfWays(3, 2))
    println(numberOfWays(2, 4))
    println(numberOfWays(4, 2))
}

private fun numberOfWays(n: Int, k: Int): Int {
    //return solve(n, k);

    /*long[] dp = new long[n+1];
		Arrays.fill(dp, -1);
		int ans = (int) solveMem(n, k, dp);
		return ans;*/

    /*int ans = (int) solveTab(n, k);
		return ans;*/

    val ans = solveOptimize(n, k).toInt()
    return ans
}

// Recursion
// T.C = exponentially
private fun solve(n: Int, k: Int): Long {

    // Base case
    if (n == 1) {
        return k.toLong()
    }
    if (n == 2) {
        return add(k.toLong(), multiply(k.toLong(), (k - 1).toLong()))
    }

    val first = multiply(solve(n - 2, k), (k - 1).toLong())
    val second = multiply(solve(n - 1, k), (k - 1).toLong())

    val ans = add(first, second)

    return ans
}

// Memoization
// T.C = O(n), S.C = O(n) + O(n)
private fun solveMem(n: Int, k: Int, dp: LongArray): Long {

    // Base case
    if (n == 1) {
        return k.toLong()
    }
    if (n == 2) {
        return add(k.toLong(), multiply(k.toLong(), (k - 1).toLong()))
    }

    if (dp[n] != -1L) {
        return dp[n]
    }

    val first = multiply(solveMem(n - 2, k, dp), (k - 1).toLong())
    val second = multiply(solveMem(n - 1, k, dp), (k - 1).toLong())

    dp[n] = add(first, second)

    return dp[n]
}

// Tabulation
// T.C = O(n), S.C = O(n)
private fun solveTab(n: Int, k: Int): Long {

    if (n == 1) {
        return k.toLong()
    }

    val dp = LongArray(n + 1)
    Arrays.fill(dp, 0)

    dp[1] = k.toLong()
    dp[2] = add(k.toLong(), multiply(k.toLong(), (k - 1).toLong()))

    for (i in 3..n) {
        val first = multiply(dp[i - 2], (k - 1).toLong())
        val second = multiply(dp[i - 1], (k - 1).toLong())

        dp[i] = add(first, second)
    }

    return dp[n]
}

// Space Optimization
// T.C = O(n), S.C = O(1)
private fun solveOptimize(n: Int, k: Int): Long {

    var prev2 = k.toLong()
    var prev1 = add(k.toLong(), multiply(k.toLong(), (k - 1).toLong()))

    for (i in 3..n) {
        val first = multiply(prev2, (k - 1).toLong())
        val second = multiply(prev1, (k - 1).toLong())

        val ans = add(first, second)

        prev2 = prev1
        prev1 = ans
    }

    return prev1
}

private fun add(a: Long, b: Long): Long {
    return (a % MOD + b % MOD) % MOD
}

private fun multiply(a: Long, b: Long): Long {
    return (a % MOD * b % MOD) % MOD
}





