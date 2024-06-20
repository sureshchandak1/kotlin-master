package lecture075_Heap_Interview_Questions_Day1

import java.util.*


fun main() {
    var arr = intArrayOf(3, 2, 1, 5, 6, 4)
    println(kthSmallest(arr.size, 2, arr))

    arr = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    println(kthSmallest(arr.size, 4, arr))
}

private fun kthSmallest(n: Int, k: Int, arr: IntArray): Int {

    val pq = PriorityQueue(Collections.reverseOrder<Int>())

    for (i in 0..<k) {
        pq.add(arr[i])
    }

    for (i in k..<n) {
        if (arr[i] < pq.peek()) {
            pq.remove()
            pq.add(arr[i])
        }
    }

    return pq.peek()
}