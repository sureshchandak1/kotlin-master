package lecture055_Stack_Questions

import java.util.*


fun main() {
    val stack: Stack<Int> = Stack()

    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)
    stack.push(6)

    println(stack.toString())

    deleteMiddleItem(stack, stack.size)

    println(stack.toString())
}

fun deleteMiddle(inputStack: Stack<Int>, size: Int) {
    if (size == 0) {
        return
    }

    if (size == 1) {
        inputStack.pop()
        return
    }

    var mid = size / 2
    if (size % 2 == 0) {
        mid -= 1
    }

    deleteMiddle(inputStack, 0, mid)
}

private fun deleteMiddle(inputStack: Stack<Int>, count: Int, mid: Int) {

    // Base case
    if (count == mid) {
        inputStack.pop()
        return
    }


    val topElement = inputStack.pop()

    // Recursive call
    deleteMiddle(inputStack, count + 1, mid)

    inputStack.push(topElement)
}

private fun deleteMiddleItem(inputStack: Stack<Int>, n: Int) {

    var count = 0
    val mid = n / 2

    while (count <= mid) {
        if (count == mid) {
            inputStack.removeAt(count)
        }
        count++
    }

}