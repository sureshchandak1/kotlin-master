package lecture055_Stack_Questions

import java.util.Stack

fun main() {
    var str = "love"
    println(reverseString(str))

    str = "ramesh"
    println(reverseString(str))
}

private fun reverseString(str: String): String {

    val size = str.length
    val stack: Stack<Char> = Stack()

    for (i in 0 ..< size) {
        stack.push(str[i])
    }

    var ans = ""
    while (!stack.empty()) {
        ans += stack.pop()
    }

    return ans

}