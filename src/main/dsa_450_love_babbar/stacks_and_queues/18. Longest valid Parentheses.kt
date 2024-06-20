package stacks_and_queues

import java.util.*
import kotlin.math.max

/**
 *    https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1
 *    Time Complexity: O(N)
 *    Space Complexity: O(N)
 */
fun main() {
    println(maxLength("((()"))
    println(maxLength(")()())"))
    println(maxLength("()(())("))
}

private fun maxLength(str: String): Int {

    val s = Stack<Int>() // store position

    for (i in str.indices) {

        if (str[i] == '(') {
            s.push(i)
        } else {
            if (!s.isEmpty() && str[s.peek()] == '(') {
                s.pop()
            } else {
                s.push(i)
            }
        }
    }

    var result = 0
    var last = str.length

    while (!s.isEmpty()) {
        val top = s.pop()

        val newResult =  last - top - 1 // last - top - 1
        result = max(result.toDouble(), newResult.toDouble()).toInt()

        last = top
    }

    return max(result.toDouble(), last.toDouble()).toInt()
}




