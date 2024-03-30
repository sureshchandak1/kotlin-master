import java.util.*

/*
*  https://leetcode.com/problems/kth-largest-element-in-an-array/
* */
fun main() {
    var arr = intArrayOf(3, 2, 1, 5, 6, 4)
    println(findKthLargest(arr, 2))

    arr = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    println(findKthLargest(arr, 4))
}

private fun findKthLargest(nums: IntArray, k: Int): Int {

    val pq: PriorityQueue<Int> = PriorityQueue();
    val size = nums.size

    for (i in 0..<k) {
        pq.add(nums[i])
    }

    for (i in k..<size) {
        if (nums[i] > pq.peek()) {
            pq.remove()
            pq.add(nums[i])
        }
    }

    return pq.peek()

}