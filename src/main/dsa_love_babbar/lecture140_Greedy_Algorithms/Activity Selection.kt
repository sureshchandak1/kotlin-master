package lecture140_Greedy_Algorithms

import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1
 *    Time Complexity: O(n * (log n))
 *    Space Complexity: O(n)
 */
fun main() {
    println(activitySelection(intArrayOf(2, 1), intArrayOf(2, 2), 2))
    println(activitySelection(intArrayOf(1, 3, 2, 5), intArrayOf(2, 4, 3, 6), 4))
}

private fun activitySelection(start: IntArray, end: IntArray, n: Int): Int {

    val activity: MutableList<Pair> = ArrayList()

    for (i in 0..< n) {
        activity.add(Pair(start[i], end[i]))
    }

    Collections.sort(activity, MyComparator())

    var count = 1
    var ansEnd = activity[0].end

    for (i in 1..< n) {
        if (activity[i].start > ansEnd) {
            count++
            ansEnd = activity[i].end
        }
    }

    return count
}





