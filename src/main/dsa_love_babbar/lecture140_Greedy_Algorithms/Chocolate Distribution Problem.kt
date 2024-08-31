package lecture140_Greedy_Algorithms

import java.util.*
import kotlin.math.min

/**
 *     https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 *     Time Complexity: O(n * (log n))
 *     Space Complexity: O(1)
 */
fun main() {
    println(findMinDiff(arrayListOf(3, 4, 1, 9, 56, 7, 9, 12), 8, 5))
    println(findMinDiff(arrayListOf(7, 3, 2, 4, 9, 12, 56), 7, 3))
}

private fun findMinDiff(a: ArrayList<Int>, n: Int, m: Int): Long {

    a.sort()

    var i = 0
    var j = m - 1
    var mini = Int.MAX_VALUE
    while (j < n) {
        val diff = a[j] - a[i]

        mini = min(mini.toDouble(), diff.toDouble()).toInt()

        i++
        j++
    }

    return mini.toLong()
}



