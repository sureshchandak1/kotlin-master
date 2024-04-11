import java.util.*

fun main() {

}

class MedianFinder() {

    private var median: Double = 0.0
    private val minHeap: PriorityQueue<Int> = PriorityQueue()
    private val maxHeap: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())

    fun addNum(num: Int) {
        when (signum(maxHeap.size, minHeap.size)) {

            0 -> if (num > median) {
                minHeap.add(num)
                median = minHeap.peek().toDouble()
            } else {
                maxHeap.add(num)
                median = maxHeap.peek().toDouble()
            }

            1 -> if (num > median) {
                minHeap.add(num)
                median = (minHeap.peek() + maxHeap.peek()) / 2.0
            }
            else {
                minHeap.add(maxHeap.remove())
                maxHeap.add(num)
                median = (minHeap.peek() + maxHeap.peek()) / 2.0
            }

            -1 -> if (num > median) {
                maxHeap.add(minHeap.remove())
                minHeap.add(num)
                median = (minHeap.peek() + maxHeap.peek()) / 2.0
            }
            else {
                maxHeap.add(num)
                median = (minHeap.peek() + maxHeap.peek()) / 2.0
            }
        }
    }

    fun findMedian(): Double {
        /*
        if (maxHeap.size > minHeap.size) {
            return maxHeap.peek().toDouble()
        }
        return (minHeap.peek() ?: 0 + maxHeap.peek() ?: 0) / 2.0
        */

        return median
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

}