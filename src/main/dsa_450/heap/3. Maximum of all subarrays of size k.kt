package heap

import printArray
import java.util.*

/**
 *   https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
 *   https://leetcode.com/problems/sliding-window-maximum/description/
 */
fun main() {
    var arr = intArrayOf(1, 2, 3, 1, 4, 5, 2, 3, 6)
    printArray(maxSubArrays(arr, arr.size, 3))

    arr = intArrayOf(1, 2, 3, 1, 4, 5, 2, 3, 6)
    printArray(maxKSubArray(arr, 3))

    arr = intArrayOf(8, 5, 10, 7, 9, 4, 15, 12, 90, 13)
    printArray(maxSubArrays(arr, arr.size, 4))

    arr = intArrayOf(8, 5, 10, 7, 9, 4, 15, 12, 90, 13)
    printArray(maxKSubArray(arr, 4))
}

/**
 *   Time Complexity: O(N)
 *   Space Complexity: O(K)
 */
private fun maxKSubArray(arr: IntArray, k: Int) : IntArray {

    val size = arr.size
    val ans = IntArray(size - k + 1)

    val q: Deque<Int> = LinkedList()

    var i = 0
    var j = 0

    while (j < size) {

        while (q.size > 0 && q.peekLast() < arr[j]) {
            q.removeLast()
        }

        q.addLast(arr[j])

        if (j - i + 1 < k) {
            j++
        }
        else if (j - i + 1 == k) {
            ans[i] = q.peekFirst()

            if (arr[i] == q.peekFirst()) {
                q.removeFirst()
            }

            i++
            j++
        }
    }

    return ans
}

/**
 *   Time Complexity: O( N log(N) )
 *   Space Complexity: O(N)
 */
private fun maxSubArrays(arr: IntArray, n: Int, k: Int): ArrayList<Int> {

    val ans = ArrayList<Int>()

    if (k > n) {
        return ans
    }

    val pq: PriorityQueue<Pair> = PriorityQueue { a: Pair, b: Pair -> b.value - a.value }

    // Initialize the heap with the first k elements
    for (i in 0..<k) {
        pq.offer(Pair(arr[i], i))
    }

    //printPriorityQueue(PriorityQueue(pq))

    // The maximum element in the first window
    ans.add(pq.peek().value)

    // Process the remaining elements
    for (i in k..<n) {
        pq.offer(Pair(arr[i], i))

        //printPriorityQueue(PriorityQueue(pq))

        // Remove elements that are outside the window
        while (pq.peek().index <= i - k) {
            pq.poll()
        }

        //printPriorityQueue(PriorityQueue(pq))

        // The maximum element in the current window
        ans.add(pq.peek().value)
    }

    return ans
}

private class Pair(value: Int, index: Int) {
    var value: Int = 0
    var index: Int = 0

    init {
        this.value = value
        this.index = index
    }
}

private fun printPriorityQueue(pq: PriorityQueue<Pair>) {
    print("PriorityQueue = [")
    while (!pq.isEmpty()) {
        print("${pq.remove().value}, ")
    }

    print(("]"))
    println()
}



