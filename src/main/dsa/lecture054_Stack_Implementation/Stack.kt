package lecture054_Stack_Implementation

import printArray

fun main() {
    val stackLinkedList = StackLinkedList()

    /*
    stackLinkedList.push(10)
    stackLinkedList.push(20)
    stackLinkedList.push(30)
    stackLinkedList.push(40)
    stackLinkedList.push(50)

    stackLinkedList.print()

    println("Pop element = ${stackLinkedList.pop()?.data}")
    stackLinkedList.print()

    println("Pop element = ${stackLinkedList.pop()?.data}")
    stackLinkedList.print()

    stackLinkedList.push(40)
    stackLinkedList.push(50)

    stackLinkedList.print()

    println("Peek element = ${stackLinkedList.peek()?.data}")

     */

    stackLinkedList.push(10)

    stackLinkedList.print()

    println("Pop element = ${stackLinkedList.pop()?.data}")
    stackLinkedList.print()

    stackLinkedList.push(10)
    stackLinkedList.push(20)

    stackLinkedList.print()

    println("Pop element = ${stackLinkedList.pop()?.data}")
    stackLinkedList.print()

    println("Pop element = ${stackLinkedList.pop()?.data}")
    stackLinkedList.print()

}

/*fun main() {
    val stackArray = StackArray(5)

    stackArray.print()
    println("Size = ${stackArray.size()}")

    stackArray.push(10)
    stackArray.print()
    println("Size = ${stackArray.size()}")

    stackArray.push(20)
    stackArray.print()
    println("Size = ${stackArray.size()}")

    stackArray.push(30)
    stackArray.print()
    println("Size = ${stackArray.size()}")

    stackArray.push(40)
    stackArray.print()
    println("Size = ${stackArray.size()}")

    stackArray.push(50)
    stackArray.print()
    println("Size = ${stackArray.size()}")

    stackArray.pop()
    stackArray.print()
    println("Size = ${stackArray.size()}")

    println("Peek = ${stackArray.peek()}")
    stackArray.print()
    println("Size = ${stackArray.size()}")
}*/

private class StackArray(private val size: Int) {

    private var top: Int = -1
    private val stack = IntArray(size) { 0 }

    fun push(data: Int) {
        if (size - top > 1) {
            top++
            stack[top] = data
        } else {
            println("Stack OverFlow")
        }
    }

    fun pop() {
        if (top >= 0) {
            top--
        } else {
            println("Stack Empty")
        }
    }

    fun peek(): Int {
        if (top >= 0) {
            return stack[top]
        } else {
            println("Stack Empty")
            return -1
        }
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun size(): Int {
        return top + 1
    }

    fun print() {
        print("[")
        for (index in 0 .. top) {
            print("${stack[index]}")
            if (index < top) {
                print(", ")
            }
        }
        print("]")
        println()
    }

}

private class StackLinkedList {

    private var head: StackNode? = null
    private var tail: StackNode? = null

    fun push(data: Int) {
        val newNode = StackNode(data)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
    }

    fun pop(): StackNode? {

        if (head == null) {
            return null
        }

        if (head?.next == null) {
            val value = head
            head = null
            tail = null
            return value
        }

        var prev: StackNode? = null
        var curr = head

        while (curr?.next != null) {
            prev = curr
            curr = curr.next
        }

        prev?.next = tail?.next
        tail = prev

        return curr

    }

    fun peek(): StackNode? {

        if (head == null) {
            return null
        }

        return tail
    }

    fun print() {
        print("[")
        var curr = head
        while (curr != null) {
            print("${curr.data}")
            if (curr.next != null) {
                print(", ")
            }

            curr = curr.next
        }
        print("]")
        println()
    }

}

private class StackNode {

    var data: Int
    var next: StackNode?

    constructor() {
        this.data = 0
        this.next = null
    }

    constructor(data: Int) {
        this.data = data
        this.next = null
    }

    constructor(data: Int, next: StackNode?) {
        this.data = data
        this.next = next
    }
}