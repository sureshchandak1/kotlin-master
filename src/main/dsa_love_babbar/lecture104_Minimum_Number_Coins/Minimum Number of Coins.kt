package lecture104_Minimum_Number_Coins

/**
 *    https://leetcode.com/problems/coin-change/description/
 */
fun main() {
    var coins = intArrayOf(1, 2, 5)
    println(coinChange(coins, 11))
    coins = intArrayOf(2)
    println(coinChange(coins, 3))
    coins = intArrayOf(1)
    println(coinChange(coins, 0))
    coins = intArrayOf(1, 2, 5)
    println(coinChange(coins, 100))
}

private fun coinChange(coins: IntArray, amount: Int): Int {

    //val ans = solveRec(coins, amount)
    //if (ans == Int.MAX_VALUE) return -1 else return ans

    //val dp = IntArray(amount + 1) { -1 }
    //val ans = solveMem(coins, amount, dp)
    //if (ans == Int.MAX_VALUE) return -1 else return ans

    return solveTab(coins, amount)
}

// Recursion
private fun solveRec(coins: IntArray, amount: Int): Int {

    // Base case
    if (amount == 0) return 0
    if (amount < 0) return Int.MAX_VALUE

    var mini = Int.MAX_VALUE
    for (coin in coins) {
        val ans = solveRec(coins, amount - coin)
        if (ans != Int.MAX_VALUE) {
            mini = Math.min(mini, 1 + ans)
        }
    }

    return mini

}

// Memoization
// T.C = O(amount * n), S.C = O(amount)
private fun solveMem(coins: IntArray, amount: Int, dp: IntArray): Int {

    // Base case
    if (amount == 0) return 0
    if (amount < 0) return Int.MAX_VALUE

    if (dp[amount] != -1) {
        return dp[amount]
    }

    var mini = Int.MAX_VALUE
    for (coin in coins) {
        val ans = solveMem(coins, amount - coin, dp)
        if (ans != Int.MAX_VALUE) {
            mini = Math.min(mini, 1 + ans)
        }
    }

    dp[amount] = mini

    return mini

}

// Tabulation
// T.C = O(amount * n), S.C = O(amount)
private fun solveTab(coins: IntArray, amount: Int): Int {

    val dp = IntArray(amount + 1) { Int.MAX_VALUE }
    dp[0] = 0

    for (i in 1..amount) {

        for (coin in coins) {
            if (i - coin >= 0 && dp[i - coin] != Int.MAX_VALUE) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin])
            }
        }
    }

    return if (dp[amount] == Int.MAX_VALUE) {
        -1
    } else {
        dp[amount]
    }

}
















