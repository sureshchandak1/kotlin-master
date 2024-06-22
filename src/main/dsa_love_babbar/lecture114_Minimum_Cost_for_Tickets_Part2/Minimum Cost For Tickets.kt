package lecture114_Minimum_Cost_for_Tickets_Part2

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

// T.C = O(n), S.C = O(1)
private fun minCostTickets(n: Int, days: IntArray, cost: IntArray): Int {

    var ans = 0

    val week: Queue<Pair> = LinkedList()
    val month: Queue<Pair> = LinkedList()

    for (day in days) {

        // remove expired days
        while (!week.isEmpty() && week.peek().day + 7 <= day) {
            week.poll()
        }
        while (!month.isEmpty() && month.peek().day + 30 <= day) {
            month.poll()
        }

        // add cost for current day
        week.add(Pair(day, ans + cost[1]))
        month.add(Pair(day, ans + cost[2]))

        // update ans
        ans = Math.min(ans + cost[0], Math.min(week.peek().cost, month.peek().cost))
    }

    return ans
}

private class Pair(day: Int, cost: Int) {
    var day: Int = 0
    var cost: Int = 0

    init {
        this.day = day
        this.cost = cost
    }
}





