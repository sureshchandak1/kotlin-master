package stacks_and_queues

import java.util.Stack

fun main() {
    val stack: Stack<Int> = Stack()

    stack.push(1); stack.push(2); stack.push(3)
    stack.push(4); stack.push(5); stack.push(6)

    println(stack.toString())

    findStackMiddle(stack)

    println(stack.toString())
}

private fun findStackMiddle(s: Stack<Int>) {
    val size = s.size

    if (size == 1) {
        println("Middle = ${s.peek()}")
        return
    }

    val mid = size / 2

    middle(s, 0, mid)

}

private fun middle(s: Stack<Int>, count: Int, mid: Int) {

    if (count == mid) {
        println("Middle = ${s.peek()}")
        return
    }

    val top = s.pop()

    middle(s, count + 1, mid)

    s.push(top)

}



