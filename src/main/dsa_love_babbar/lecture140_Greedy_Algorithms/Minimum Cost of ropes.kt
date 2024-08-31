package lecture140_Greedy_Algorithms

import java.util.*

/**
 *     https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
 *     Time Complexity: O(n * (log n))
 *     Space Complexity: O(n)
 */
fun main() {
    println(minCost(longArrayOf(4, 3, 2, 6)))
    println(minCost(longArrayOf(4, 2, 7, 6, 9)))
}

private fun minCost(arr: LongArray): Long {

    val minPq = PriorityQueue<Long>()

    for (value in arr) {
        minPq.add(value)
    }

    var cost: Long = 0
    while (minPq.size > 1) {
        val first = minPq.poll()
        val second = minPq.poll()

        val mergeLength = first + second
        cost += mergeLength

        minPq.add(mergeLength)
    }

    return cost
}



