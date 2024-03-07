package lecture055_Stack_Questions

import java.util.*


fun main() {
    val stack = Stack<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)
    stack.push(6)

    println(stack.toString())

    reverseStack(stack)

    println(stack.toString())
}

private fun reverseStack(stack: Stack<Int>) {
    solve(stack)
}

private fun solve(stack: Stack<Int>) {

    // Base case
    if (stack.empty()) {
        return
    }

    val top = stack.pop()

    // Recursive call
    solve(stack)

    pushBottom(stack, top)
}

private fun pushBottom(myStack: Stack<Int>, x: Int) {

    // Base case
    if (myStack.empty()) {
        myStack.push(x)
        return
    }


    val topElement = myStack.pop()

    // Recursive call
    pushBottom(myStack, x)

    myStack.push(topElement)
}