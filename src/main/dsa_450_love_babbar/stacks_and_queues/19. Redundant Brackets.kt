package stacks_and_queues

import java.util.*

/**
 *    Time Complexity: O(N)
 *    Space Complexity: O(N)
 */
fun main() {
    println(findRedundantBrackets("(a+b)"))
    println(findRedundantBrackets("(a+c*b)+(c))"))
}

private fun findRedundantBrackets(s: String): Boolean {

    val size = s.length

    val stack = Stack<Char>()

    for (i in 0..< size) {
        val ch = s[i]

        if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            stack.push(ch)
        } else {
            if (ch == ')') {
                var isRedundant = true

                while (stack.peek() != '(') {
                    val top = stack.peek()

                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isRedundant = false
                    }

                    stack.pop()
                }

                if (isRedundant) {
                    return true
                }

                stack.pop()
            }
        }
    }

    return false
}



