package lecture130_Buy_and_Sell_Stock_Part_1

/**
 *     https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

private fun maxProfit(prices: IntArray): Int {

    var mini = prices[0]
    var profit = 0

    for (price in prices) {

        val diff = price - mini
        profit = Math.max(profit, diff)
        mini = Math.min(mini, price)
    }

    return profit

}










