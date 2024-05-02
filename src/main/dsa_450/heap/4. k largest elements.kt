package heap

import printArray
import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
 */
fun main() {
    var arr = intArrayOf(12, 5, 787, 1, 23)
    printArray(kLargest1(arr, arr.size, 2))

    arr = intArrayOf(1, 23, 12, 9, 30, 2, 50)
    printArray(kLargest1(arr, arr.size, 3))
}

/**
 *   Time Complexity: O(N * log(K))
 *   Space Complexity: O(K)
 */
private fun kLargest1(arr: IntArray, n: Int, k: Int): IntArray {

    // min heap
    val pq = PriorityQueue<Int>()

    for (i in 0..< n) {
        pq.add(arr[i])

        if (pq.size > k) {
            pq.poll()
        }
    }

    val ans = IntArray(k)

    var i = 0
    while (!pq.isEmpty()) {
        ans[i] = pq.poll()
        i++
    }

    reverse(ans)

    return ans
}

private fun reverse(arr: IntArray) {
    var start = 0
    var end = arr.size - 1

    while (start < end) {
        swap(arr, start, end)

        start++
        end--
    }
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}




