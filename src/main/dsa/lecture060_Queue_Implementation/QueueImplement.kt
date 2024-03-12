package lecture060_Queue_Implementation

fun main() {
    val queueArray = QueueArray(100)
    queueArray.enqueue(10)
    queueArray.enqueue(20)
    queueArray.enqueue(30)
    queueArray.enqueue(40)
    queueArray.enqueue(50)

    queueArray.print()

    println("Front = ${queueArray.front()}")

    println("Dequeue = ${queueArray.dequeue()}")
    println("Dequeue = ${queueArray.dequeue()}")

    queueArray.print()

    println("Front = ${queueArray.front()}")

    queueArray.print()
}

class QueueArray internal constructor(s: Int) {

    private val arr: IntArray
    private var front: Int
    private var rear: Int
    private val size = s

    init {
        arr = IntArray(size)
        front = 0
        rear = 0
    }

    fun isEmpty(): Boolean {
        return front == rear
    }

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