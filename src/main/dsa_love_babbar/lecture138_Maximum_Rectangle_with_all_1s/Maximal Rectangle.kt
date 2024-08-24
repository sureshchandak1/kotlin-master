package lecture138_Maximum_Rectangle_with_all_1s

import java.util.*

/**
 *    https://leetcode.com/problems/maximal-rectangle/description/
 */
fun main() {
    var matrix = arrayOf(
        charArrayOf('1','0','1','0','0'), charArrayOf('1','0','1','1','1'),
        charArrayOf('1','1','1','1','1'), charArrayOf('1','0','0','1','0')
    )
    println(maximalRectangle(matrix))

    matrix = arrayOf( charArrayOf('0') )
    println(maximalRectangle(matrix))

    matrix = arrayOf( charArrayOf('1') )
    println(maximalRectangle(matrix))
}

private fun maximalRectangle(matrix: Array<CharArray>): Int {

    var ans = Int.MIN_VALUE

    val histogram = IntArray(matrix[0].size)

    for (i in 0 ..< matrix.size) {
        // create histogram array
        for (j in 0 ..< histogram.size) {
            if (matrix[i][j] == '1') {
                histogram[j]++
            } else {
                histogram[j] = 0
            }
        }

        ans = Math.max(ans, largestRectangleArea(histogram))
    }

    return ans
}

private fun largestRectangleArea(heights: IntArray): Int {

    val size = heights.size
    val next: IntArray = nextSmallerElements(heights, size)
    val prev: IntArray = prevSmallerElements(heights, size)

    var area: Int = Int.MIN_VALUE

    for (i in 0 ..< size) {
        val length = heights[i]

        if (next[i] == -1) {
            next[i] = size
        }

        val breath = next[i] - prev[i] - 1

        val newArea = length * breath

        area = Math.max(area, newArea).toInt()
    }

    return area
}

private fun nextSmallerElements(arr: IntArray, size: Int): IntArray {

    val s: Stack<Int> = Stack()
    s.push(-1)

    val ans = IntArray(size)

    for (i in size - 1 downTo 0) {

        while (s.peek() != -1 && arr[s.peek()] >= arr[i]) {
            s.pop()
        }

        ans[i] = s.peek()

        s.push(i)
    }

    return ans
}

private fun prevSmallerElements(arr: IntArray, size: Int): IntArray {

    val s: Stack<Int> = Stack()
    s.push(-1)

    val ans = IntArray(size)

    for (i in 0 ..< size) {

        while (s.peek() != -1 && arr[s.peek()] >= arr[i]) {
            s.pop()
        }

        ans[i] = s.peek()

        s.push(i)
    }

    return ans
}










