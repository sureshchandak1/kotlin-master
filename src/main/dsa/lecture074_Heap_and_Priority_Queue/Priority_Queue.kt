package lecture074_Heap_and_Priority_Queue

import java.util.Collections
import java.util.PriorityQueue

fun main() {

    // min head
    var pq: PriorityQueue<Int> = PriorityQueue()
    pq.add(4)
    pq.add(2)
    pq.add(5)
    pq.add(3)

    println(pq.peek())
    pq.remove()
    println(pq.peek())

    // max heap
    pq = PriorityQueue(Collections.reverseOrder())
    pq.add(4)
    pq.add(2)
    pq.add(5)
    pq.add(3)

    println(pq.peek())
    pq.remove()
    println(pq.peek())
}

