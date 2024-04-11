package lecture077_Heap_Interview_Questions_Day3

import printArray
import java.util.*

/*
*   https://www.naukri.com/code360/problems/median-in-a-stream_975268
* */

fun main() {
    var arr = intArrayOf(20, 8, 13, 19, 17, 16, 12, 0, 19, 20)
    printArray(findMedian(arr, arr.size))

    arr = intArrayOf(5, 5, 1, 12, 1, 11, 10, 2, 12, 6, 6)
    printArray(findMedian(arr, arr.size))

    arr = intArrayOf(5, 17, 16, 4, 17, 10, 12)
    printArray(findMedian(arr, arr.size))

    arr = intArrayOf(0, 19, 20, 14, 5, 13, 6, 7)
    printArray(findMedian(arr, arr.size))

    arr = intArrayOf(1, 2, 3)
    printArray(findMedian(arr, arr.size))

    arr = intArrayOf(9, 9)
    printArray(findMedian(arr, arr.size))

    arr = intArrayOf(4)
    printArray(findMedian(arr, arr.size))
}


private var median = 0

private fun findMedian(arr: IntArray, n: Int): IntArray {

    val ans = IntArray(n)

    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue(Collections.reverseOrder<Int>())

    for (i in 0..< n) {
        callMedian(arr[i], maxHeap, minHeap)
        ans[i] = median
    }

    return ans
}

private fun callMedian(element: Int, maxHeap: PriorityQueue<Int>, minHeap: PriorityQueue<Int>) {

    when (signum(maxHeap.size, minHeap.size)) {
        0 -> if (element > median) {
            minHeap.add(element)
            median = minHeap.peek()
        } else {
            maxHeap.add(element)
            median = maxHeap.peek()
        }

        1 -> if (element > median) {
            minHeap.add(element)
            println("minHeap peek = ${minHeap.peek()}, maxHeap peek = ${maxHeap.peek()}")
            median = (minHeap.peek() + maxHeap.peek()) / 2
        } else {
            minHeap.add(maxHeap.remove())
            maxHeap.add(element)
            median = (minHeap.peek() + maxHeap.peek()) / 2
        }

        -1 -> if (element > median) {
            maxHeap.add(minHeap.remove())
            minHeap.add(element)
            median = (minHeap.peek() + maxHeap.peek()) / 2
        } else {
            maxHeap.add(element)
            median = (minHeap.peek() + maxHeap.peek()) / 2
        }
    }
}

private fun signum(a: Int, b: Int): Int {
    return if (a == b) {
        0
    } else if (a > b) {
        1
    } else {
        -1
    }
}



