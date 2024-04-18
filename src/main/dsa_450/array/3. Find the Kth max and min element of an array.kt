package array

import java.util.Collections
import java.util.PriorityQueue

fun main() {
    var arr = intArrayOf(7, 10, 4, 3, 20, 15)
    println("Kth Smallest element = ${kthSmallest(arr, 3)}")
    println("Kth Largest element = ${kthLargest(arr, 3)}")

    arr = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    println("Kth Smallest element = ${kthSmallest(arr, 4)}")
    println("Kth Largest element = ${kthLargest(arr, 4)}")
}

private fun kthSmallest(arr: IntArray, k: Int): Int {
    val size = arr.size

    // max heap
    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    for (i in 0..<k) {
        pq.add(arr[i])
    }

    for (i in k..<size) {
        if (arr[i] < pq.peek()) {
            pq.remove()
            pq.add(arr[i])
        }
    }

    return pq.peek()
}

private fun kthLargest(arr: IntArray, k: Int): Int {
    val size = arr.size

    // min heap
    val pq = PriorityQueue<Int>()

    for (i in 0..<k) {
        pq.add(arr[i])
    }

    for (i in k..<size) {
        if (arr[i] > pq.peek()) {
            pq.remove()
            pq.add(arr[i])
        }
    }

    return pq.peek()
}



