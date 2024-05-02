package stacks_and_queues

import printArray

/**
 *   https://www.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1
 */
fun main() {
    val s = TwoStack(6)

    s.push1(1)
    s.push1(2)
    s.push2(1)
    s.push2(2)
    s.push1(3)
    s.push2(3)
    s.pop1()
    s.push1(10)
    s.push1(20) // array is full, not any empty space
    s.pop2()
    s.push2(30)
    s.push2(40) // array is full, not any empty space

    s.print()
}

private class TwoStack(private val size: Int) {

    val arr = IntArray(size)
    var top1 = -1
    var top2 = size

    // push in stack 1
    fun push1(data: Int) {
        if (top2 - top1 > 1) {
            top1++
            arr[top1] = data
        }
    }

    // push in stack 2
    fun push2(data: Int) {
        if (top2 - top1 > 1) {
            top2--
            arr[top2] = data
        }
    }

    // pop from stack 1
    fun pop1(): Int {
        if (top1 >= 0) {
            val value = arr[top1]
            arr[top1] = -1
            top1--
            return value
        }
        return -1
    }

    // pop from stack 2
    fun pop2(): Int {
        if (top2 < size) {
            val value = arr[top2]
            arr[top2] = -1
            top2++
            return value
        }
        return -1
    }

    fun print() {
        printArray(arr)
    }
}