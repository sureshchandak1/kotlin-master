package lecture056_Stacks_Questions

import printArray
import java.util.*


fun main() {
    printArray(prevSmallerElements(arrayListOf(2, 1, 4, 3), 4))
    printArray(prevSmallerElements(arrayListOf(2, 1, 4, 2, 3), 5))
    printArray(prevSmallerElements(arrayListOf(1, 3, 2), 3))
    printArray(prevSmallerElements(arrayListOf(1, 2, 3, 4), 4))
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

        while (stack.peek() != -1 && stack.peek() >= curr) {
            stack.pop()
        }

        ans[i] = stack.peek()

        stack.push(curr)
    }

    return ans
}