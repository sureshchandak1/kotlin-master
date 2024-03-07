import java.util.*

fun main() {
    println(checkParentheses("()"))
    println(checkParentheses("()[]{}"))
    println(checkParentheses("(]"))
    println(checkParentheses("{[]}"))
    println(checkParentheses("{(]}"))
    println(checkParentheses("{[]}"))
}

private fun checkParentheses(s: String): Boolean {

    val size = s.length

    val stack = Stack<Char>()

    for (i in 0 ..< size) {

        val ch = s[i]

        if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch)
        } else {

            if (!stack.empty()) {
                val top = stack.peek()

                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
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

    if (stack.empty()) {
        return true
    } else {
        return false
    }
}

