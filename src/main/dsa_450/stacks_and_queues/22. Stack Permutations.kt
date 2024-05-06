package stacks_and_queues

import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/stack-permutations/1
 *    Expected Time Complexity: O(N)
 *    Space Complexity: O(N)
 */
fun main() {
    var ip = intArrayOf(1, 2, 3)
    var op = intArrayOf(2, 1, 3)
    println(isStackPermutation(ip.size, ip, op))

    ip = intArrayOf(4, 5, 6, 7, 8); op = intArrayOf(8, 7, 6, 5, 4)
    println(isStackPermutation(ip.size, ip, op))

    ip = intArrayOf(1, 2, 3); op = intArrayOf(3, 1, 2)
    println(isStackPermutation(ip.size, ip, op))
}

private fun isStackPermutation(n: Int, ip: IntArray, op: IntArray): Int {

    val stack: Stack<Int> = Stack<Int>()

    var j = 0

    for (i in 0..<n) {
        stack.push(ip[i])

        // pop element from stack if match in output array
        while (!stack.isEmpty() && stack.peek() == op[j]) {
            stack.pop()

            j++
        }
    }

    if (stack.isEmpty()) {
        return 1
    }

    return 0
}