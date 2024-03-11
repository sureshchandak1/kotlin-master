package lecture059_Stack_Questions

import java.util.*


/*
*   Design a stack that supports getMin() in O(1) time and O(1) extra
* */

fun main() {
    val stack = SpecialStack()
    stack.push(5)
    stack.push(3)
    stack.push(7)
    stack.push(2)
    println("Min = ${stack.min}")
    stack.pop()
    println("Top = ${stack.top()}")
    stack.pop()
    println("Top = ${stack.top()}")
    println("Min = ${stack.min}")
}

private class SpecialStack {

    private val s = Stack<Int>()
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

        val curr = s.pop()

        if (curr > mini) {
            return
        } else {
            val prevMini = mini
            val `val` = 2 * mini - curr
            mini = `val`
        }
    }

    fun top(): Int {
        if (s.empty()) {
            return -1
        }

        val curr = s.peek()

        return if (curr < mini) {
            mini
        } else {
            curr
        }
    }

    val min: Int
        get() {
            if (s.empty()) {
                return -1
            }

            return mini
        }
}