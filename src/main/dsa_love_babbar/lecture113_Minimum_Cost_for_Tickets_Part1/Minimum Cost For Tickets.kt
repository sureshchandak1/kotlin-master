package lecture113_Minimum_Cost_for_Tickets_Part1

import java.util.*

/**
 *    https://leetcode.com/problems/minimum-cost-for-tickets/description/
 */
fun main() {
    var days = intArrayOf(1, 4, 6, 7, 8, 20)
    var costs = intArrayOf(2, 7, 15)
    println(minCostTickets(days.size, days, costs))

    days = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31); costs = intArrayOf(2, 7, 15)
    println(minCostTickets(days.size, days, costs))
}

private fun minCostTickets(n: Int, days: IntArray, cost: IntArray): Int {

    //return solve(n, days, cost, 0)

    //val dp = IntArray(n + 1) { -1 }
    //return solveMem(n, days, cost, 0, dp)

    return solveTab(n, days, cost)
}

private fun solve(n: Int, days: IntArray, cost: IntArray, index: Int): Int {

    // Base case
    if (index >= n) {
        return 0
    }

    // 1 day pass
    val option1 = cost[0] + solve(n, days, cost, index + 1)

    var i = 0
    // 7 day pass
    i = index
    while (i < n && days[i] < days[index] + 7) {
        i++
    }

    val option2 = cost[1] + solve(n, days, cost, i)

    // 30 days pass
    i = index
    while (i < n && days[i] < days[index] + 30) {
        i++
    }

    val option3 = cost[2] + solve(n, days, cost, i)

    return Math.min(option1, Math.min(option2, option3))
}

// Memorization
// T.C = O(1)
private fun solveMem(n: Int, days: IntArray, cost: IntArray, index: Int, dp: IntArray): Int {

    // Base case
    if (index >= n) {
        return 0
    }

    if (dp[index] != -1) {
        return dp[index]
    }

    // 1 day pass
    val option1 = cost[0] + solveMem(n, days, cost, index + 1, dp)

    var i = 0
    // 7 day pass
    i = index
    while (i < n && days[i] < days[index] + 7) {
        i++
    }

    val option2 = cost[1] + solveMem(n, days, cost, i, dp)

    // 30 days pass
    i = index
    while (i < n && days[i] < days[index] + 30) {
        i++
    }

    val option3 = cost[2] + solveMem(n, days, cost, i, dp)

    dp[index] = Math.min(option1, Math.min(option2, option3))
    return dp[index]
}

// T.C = O(n)
private fun solveTab(n: Int, days: IntArray, cost: IntArray): Int {

    val dp = IntArray(n + 1)
    Arrays.fill(dp, Int.MAX_VALUE)

    dp[n] = 0

    for (index in n - 1 downTo 0) {

        // 1 day pass
        val option1 = cost[0] + dp[index + 1]

        var i = 0
        // 7 day pass
        i = index
        while (i < n && days[i] < days[index] + 7) {
            i++
        }

        val option2 = cost[1] + dp[i]

        // 30 days pass
        i = index
        while (i < n && days[i] < days[index] + 30) {
            i++
        }

        val option3 = cost[2] + dp[i]

        dp[index] = Math.min(option1, Math.min(option2, option3))
    }

    return dp[0]
}











