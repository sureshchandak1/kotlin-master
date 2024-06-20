package lecture055_Stack_Questions

import java.util.*


fun main() {
    println(isValidParenthesis("[()]{}{[()()]()}"))
    println(isValidParenthesis("[[}["))
    println(isValidParenthesis("[(])"))
}

private fun isValidParenthesis(s: String): Boolean {

    val size = s.length

    val stack = Stack<Char>()

    for (i in 0..< size) {

        val ch = s[i]

        if (ch == '{' || ch == '(' || ch == '[') {
            stack.push(ch)
        } else {
            if (!stack.empty()) {
                val stackTop = stack.peek()

                if ((ch == '}' && stackTop == '{') ||
                    (ch == ')' && stackTop == '(') ||
                    (ch == ']' && stackTop == '[')
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

    return if (stack.empty()) {
        true
    } else {
        false
    }
}