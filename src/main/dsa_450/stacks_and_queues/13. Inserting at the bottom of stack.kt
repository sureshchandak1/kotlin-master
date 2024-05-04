package stacks_and_queues

import java.util.Stack

fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.toString())

    insertAtBottom(stack, 4)
    println(stack.toString())

    insertAtBottom(stack, 5)
    println(stack.toString())
}

private fun insertAtBottom(stack: Stack<Int>, data: Int) {

    // Base case
    if (stack.isEmpty()) {
        stack.push(data)
        return
    }

    val topElement = stack.pop() // pop from stack and store in variable

    insertAtBottom(stack, data) // Recursive call

    stack.push(topElement) // insert again pop element in stack
}








