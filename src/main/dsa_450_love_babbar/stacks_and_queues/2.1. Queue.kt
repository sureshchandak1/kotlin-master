package stacks_and_queues

fun main() {
    val q = Queue(3)
    q.enqueue(10)
    q.enqueue(20)
    q.enqueue(30)
    q.print()
    q.dequeue()
    q.print()
    q.dequeue()
    q.print()
    q.dequeue()
    q.print()
    q.enqueue(10)
    q.enqueue(20)
    q.print()

}

private class Queue(private val size: Int) {

    private val arr = IntArray(size)
    private var front = 0
    private var rear = 0

    // push
    fun enqueue(data: Int) {
        if (rear == size) {
            return
        } else {
            arr[rear] = data
            rear++
        }
    }

    // pop
    fun dequeue(): Int {
        if (front == rear) {
            return -1
        } else {
            val value = arr[front]
            arr[front] = -1
            front++
            if (front == rear) {
                front = 0
                rear = 0
            }
            return value
        }
    }

    fun front(): Int {
        return if (front == rear) {
            -1
        } else {
            arr[front]
        }
    }

    fun isEmpty(): Boolean {
        return front == rear
    }

    fun print() {
        print("[")
        for (i in front ..< rear) {
            print(arr[i])
            if (i != rear - 1) {
                print(", ")
            }
        }
        print("]")
        println()
    }
}