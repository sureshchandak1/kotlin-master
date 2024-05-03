package stacks_and_queues

import java.util.Stack

/**
 *    https://www.geeksforgeeks.org/problems/reverse-a-string-using-stack/1
 *    Time Complexity: O(N), where N is size of string
 *    Space Complexity: O(N)
 */
fun main() {
    println(reverse("GeeksforGeeks"))
    println(reverse("Suresh Chandak"))
}

private fun reverse(str: String): String {

    val length = str.length

    val stack: Stack<Char> = Stack()

    for (i in 0..<length) {
        stack.push(str[i])
    }

    val ans = StringBuilder("")
    while (!stack.empty()) {
        ans.append(stack.pop())
    }

    return ans.toString()
}


