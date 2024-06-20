package stacks_and_queues

import java.util.*

/**
 *    https://leetcode.com/problems/implement-stack-using-queues/description/
 *    https://www.geeksforgeeks.org/problems/stack-using-two-queues/1
 */
fun main() {
    val q1 = QueueStack1()
    val q2 = QueueStack2()

    q1.push(10)
    q1.push(20)
    q1.push(30)
    q1.print()
    q1.pop()
    q1.print()

    q2.push(10)
    q2.push(20)
    q2.push(30)
    q2.print()
    q2.pop()
    q2.print()
}

private class QueueStack1 {

    private var q1: Queue<Int> = LinkedList()
    private var q2: Queue<Int> = LinkedList()

    fun push(x: Int) {

        // Insert in q2
        q2.add(x)

        // Insert all q1 element into q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove())
        }

        // Swap q1 q2
        val q: Queue<Int> = q1
        q1 = q2
        q2 = q
    }

    fun pop(): Int {
        if (q1.isEmpty()) {
            return -1
        }

        return q1.remove()
    }

    fun top(): Int {
        if (q1.isEmpty()) {
            return -1
        }
        return q1.peek()
    }

    fun empty(): Boolean {
        return q1.isEmpty()
    }

    fun print() {
        println(q1.toString())
    }
}

private class QueueStack2 {

    private val q: Queue<Int> = LinkedList()

    fun push(x: Int) {
        q.add(x)
        for (i in 1..<q.size) {
            q.add(q.remove())
        }
    }

    fun pop(): Int {
        return q.remove()
    }

    fun top(): Int {
        return q.peek()
    }

    fun empty(): Boolean {
        return q.isEmpty()
    }

    fun print() {
        println(q.toString())
    }
}







