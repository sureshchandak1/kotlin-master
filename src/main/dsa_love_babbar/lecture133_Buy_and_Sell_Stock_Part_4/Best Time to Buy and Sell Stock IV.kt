package lecture133_Buy_and_Sell_Stock_Part_4

/**
 *    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 */
fun main() {
    println(maxProfit(2, intArrayOf(2,4,1)))
    println(maxProfit(2, intArrayOf(3,2,6,5,0,3)))
    println(maxProfit(11, intArrayOf(48,12,60,93,97,42,25,64,17,56,85,93,9,48,52,42,58,85,81,84,69,36,1,54,23,15,72,15,11,94)))
}

private fun maxProfit(k: Int, prices: IntArray): Int {
    //return solve(prices, k, 0, 0)

    //val n = prices.size
    //val dp = Array(n) { IntArray(2 * k) { -1 } }
    //return solveMem(prices, k, 0, 0, dp)

    //return solveTab(prices, k)

    return solveSO(prices, k)
}

private fun solve(prices: IntArray, k: Int, index: Int, operationNo: Int): Int {

    // Base case
    if (index == prices.size) return 0
    if (operationNo == 2 * k) return 0

    var profit = 0

    if (operationNo % 2 == 0) {
        val buy = -prices[index] + solve(prices, k, index + 1, operationNo + 1)
        val notBuy = 0 + solve(prices, k, index + 1, operationNo)
        profit = Math.max(buy, notBuy)
    }
    else {
        val sell = prices[index] + solve(prices, k, index + 1, operationNo + 1)
        val notSell = 0 + solve(prices, k, index + 1, operationNo)
        profit = Math.max(sell, notSell)
    }

    return profit
}

// Memorization: O(n * k), O(n * k)
private fun solveMem(prices: IntArray, k: Int, index: Int, operationNo: Int, dp: Array<IntArray>): Int {

    // Base case
    if (index == prices.size) return 0
    if (operationNo == 2 * k) return 0

    if (dp[index][operationNo] != -1) {
        return dp[index][operationNo]
    }

    var profit = 0

    if (operationNo % 2 == 0) {
        val buy = -prices[index] + solveMem(prices, k, index + 1, operationNo + 1, dp)
        val notBuy = 0 + solveMem(prices, k, index + 1, operationNo, dp)
        profit = Math.max(buy, notBuy)
    }
    else {
        val sell = prices[index] + solveMem(prices, k, index + 1, operationNo + 1, dp)
        val notSell = 0 + solveMem(prices, k, index + 1, operationNo, dp)
        profit = Math.max(sell, notSell)
    }

    dp[index][operationNo] = profit

    return dp[index][operationNo]
}

// Tabulation: O(n * k), O(n * k)
private fun solveTab(prices: IntArray, k: Int): Int {

    val n = prices.size
    val dp = Array(n + 1) { IntArray(2 * k + 1) }

    for (index in n - 1 downTo 0) {
        for (operationNo in 0 ..< 2 * k) {

            var profit = 0

            if (operationNo % 2 == 0) {
                val buy = -prices[index] + dp[index + 1][operationNo + 1]
                val notBuy = 0 + dp[index + 1][operationNo]
                profit = Math.max(buy, notBuy)
            }
            else {
                val sell = prices[index] + dp[index + 1][operationNo + 1]
                val notSell = 0 + dp[index + 1][operationNo]
                profit = Math.max(sell, notSell)
            }

            dp[index][operationNo] = profit

        }
    }

    return dp[0][0]

}

// Space Optimized: O(n * k), O(k)
private fun solveSO(prices: IntArray, k: Int): Int {

    val n = prices.size
    val curr = IntArray(2 * k + 1)
    var next = IntArray(2 * k + 1)

    for (index in n - 1 downTo 0) {
        for (operationNo in 0 ..< 2 * k) {

            var profit = 0

            if (operationNo % 2 == 0) {
                val buy = -prices[index] + next[operationNo + 1]
                val notBuy = 0 + next[operationNo]
                profit = Math.max(buy, notBuy)
            }
            else {
                val sell = prices[index] + next[operationNo + 1]
                val notSell = 0 + next[operationNo]
                profit = Math.max(sell, notSell)
            }

            curr[operationNo] = profit

        }

        next = curr.copyOf()
    }

    return next[0]

}

private fun solveSO1(prices: IntArray, k: Int): Int {

    val n = prices.size
    val curr = Array(2) { IntArray(k + 1) }
    var next = Array(2) { IntArray(k + 1) }

    for (index in n - 1 downTo 0) {
        for (isBuy in 0..1) {
            for (limit in 1..k) {

                var profit = 0

                if (isBuy == 1) {
                    val buy = -prices[index] + next[0][limit]
                    val notBuy = 0 + next[1][limit]
                    profit = Math.max(buy, notBuy)
                } else {
                    val sell = prices[index] + next[1][limit - 1]
                    val notSell = 0 + next[0][limit]
                    profit = Math.max(sell, notSell)
                }

                curr[isBuy][limit] = profit

            }
        }

        next = curr.copyOf()
    }

    return next[1][k]
}






