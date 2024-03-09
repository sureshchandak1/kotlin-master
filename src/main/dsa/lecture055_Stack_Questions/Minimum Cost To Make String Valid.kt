package lecture055_Stack_Questions

import java.util.*


fun main() {
    println(findMinimumCost("{{{}"))
    println(findMinimumCost("{{}{}}"))
    println(findMinimumCost("{}}{}}"))
    println(findMinimumCost("{{{{"))
    println(findMinimumCost("{{{}}"))
    println(findMinimumCost("}{}"))
    println(findMinimumCost("{}}{{}"))
    println(findMinimumCost("{{}}}{"))
}

private fun findMinimumCost(str: String): Int {

    if (str.isEmpty()) {
        return -1
    }

    val size = str.length

    if (size % 2 != 0) {
        return -1
    }

    val stack = Stack<Char>()

    for (i in 0..< size) {
        val ch = str[i]

        if (ch == '{') {
            stack.push(ch)
        } else {
            // ch is close brackets
            if (!stack.empty() && stack.peek() == '{') {
                stack.pop()
            } else {
                stack.push(ch)
            }
        }
    }

    // stack containe invalid expression
    var a = 0 // open bracket count
    var b = 0 // close bracket count

    while (!stack.empty()) {
        if (stack.peek() == '{') {
            a++
        } else {
            b++
        }

        stack.pop()
    }

    val ans = ((a + 1) / 2) + ((b + 1) / 2)

    return ans
}