package stacks_and_queues

import printStack
import java.util.*

/**
 *     https://leetcode.com/problems/implement-queue-using-stacks/
 *     https://www.geeksforgeeks.org/problems/queue-using-two-stacks/1
 *     Space Complexity: O(N)
 */
fun main() {
    val q = StackQueue()
    q.push(10)
    q.push(20)
    q.push(30)
    q.print()
    println("Pop = ${q.pop()}")
    q.print()
    println("Peek = ${q.peek()}")
    println("Pop = ${q.pop()}")
    q.print()
}

private class StackQueue {

    private val s1: Stack<Int> = Stack()
    private val s2: Stack<Int> = Stack()

    // Time Complexity: O(N)
    fun push(x: Int) {

        while (!s1.isEmpty()) {
            s2.push(s1.pop())
        }

        s1.push(x)

        while (!s2.isEmpty()) {
            s1.push(s2.pop())
        }
    }

    // Time Complexity: O(1)
    fun pop(): Int {
        if (s1.isEmpty()) {
            return -1
        }

        return s1.pop()
    }

    // Time Complexity: O(1)
    fun peek(): Int {
        if (s1.isEmpty()) {
            return -1
        }

        return s1.peek()
    }

    fun empty(): Boolean {
        return s1.isEmpty()
    }

    fun print() {
        printStack(s1)
    }
}








