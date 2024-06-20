package stacks_and_queues

import printArray
import java.util.*

/**
 *   https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 *   Time Complexity : O(N), where N is size of array
 *   Space Complexity: O(N)
 */
fun main() {
    var arr = longArrayOf(1, 3, 2, 4)
    printArray(nextLargerElement(arr, arr.size))

    arr = longArrayOf(6, 8, 0, 1, 3)
    printArray(nextLargerElement(arr, arr.size))
}

private fun nextLargerElement(arr: LongArray, n: Int): LongArray {

    val ans = LongArray(n)

    val s = Stack<Long>()

    for (i in n - 1 downTo 0) {

        while (!s.empty() && s.peek() <= arr[i]) {
            s.pop()
        }

        if (s.empty()) {
            ans[i] = -1
        } else {
            ans[i] = s.peek()
        }

        s.push(arr[i])
    }

    return ans
}



