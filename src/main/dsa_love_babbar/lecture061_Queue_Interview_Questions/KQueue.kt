package lecture061_Queue_Interview_Questions

/*
*  https://www.geeksforgeeks.org/efficiently-implement-k-queues-single-array/
*
* */
fun main() {
    val kQueue = KQueue(10, 3)
    kQueue.enqueue(10 ,1)
    kQueue.enqueue(15 ,1)
    kQueue.enqueue(20 ,2)
    kQueue.enqueue(25 ,1)

    println(kQueue.dequeue(1))
    println(kQueue.dequeue(2))
    println(kQueue.dequeue(1))
    println(kQueue.dequeue(1))

    println(kQueue.dequeue(1))
}
private class KQueue(n: Int, k: Int) {

    private val size: Int = n
    private val k: Int
    private val arr: IntArray
    private val front: IntArray
    private val rear: IntArray
    private val next: IntArray
    private var freeSpot: Int

    init {
        this.k = k
        arr = IntArray(n)
        front = IntArray(k)
        rear = IntArray(k)

        for (i in 0 ..< k) {
            front[i] = -1
            rear[i] = -1
        }

        next = IntArray(n)
        for (i in 0 ..< n) {
            next[i] = i + 1
        }
        next[n - 1] = -1

        freeSpot = 0
    }

    fun enqueue(data: Int, qn: Int) {

        // overflow
        if (freeSpot == -1) {
            println("Queue is full")
            return
        }

        // find first free index
        val index = freeSpot

        // update freeSpot
        freeSpot = next[index]

        // check is first time push
        if (front[qn - 1] == -1) {
            front[qn - 1] = index
        } else {
            // link new element to the previous element
            next[rear[qn - 1]] = index
        }

        // update next
        next[index] = -1

        // update rear
        rear[qn - 1] = index

        // push element
        arr[index] = data

    }

    fun dequeue(qn: Int): Int {

        // underflow
        if (front[qn - 1] == -1) {
            println("Queue Underflow")
            return -1
        }

        // find index to pop
        val index = front[qn - 1]

        // front ko aage badhao
        front[qn - 1] = next[index]

        // manage freeSpot
        next[index] = freeSpot
        freeSpot = index

        return arr[index]

    }

}