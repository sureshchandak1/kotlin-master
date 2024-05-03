package stacks_and_queues

import printArray

fun main() {
    val nStack = NStack(stacks = 3, size = 6)
    nStack.push(10, 1)
    nStack.push(20, 1)
    nStack.push(30, 2)
    nStack.print()
    nStack.pop(1)
    nStack.print()
    nStack.pop(2)
    nStack.print()
}

/**
 * @param stacks = number of stacks
 * @param size = size of stack array
 */
private class NStack(stacks: Int, size: Int) {

    private val arr = IntArray(size) { 0 }
    private val top = IntArray(stacks) { -1 } // default value -1
    private val next = IntArray(size)
    private var freespot = 0

    init {
        for (i in 0 ..<size) {
            next[i] = i + 1
        }
        next[size - 1] = -1
    }

    fun push(data: Int, stack: Int): Boolean {
        if (freespot == -1) { // Check for overflow
            return false
        }

        val index = freespot // find index

        arr[index] = data // insert element into array

        freespot = next[index] // update freeSpot

        next[index] = top[stack - 1] // update next

        top[stack - 1] = index // update top

        return true
    }

    fun pop(stack: Int): Int {
        if (top[stack - 1] == -1) { // empty stack
            return -1
        }

        val index = top[stack - 1]

        top[stack - 1] = next[index]

        next[index] = freespot

        freespot = index

        arr[index] = 0

        return arr[index]
    }

    fun peek(stack: Int): Int {
        if (top[stack - 1] == -1) { // empty stack
            return -1
        }

        val index = top[stack - 1]

        return arr[index]
    }

    fun print() {
        printArray(arr)
    }
}






