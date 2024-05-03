package stacks_and_queues

import java.util.Stack

/**
 *   https://www.geeksforgeeks.org/problems/special-stack/1
 *   Time Complexity: O(1)
 *   Space Complexity: O(1)
 */
fun main() {
    val stack = MinStack()
    stack.push(20)
    stack.push(2)
    stack.push(1)
    println("Top = ${stack.top()}")
    println("Top = ${stack.top()}")
    println("Min = ${stack.getMin()}")
    stack.pop()
    println("Min = ${stack.getMin()}")
    stack.pop()
    stack.push(214)
    println("Top = ${stack.top()}")
    println("Min = ${stack.getMin()}")
    stack.push(-2)
    println("Top = ${stack.top()}")
    println("Min = ${stack.getMin()}")
    stack.pop()
    println("Min = ${stack.getMin()}")
}

private class MinStack {

    private val s: Stack<Int> = Stack()
    private var mini = 0

    fun push(data: Int) {
        if (s.empty()) {
            s.push(data)
            mini = data
        } else {
            if (data < mini) {
                s.push(2 * data - mini)
                mini = data
            } else {
                s.push(data)
            }
        }
    }

    fun pop() {
        if (s.empty()) {
            return
        }

        val top = s.pop()

        if (top > mini) {
            return
        } else {
            val value = 2 * mini - top
            mini = value
        }
    }

    fun top(): Int {
        if (s.empty()) {
            return -1
        }

        val top = s.peek()

        if (top > mini) {
            return top
        } else {
            return mini
        }
    }

    fun getMin(): Int {
        if (s.empty()) {
            return -1
        }

        return mini
    }
}




