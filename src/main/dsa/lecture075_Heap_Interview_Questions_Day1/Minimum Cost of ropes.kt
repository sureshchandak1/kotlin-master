package lecture075_Heap_Interview_Questions_Day1

import java.util.*

fun main() {
    println(minCost(longArrayOf(4, 3, 2, 6), 4))
    println(minCost(longArrayOf(4, 2, 7, 6, 9), 5))
}

private fun minCost(arr: LongArray, n: Int): Long {

    // min Heap
    val pq = PriorityQueue<Long>()

    for (value in arr) {
        pq.add(value)
    }

    var ans: Long = 0
    while (pq.size > 1) {
        val a = pq.remove()
        val b = pq.remove()

        val sum = a + b

        ans += sum

        pq.add(sum)
    }

    return ans
}