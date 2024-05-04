package stacks_and_queues

import printStack
import java.util.Stack

/**
 *   https://www.geeksforgeeks.org/problems/reverse-a-stack/1
 *   Time Complexity: O(N * N), where N is size of stack
 *   Space Complexity: O(1)
 */
fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)

    printStack(stack)
    reverseStack(stack)
    printStack(stack)
}

private fun reverseStack(stack: Stack<Int>) {

    if (stack.isEmpty()) {
        return
    }

    val topElement = stack.pop()

    reverseStack(stack)

    pushBottom(stack, topElement)
}

private fun pushBottom(stack: Stack<Int>, data: Int) {

    if (stack.isEmpty()) {
        stack.push(data)
        return
    }

    val topElement = stack.pop()

    pushBottom(stack, data)

    stack.push(topElement)
}



