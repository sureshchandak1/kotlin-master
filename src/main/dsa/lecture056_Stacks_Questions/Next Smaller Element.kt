package lecture056_Stacks_Questions

import printArray
import java.util.*


fun main() {
    printArray(nextSmallerElement(arrayListOf(2, 1, 4, 3), 4))
    printArray(nextSmallerElement(arrayListOf(2, 1, 4, 2, 3), 5))
    printArray(nextSmallerElement(arrayListOf(1, 3, 2), 3))
    printArray(nextSmallerElement(arrayListOf(1, 2, 3, 4), 4))
}

private fun nextSmallerElement(arr: ArrayList<Int>, n: Int): ArrayList<Int> {

    val stack = Stack<Int>()
    stack.push(-1)

    val ans = ArrayList<Int>(n)
    for (i in 0..< n) {
        ans.add(0)
    }

    for (i in n - 1 downTo 0) {
        val curr = arr[i]

        while (stack.peek() >= curr) {
            stack.pop()
        }

        ans[i] = stack.peek()

        stack.push(curr)
    }

    return ans
}