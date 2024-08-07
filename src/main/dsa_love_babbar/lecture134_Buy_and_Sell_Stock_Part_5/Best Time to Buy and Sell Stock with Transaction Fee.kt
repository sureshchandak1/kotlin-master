package lecture134_Buy_and_Sell_Stock_Part_5

/**
 *    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 */
fun main() {
    println(solveSO(intArrayOf(1, 3, 2, 8, 4, 9), 2))
    println(solveSO(intArrayOf(1, 3, 7, 5, 10, 3), 3))
}

private fun solveSO(prices: IntArray, fee: Int): Int {
    val n = prices.size

    val curr = IntArray(2)
    var next = IntArray(2)

    for (index in n - 1 downTo 0) {
        for (isBuy in 0..1) {

            var profit = 0
            if (isBuy == 1) {
                val buy = -prices[index] + next[0]
                val notBuy = 0 + next[1]
                profit = Math.max(buy, notBuy)
            } else {
                val sell = prices[index] + next[1] - fee
                val notSell = 0 + next[0]
                profit = Math.max(sell, notSell)
            }

            curr[isBuy] = profit

        }

        next = curr.copyOf()
    }

    return next[1]
}



