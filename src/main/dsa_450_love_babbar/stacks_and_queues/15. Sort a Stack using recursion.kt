package stacks_and_queues

import printStack
import java.util.Stack

/**
 *   https://www.geeksforgeeks.org/problems/sort-a-stack/1
 *   Time Complexity: O(N * N), where N is size of stack
 *   Space Complexity: O(N), recursive
 */
fun main() {
    val stack = Stack<Int>()
    stack.push(11)
    stack.push(2)
    stack.push(32)
    stack.push(3)
    stack.push(41)
    printStack(stack)

    sortStack(stack)
    printStack(stack)

}

private fun sortStack(stack: Stack<Int>) {

    // Base case
    if (stack.isEmpty()) {
        return
    }

    val topElement = stack.pop()

    sortStack(stack)

    sortedInsert(stack, topElement)
}

private fun sortedInsert(stack: Stack<Int>, num: Int) {

    // Base case
    if (stack.isEmpty() || num > stack.peek()) {
        stack.push(num)
        return
    }

    val topElement = stack.pop()

    sortedInsert(stack, num)

    stack.push(topElement)
}





