package stacks_and_queues

import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
 *    Time Complexity: O(N)
 *    Space Complexity: O(N)
 */
fun main() {
    println(evaluatePostfix1("231*+9-"))
    println(evaluatePostfix1("123+*8-"))
    println(evaluatePostfix2("100 200 + 2 / 5 * 7 +"))
}

private fun evaluatePostfix1(exp: String): Int {

    val length = exp.length
    val stack: Stack<Int> = Stack()

    var index = 0
    while (index < length) {
        val ch = exp[index]

        if (ch == ' ') {
            index++
            continue
        }

        if (isDigit(ch)) {
            stack.push(ch - '0')
        } else {
            val val1 = stack.pop()
            val val2 = stack.pop()

            when (ch) {
                '+' -> { stack.push(val2 + val1) }
                '-' -> { stack.push(val2 - val1) }
                '*' -> { stack.push(val2 * val1) }
                '/' -> { stack.push(val2 / val1) }
            }
        }

        index++
    }

    return stack.pop()
}

private fun evaluatePostfix2(exp: String): Int {

    val length = exp.length
    val stack: Stack<Int> = Stack()

    var index = 0
    while (index < length) {
        var ch = exp[index]

        if (ch == ' ') {
            index++
            continue
        }

        if (isDigit(ch)) {
            var num = 0

            while (isDigit(ch)) {
                num = num * 10 + (ch - '0')
                index++
                ch = exp[index]
            }
            index--

            stack.push(num)
        } else {
            val val1 = stack.pop()
            val val2 = stack.pop()

            when (ch) {
                '+' -> { stack.push(val2 + val1) }
                '-' -> { stack.push(val2 - val1) }
                '*' -> { stack.push(val2 * val1) }
                '/' -> { stack.push(val2 / val1) }
            }
        }

        index++
    }

    return stack.pop()
}

private fun isDigit(ch: Char): Boolean {
    return ch in '0'..'9'
}



