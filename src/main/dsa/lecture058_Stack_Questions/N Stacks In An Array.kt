package lecture058_Stack_Questions

import printArray

fun main() {
    val nStack = NStack(3, 6)
    nStack.push(10, 1)
    nStack.push(20, 1)
    nStack.push(30, 2)
    nStack.print()
    nStack.pop(1)
    nStack.print()
    nStack.pop(2)
    nStack.print()
}

// n = number of stacks
// s = size of array
private class NStack(n: Int, s: Int) {

    private val arr = IntArray(s) { 0 }
    private val top = IntArray(n)
    private val next = IntArray(s)

    private var freespot: Int

    init {
        // top initialise
        for (i in 0..< n) {
            top[i] = -1
        }

        // next initialise
        for (i in 0..< s) {
            next[i] = i + 1
        }
        // update last index
        next[s - 1] = -1

        // freeSpot
        freespot = 0
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    fun push(x: Int, m: Int): Boolean {
        // Check for overflow
        if (freespot == -1) {
            return false
        }

        // find index
        val index = freespot

        // insert element into array
        arr[index] = x

        // update freeSpot
        freespot = next[index]

        // update next
        next[index] = top[m - 1]

        // update top
        top[m - 1] = index

        return true
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    fun pop(m: Int): Int {
        if (top[m - 1] == -1) {
            return -1
        }

        val index = top[m - 1]

        top[m - 1] = next[index]

        next[index] = freespot

        freespot = index

        arr[index] = 0

        return arr[index]
    }

    fun print() {
        printArray(arr)
    }
}