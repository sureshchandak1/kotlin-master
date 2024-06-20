package stacks_and_queues

import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1
 *    Time Complexity: O(N), where N is size of string
 *    Space Complexity: O(N)
 */
fun main() {
    println(isValid("[()]{}{[()()]()}"))
    println(isValid("[(])"))
    println(isValid("{([])}"))
    println(isValid("()"))
    println(isValid(")"))
    println(isValid("([]"))
}

private fun isValid(str: String): Boolean {

    val size = str.length
    val stack = Stack<Char>()

    for (i in 0..<size) {
        val ch = str[i]

        if (ch == '{' || ch == '(' || ch == '[') {
            stack.push(ch)
        } else {
            if (!stack.empty()) {
                val top = stack.peek()

                if ((ch == '}' && top == '{') ||
                    (ch == ')' && top == '(') ||
                    (ch == ']' && top == '[')
                ) {
                    stack.pop()
                } else {
                    return false
                }
            } else {
                return false
            }
        }
    }

    return stack.empty()
}












