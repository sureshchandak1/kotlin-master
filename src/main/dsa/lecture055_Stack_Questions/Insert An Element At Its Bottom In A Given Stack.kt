package lecture055_Stack_Questions

import java.util.*


fun main() {

}

private fun pushAtBottom(myStack: Stack<Int>, x: Int): Stack<Int> {

    if (myStack.empty()) {
        myStack.push(x)
        return myStack
    }

    pushBottom(myStack, x)

    return myStack
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