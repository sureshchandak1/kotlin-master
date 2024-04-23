package array

/**
 *    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
fun main() {
    var prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices))

    prices = intArrayOf(7, 6, 4, 3, 1)
    println(maxProfit(prices))

    prices = intArrayOf(2, 4, 1)
    println(maxProfit(prices))
}

/**
 *         Greedy Approach
 *   Time Complexity: O(N), where N is size of array
 *   Space Complexity: O(1)
 */
private fun maxProfit(prices: IntArray): Int {

    val size = prices.size
    var buy = prices[0]
    var maxProfit = 0

    for (i in 1..<size) {

        // buy when price is low
        if (buy > prices[i]) {
            buy = prices[i]
        } else if (prices[i] - buy > maxProfit) {
            maxProfit = prices[i] - buy
        }
    }

    return maxProfit

}


