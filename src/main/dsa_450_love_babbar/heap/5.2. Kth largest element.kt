package heap

import java.util.*

/**
 *   https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
fun main() {
    var arr = intArrayOf(3, 2, 1, 5, 6, 4)
    println(findKthLargest(arr, 2))

    arr = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    println(findKthLargest(arr, 4))
}

/**
 *    Time Complexity: O(N * log(K))
 *    Space Complexity: O(K)
 */
private fun findKthLargest(nums: IntArray, k: Int): Int {

    // min heap
    val pq: PriorityQueue<Int> = PriorityQueue();
    val size = nums.size

    // insert first k elements
    for (i in 0..<k) {
        pq.add(nums[i])
    }

    // check remaining elements
    for (i in k..<size) {
        if (nums[i] > pq.peek()) {
            pq.remove()
            pq.add(nums[i])
        }
    }

    return pq.peek()

}







