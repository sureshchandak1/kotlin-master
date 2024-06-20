package stacks_and_queues

fun main() {
    val stack = StackLinkedList()

    stack.push(10)

    stack.print()

    println("Pop element = ${stack.pop()?.data}")
    stack.print()

    stack.push(10)
    stack.push(20)

    stack.print()
    println("Peek element = ${stack.peek()?.data}")
    println("Pop element = ${stack.pop()?.data}")
    stack.print()

    println("Pop element = ${stack.pop()?.data}")
    stack.print()
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
        // stack is empty
        if (head == null) {
            return null
        }
        // contain only single element
        if (head?.next == null) {
            val temp = head
            head = null
            tail = null
            return temp
        }

        var prev: StackNode? = null
        var curr: StackNode? = head

        while (curr != null && curr.next != null) {
            prev = curr
            curr = curr.next
        }

        prev?.next = null
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
            print(curr.data)
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