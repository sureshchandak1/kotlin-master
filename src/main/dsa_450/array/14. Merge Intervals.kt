package array

import java.util.*
import kotlin.math.max

/**
 *   https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1
 *   https://leetcode.com/problems/merge-intervals/
 */
fun main() {
    var result = overlappedInterval(
        arrayOf(intArrayOf(1, 3), intArrayOf(2, 4), intArrayOf(6, 8), intArrayOf(9, 10))
    )
    print(result)

    result = overlappedInterval(
        arrayOf(intArrayOf(6, 8), intArrayOf(1, 9), intArrayOf(2, 4), intArrayOf(4, 7))
    )
    print(result)
}

/**
 *   Time Complexity: O(N*Log(N))
 *   Auxiliary Space: O(Log(N)) or O(N)
 */
private fun overlappedInterval(intervals: Array<IntArray>): Array<IntArray> {

    val size = intervals.size

    if (size <= 1) {
        return intervals
    }

    Arrays.sort(intervals) { a1: IntArray, a2: IntArray ->
        a1[0] - a2[0]
    }

    var index = 0
    // Intervals = {{1,3},{2,4},{6,8},{9,10}}
    for (i in 1..<size) {

        if (intervals[index][1] >= intervals[i][0]) {
            intervals[index][1] = max(
                intervals[index][1].toDouble(), intervals[i][1].toDouble()
            ).toInt()
        } else {
            index++
            intervals[index] = intervals[i]
        }
    }

    val result: Array<IntArray> = Array(index + 1) { intArrayOf() }

    for (i in 0..index) {
        result[i] = intervals[i]
    }

    return result
}

private fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
    val size = intervals.size

    if (size <= 1) {
        return intervals
    }

    Arrays.sort(intervals) { a1: IntArray, a2: IntArray ->
        a1[0] - a2[0]
    }

    val s = Stack<IntArray>()

    s.push(intervals[0])

    for (i in 1..<size) {
        val top = s.peek()

        if (top[1] < intervals[i][0]) {
            s.push(intervals[i])
        } else if (top[1] < intervals[i][1]) {
            top[1] = intervals[i][1]
            s.pop()
            s.push(top)
        }
    }

    var i = 0
    while (!s.isEmpty()) {
        intervals[i] = s.pop()
        i++
    }

    while (i < size) {
        intervals[i] = IntArray(2)
        i++
    }

    return intervals
}

private fun print(arr: Array<IntArray>) {
    print("[ ")
    arr.forEach {
        print("(${it.joinToString()}) ")
    }
    print("]")
    println()
}


