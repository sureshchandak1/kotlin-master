package collections

import java.util.Collections
import java.util.PriorityQueue

fun main() {

    val minHeap: PriorityQueue<Int> = PriorityQueue()
    minHeap.add(10)
    minHeap.add(13)
    minHeap.add(4)
    minHeap.add(32)
    minHeap.add(62)
    minHeap.add(20)

    println(minHeap.peek())

    val maxHeap: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    maxHeap.add(10)
    maxHeap.add(13)
    maxHeap.add(4)
    maxHeap.add(32)
    maxHeap.add(62)
    maxHeap.add(20)

    println(maxHeap.peek())
}