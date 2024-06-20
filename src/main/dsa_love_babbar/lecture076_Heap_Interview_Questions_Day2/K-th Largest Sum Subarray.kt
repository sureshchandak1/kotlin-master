package lecture076_Heap_Interview_Questions_Day2

import java.util.*
import kotlin.math.max

/*
*   https://www.naukri.com/code360/problems/k-th-largest-sum-contiguous-subarray_920398
* */
fun main() {
    println(getKthLargest(arrayListOf(3, -2, 5), 3))
    println(getKthLargest(arrayListOf(3, 1), 2))
    println(getKthLargest(arrayListOf(5, 4, -8, 6), 10))
    println(getKthLargest(arrayListOf(1, 2, 3), 1))
}

private fun getKthLargest(arr: ArrayList<Int>, k: Int): Int {

    val size = arr.size

    val pq = PriorityQueue<Int>()

    for (i in 0..< size) {

        var sum = 0
        for (j in i..< size) {
            sum += arr[j]

            if (pq.size < k) {
                pq.add(sum)
            } else {
                if (pq.peek() < sum) {
                    pq.remove()
                    pq.add(sum)
                }
            }
        }

    }

    return pq.peek()
}