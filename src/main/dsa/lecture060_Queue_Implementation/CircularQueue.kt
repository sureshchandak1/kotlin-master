package lecture060_Queue_Implementation

fun main() {
    val queue = CircularQueue(6)
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    queue.enqueue(40)
}

class CircularQueue internal constructor(n: Int) {

    private val arr = IntArray(n)
    private var front: Int
    private var rear: Int
    private val size: Int

    init {
        front = -1
        rear = -1
        size = n
    }

    /*
	   Enqueues 'X' into the queue. Returns true if it gets pushed into the stack,
	   and false otherwise.
	*/
    fun enqueue(value: Int): Boolean {

        if ((front == 0 && rear == size - 1) ||
            (rear == (front - 1) % (size - 1))
        ) {
            // Queue is full
            return false
        } else if (front == -1) {
            // first element to push
            rear = 0
            front = 0
        } else if (rear == size - 1 && front != 0) {
            rear = 0 // to maintain cyclic nature
        } else {
            rear++
        }

        arr[rear] = value

        return true
    }

    /*
	  Dequeues top element from queue. Returns -1 if the stack is empty, otherwise
	  returns the popped element.
	*/
    fun dequeue(): Int {
        if (front == -1) {
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
}