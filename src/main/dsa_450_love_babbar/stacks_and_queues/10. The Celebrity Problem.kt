package stacks_and_queues

import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
 *    Time Complexity : O(N), where N is size of array
 *    Space Complexity: O(N)
 */
fun main() {
    var matrix = arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 0), intArrayOf(0, 1, 0))
    println(celebrity(matrix, 3))

    matrix = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
    println(celebrity(matrix, 2))
}

private fun celebrity(m: Array<IntArray>, n: Int): Int {

    val s = Stack<Int>()
    // Step:1 Push all celebrity in stack (0 to n - 1)
    for (i in 0..< n) {
        s.push(i)
    }

    // Step:2 find celebrity
    var a = 0; var b = 0

    while (s.size > 1) {
        a = s.pop()
        b = s.pop()

        if (m[a][b] == 1) {
            s.push(b)
        } else if (m[b][a] == 1) {
            s.push(a)
        }
    }

    // Step:3 Single element in stack is potential celebrity
    val ans = s.peek()

    var zeroCount = 0 ; var oneCount = 0

    for (i in 0..< n) {
        if (m[ans][i] == 0) {
            zeroCount++
        }
        if (m[i][ans] == 1) {
            oneCount++
        }
    }

    if (zeroCount != n || oneCount != n - 1) {
        return -1
    }

    return ans
}





