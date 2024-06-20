package heap

import printArray
import java.util.*

/**
 *   https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
 *   Time Complexity: O(N * K * log K), Insertion and deletion in a Min Heap requires log K time.
 *   Space Complexity: O(K)
 */
fun main() {
    var arr = arrayOf(
        intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)
    )
    printArray(mergeKArrays(arr, arr.size))

    arr = arrayOf(
        intArrayOf(1, 2, 3, 4), intArrayOf(2, 2, 3, 4),
        intArrayOf(5, 5, 6, 6), intArrayOf(7, 8, 9, 9)
    )
    printArray(mergeKArrays(arr, arr.size))
}

private fun mergeKArrays(arr: Array<IntArray>, k: Int): ArrayList<Int> {

    val ans = ArrayList<Int>()

    // min heap
    val pq = PriorityQueue(ItemComparator())

    // Insert first element of all array
    for (i in 0..<k) {
        val item = Item(arr[i][0], i, 0)
        pq.add(item)
    }

    while (!pq.isEmpty()) {
        val root = pq.remove()

        ans.add(root.data)

        val row = root.row
        val col = root.col

        if (col + 1 < arr[row].size) {
            val item = Item(arr[row][col + 1], row, col + 1)
            pq.add(item)
        }
    }

    return ans
}

private class ItemComparator : Comparator<Item> {
    override fun compare(i1: Item, i2: Item): Int {
        if (i1.data < i2.data) return -1
        if (i1.data > i2.data) return 1

        return 0
    }
}

private class Item(data: Int, row: Int, col: Int) {
    var data: Int = 0
    var row: Int = 0
    var col: Int = 0

    init {
        this.data = data
        this.row = row
        this.col = col
    }
}






