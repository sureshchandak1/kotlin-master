package stacks_and_queues

import java.util.*

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
 *   Time Complexity: O(N * Log(N) ), where N is size of intervals
 *   Auxiliary Space: O(N)
 */
private fun overlappedInterval(intervals: Array<IntArray>): Array<IntArray> {
    val length = intervals.size
    if (length == 0) {
        return intervals
    }

    Arrays.sort(intervals) { a1: IntArray?, a2: IntArray? ->
        a1!![0] - a2!![0]
    }

    val stack = Stack<IntArray>()

    stack.push(intervals[0])

    for (i in 1..< length) {

        val top: IntArray = stack.peek()

        if (top[1] < intervals[i][0]) {
            stack.push(intervals[i])
        } else if (top[1] < intervals[i][1]) {
            top[1] = intervals[i][1]
            stack.pop()
            stack.push(top)
        }
    }

    // prepare answer from stack for return
    val size = stack.size
    val ans = Array(size) { intArrayOf() }

    var index = size - 1
    while (!stack.isEmpty()) {
        val top = stack.pop()
        ans[index--] = top
    }

    return ans
}

private fun print(arr: Array<IntArray>) {
    print("[ ")
    arr.forEach {
        print("(${it.joinToString()}) ")
    }
    print("]")
    println()
}







