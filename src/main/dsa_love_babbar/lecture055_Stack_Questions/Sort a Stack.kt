package lecture055_Stack_Questions

import java.util.*


fun main() {
    val stack = Stack<Int>()

    stack.push(5)
    stack.push(-2)
    stack.push(2)
    stack.push(7)
    stack.push(-6)
    stack.push(9)

    println(stack.toString())

    sortStack(stack)

    println(stack.toString())
}

private fun sortStack(stack: Stack<Int>) {

    // Base case
    if (stack.empty()) {
        return
    }

    val top = stack.pop()

    // Recursive call
    sortStack(stack)

    sortedInsert(stack, top)
}

private fun sortedInsert(stack: Stack<Int>, num: Int) {

    // Base case
    if (stack.empty() || stack.peek() < num) {
        stack.push(num)
        return
    }

    val top = stack.pop()

    // Recursive call
    sortedInsert(stack, num)

    stack.push(top)
}