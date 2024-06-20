package stacks_and_queues

import printArray

fun main() {
    val deque = Deque(5)

    deque.pushFront(10)
    deque.pushFront(20)
    deque.pushFront(30)
    deque.pushRear(40)
    deque.pushRear(50)

    deque.print()
}

private class Deque(n: Int) {

    private val arr = IntArray(n)
    private var front: Int
    private var rear: Int
    private val size: Int

    init {
        front = -1
        rear = -1
        size = n
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    fun pushFront(x: Int): Boolean {

        if (isFull()) {
            // Queue is full
            return false
        } else if (isEmpty()) {
            // first element to push
            rear = 0
            front = 0
        } else if (front == 0 && rear != size - 1) {
            front = size - 1
        } else {
            front--
        }

        arr[front] = x

        return true
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    fun pushRear(x: Int): Boolean {
        if (isFull()) {
            // Queue is full
            return false
        } else if (isEmpty()) {
            // first element to push
            rear = 0
            front = 0
        } else if (rear == size - 1 && front != 0) {
            rear = 0 // to maintain cyclic nature
        } else {
            rear++
        }

        arr[rear] = x

        return true
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    fun popFront(): Int {
        if (isEmpty()) {
            // Queue is empty
            return -1
        }

        val value = arr[front]
        arr[front] = -1

        when (front) {
            rear -> {
                // Single element in queue
                front = -1
                rear = -1
            }
            size - 1 -> {
                front = 0 // to maintain cyclic nature
            }
            else -> {
                front++
            }
        }

        return value
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    fun popRear(): Int {
        if (isEmpty()) {
            // Queue is empty
            return -1
        }

        val value = arr[rear]
        arr[rear] = -1

        if (front == rear) {
            // Single element in queue
            front = -1
            rear = -1
        } else if (rear == 0) {
            rear = size - 1 // to maintain cyclic nature
        } else {
            rear--
        }

        return value
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    fun getFront(): Int {
        if (isEmpty()) {
            return -1
        }

        return arr[front]
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    fun getRear(): Int {
        if (isEmpty()) {
            return -1
        }

        return arr[rear]
    }

    fun isEmpty(): Boolean {
        if (front == -1) {
            return true
        } else {
            return false
        }
    }

    fun isFull(): Boolean {
        if ((front == 0 && rear == size - 1) ||
            (front != 0 && rear == (front - 1) % (size - 1))
        ) {
            // Queue is full
            return true
        } else {
            return false
        }
    }

    fun print() {
        printArray(arr)
    }
}