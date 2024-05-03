package stacks_and_queues

import java.util.*

/**
 *   https://www.geeksforgeeks.org/problems/special-stack/1
 *   https://leetcode.com/problems/min-stack/description/
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

private class MinStack2 {

    // stk1 keeps track of all the elements in the stack.
    private val stack: Stack<Int> = Stack()

    // minValuesStack keeps track of the minimum values at each state of the stack.
    private val minValuesStack: Stack<Int> = Stack()

    init {
        // minValuesStack with the maximum value an integer can hold
        minValuesStack.push(Int.MAX_VALUE)
    }

    // Method to push an element onto the stack. Updates the minimum value as well.
    fun push(data: Int) {
        // Push the value onto the stack.
        stack.push(data)
        // Push the smaller between the current value and the current minimum onto the minValuesStack.
        minValuesStack.push(Math.min(data, minValuesStack.peek()))
    }

    // Method to remove the top element from the stack. Also updates the minimum value.
    fun pop() {
        // Remove the top element of the stack.
        stack.pop()
        // Remove the top element of the minValuesStack, which corresponds to the minimum at that state.
        minValuesStack.pop()
    }

    // Method to retrieve the top element of the stack without removing it.
    fun top(): Int {
        // Peek the top element of the stack.
        return stack.peek()
    }

    fun getMin(): Int {
        return minValuesStack.peek()
    }
}





