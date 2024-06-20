package stacks_and_queues

import java.util.*
import kotlin.math.max

/**
 *   https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *   Time Complexity : O(N)
 *   Space Complexity: O(N)
 */
fun main() {
    var arr = longArrayOf(6, 2, 5, 4, 5, 1, 6)
    println(getMaxArea(arr, arr.size.toLong()))

    arr = longArrayOf(7, 2, 8, 9, 1, 3, 6, 5)
    println(getMaxArea(arr, arr.size.toLong()))
}

private fun getMaxArea(hist: LongArray, n: Long): Long {

    val next = nextSmallerElements(hist, n.toInt())
    val prev = prevSmallerElements(hist, n.toInt())

    var area = Int.MIN_VALUE.toLong()

    for (i in 0..<n) {
        val length = hist[i.toInt()]

        if (next[i.toInt()] == -1L) {
            next[i.toInt()] = n
        }

        val breath = next[i.toInt()] - prev[i.toInt()] - 1

        val newArea = length * breath

        area = max(area.toDouble(), newArea.toDouble()).toLong()
    }

    return area
}

private fun nextSmallerElements(arr: LongArray, n: Int): LongArray {

    val s = Stack<Int>()
    s.push(-1)

    val ans = LongArray(n)

    for (i in n - 1 downTo 0) {
        while (s.peek() != -1 && arr[s.peek()] >= arr[i]) {
            s.pop()
        }

        ans[i] = s.peek().toLong()

        s.push(i)
    }

    return ans
}

private fun prevSmallerElements(arr: LongArray, n: Int): LongArray {

    val s = Stack<Int>()
    s.push(-1)

    val ans = LongArray(n)

    for (i in 0..<n) {
        while (s.peek() != -1 && arr[s.peek()] >= arr[i]) {
            s.pop()
        }

        ans[i] = s.peek().toLong()

        s.push(i)
    }

    return ans
}






