package lecture057_Stack_Questions

import java.util.*

/*
*    The Celebrity Problem
*
* */

fun main() {
    var matrix = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0)
    )

    println(celebrity(matrix, 3))

    matrix = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0)
    )

    println(celebrity(matrix, 2))
}

//Function to find if there is a celebrity in the party or not.
private fun celebrity(m: Array<IntArray>, n: Int): Int {

    val s = Stack<Int>()
    // Step:1 Push all element in stack
    for (i in 0..< n) {
        s.push(i)
    }


    // Step:2
    var a = 0
    var b = 0

    while (s.size > 1) {
        a = s.pop()
        b = s.pop()

        if (knows(m, a, b, n)) {
            s.push(b)
        } else {
            s.push(a)
        }
    }


    // Step:3 Single element in stack is potential celebrity
    val ans = s.peek()

    var zeroCount = 0
    var oneCount = 0

    for (i in 0..< n) {
        if (m[ans][i] == 0) {
            zeroCount++
        }
        if (m[i][ans] == 1) {
            oneCount++
        }
    }

    if (zeroCount != n) {
        return -1
    }

    if (oneCount != n - 1) {
        return -1
    }

    return ans
}

private fun knows(m: Array<IntArray>, a: Int, b: Int, n: Int): Boolean {
    return if (m[a][b] == 1) {
        true
    } else {
        false
    }
}