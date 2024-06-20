package lecture057_Stack_Questions

import java.util.*
import kotlin.math.max


fun main() {
    var matrix = arrayOf(
        intArrayOf(0, 1, 1, 0),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 0, 0)
    )

    println(maxArea(matrix, 4, 4))

    matrix = arrayOf(
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(1, 1, 1, 0)
    )

    println(maxArea(matrix, 4, 4))
}

private fun maxArea(M: Array<IntArray>, n: Int, m: Int): Int {
    var area = largestRectangleArea(M[0], m)

    for (i in 1..<n) {
        for (j in 0..<m) {
            if (M[i][j] != 0) {
                M[i][j] = M[i][j] + M[i - 1][j]
            } else {
                M[i][j] = 0
            }
        }

        area = max(area.toDouble(), largestRectangleArea(M[i], m).toDouble()).toInt()
    }

    return area
}

private fun largestRectangleArea(heights: IntArray, size: Int): Int {

    val next = nextSmallerElements(heights, size)
    val prev = prevSmallerElements(heights, size)

    var area = Int.MIN_VALUE

    for (i in 0..<size) {
        val l = heights[i]

        if (next[i] == -1) {
            next[i] = size
        }

        val b = next[i] - prev[i] - 1

        val newArea = l * b

        area = max(area.toDouble(), newArea.toDouble()).toInt()
    }

    return area
}

private fun nextSmallerElements(arr: IntArray, n: Int): IntArray {
    val stack = Stack<Int>()
    stack.push(-1)

    val ans = IntArray(n)

    for (i in n - 1 downTo 0) {
        val curr = arr[i]

        while (stack.peek() != -1 && arr[stack.peek()] >= curr) {
            stack.pop()
        }

        ans[i] = stack.peek()

        stack.push(i)
    }

    return ans
}

private fun prevSmallerElements(arr: IntArray, n: Int): IntArray {
    val stack = Stack<Int>()
    stack.push(-1)

    val ans = IntArray(n)

    for (i in 0..<n) {
        val curr = arr[i]

        while (stack.peek() != -1 && arr[stack.peek()] >= curr) {
            stack.pop()
        }

        ans[i] = stack.peek()

        stack.push(i)
    }

    return ans
}



