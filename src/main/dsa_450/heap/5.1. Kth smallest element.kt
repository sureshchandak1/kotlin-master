package heap

import java.util.*

/**
 *   https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
 */
fun main() {
    var arr = intArrayOf(7, 10, 4, 3, 20, 15)
    println(kthSmallest(arr, arr.size, 3))

    arr = intArrayOf(7, 10, 4, 20, 15)
    println(kthSmallest(arr, arr.size, 4))
}

/**
 *    Time Complexity: O(N * log(K))
 *    Space Complexity: O(K)
 */
private fun kthSmallest(arr: IntArray, n: Int, k: Int): Int {

    // max heap
    val pq = PriorityQueue(Collections.reverseOrder<Int>())

    // insert first k elements
    for (i in 0..< k) {
        pq.add(arr[i])
    }

    // check remaining elements
    for (i in k..< n) {
        if (arr[i] < pq.peek()) {
            pq.remove()
            pq.add(arr[i])
        }
    }

    return pq.peek()
}




