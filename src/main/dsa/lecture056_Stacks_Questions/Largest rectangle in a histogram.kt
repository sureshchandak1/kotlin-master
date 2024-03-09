package lecture056_Stacks_Questions

import java.util.*
import kotlin.math.max


fun main() {
    println(largestRectangle(arrayListOf(1, 0, 1, 2, 2, 2, 2, 1, 0, 2)))
    println(largestRectangle(arrayListOf(1, 2, 1, 0, 1, 1, 0, 0, 2, 2)))
    println(largestRectangle(arrayListOf(8, 6, 3, 5, 0, 0, 4, 10, 2, 5)))
    println(largestRectangle(arrayListOf(6, 1, 8, 10, 5, 7, 0, 4, 5, 8)))
    println(largestRectangle(arrayListOf(2, 2, 2, 2, 2, 2, 2)))
    println(largestRectangle(arrayListOf(2)))
    println(largestRectangle(arrayListOf(2, 2)))
}

private fun largestRectangle(heights: ArrayList<Int>): Int {

    val size = heights.size

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

private fun nextSmallerElements(arr: ArrayList<Int>, n: Int): ArrayList<Int> {
    val stack = Stack<Int>()
    stack.push(-1)

    val ans = ArrayList<Int>(n)
    for (i in 0..<n) {
        ans.add(0)
    }

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

private fun prevSmallerElements(arr: ArrayList<Int>, n: Int): ArrayList<Int> {
    val stack = Stack<Int>()
    stack.push(-1)

    val ans = ArrayList<Int>(n)
    for (i in 0..<n) {
        ans.add(0)
    }

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



