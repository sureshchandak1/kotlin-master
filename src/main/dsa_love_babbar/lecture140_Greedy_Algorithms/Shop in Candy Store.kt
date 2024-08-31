package lecture140_Greedy_Algorithms

import printArray
import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/shop-in-candy-store1145/1
 *    Time Complexity: O(n * (log n))
 *    Space Complexity: O(1)
 */
fun main() {
    printArray(candyStore(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10, 0))
    printArray(candyStore(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10, 1))
    printArray(candyStore(intArrayOf(3, 2, 1, 4), 4, 2))
    printArray(candyStore(intArrayOf(3, 2, 1, 4, 5), 5, 4))
}

private fun candyStore(candies: IntArray, n: Int, k: Int): ArrayList<Int> {

    Arrays.sort(candies)

    var mini = 0
    var maxi = 0

    var buy = 0
    var free = n - 1
    while (buy <= free) {
        mini += candies[buy]

        buy++
        free -= k
    }

    buy = n - 1
    free = 0
    while (free <= buy) {
        maxi += candies[buy]

        buy--
        free += k
    }

    val result = ArrayList<Int>()

    result.add(mini)
    result.add(maxi)

    return result
}


