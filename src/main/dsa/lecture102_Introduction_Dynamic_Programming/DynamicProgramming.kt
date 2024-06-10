package lecture102_Introduction_Dynamic_Programming

/**
 *   2 approaches
 *   1. Top-Down : Recursion + Memoization (Store the value of sub problems in map/table)
 *   2. Bottom-Up : Tabulation
 *
 *   Space Optimisation
 */

fun main() {
    println(fib(2))
    println(fib(6))
    println(fib(8))
}

private fun fib(n: Int): Int {

    if (n <= 1) return n

    //val dp = IntArray(n + 1) { -1 }

    return fibonacci3(n)

    //return dp[n]
}

/**
 *   Top-Down
 *   T.C = O(n)
 *   S.C = O(n) + O(n)
 */
private fun fibonacci1(n: Int, dp: IntArray): Int {

    // Base case
    if (n <= 1) return n

    if (dp[n] != -1) {
        return dp[n]
    }

    dp[n] = fibonacci1(n - 1, dp) + fibonacci1(n - 2, dp)

    return dp[n]
}

/**
 *    Bottom-Up
 *    T.C = O(n)
 *    S.C = O(n)
 */
private fun fibonacci2(n: Int, dp: IntArray) {

    dp[0] = 0
    dp[1] = 1

    for (i in 2 .. n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
}

/**
 *    Space Optimisation
 *    T.C = O(n)
 *    S.C = O(1)
 */
private fun fibonacci3(n: Int): Int {

    var prev1 = 0
    var prev2 = 1
    var curr = 0

    for (i in 2 .. n) {
        curr = prev1 + prev2
        prev1 = prev2
        prev2 = curr
    }

    return prev2
}





