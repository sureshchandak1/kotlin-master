package lecture076_Heap_Interview_Questions_Day2

import printArray
import java.util.*

/*
*   https://www.naukri.com/code360/problems/merge-k-sorted-arrays_975379
* */
fun main() {
    val ans1 = mergeKSortedArrays(
        arrayListOf(
            arrayListOf(3, 5, 9),
            arrayListOf(3, 5, 9, 10),
            arrayListOf(3, 5, 9),
            arrayListOf(3, 5, 9, 12),
            arrayListOf(3, 5, 9)
        ), 5
    )

    printArray(ans1)
}

private fun mergeKSortedArrays(kArrays: ArrayList<ArrayList<Int>>, k: Int): ArrayList<Int> {

    val ans = ArrayList<Int>()

    // default min heap
    val minHeap = PriorityQueue(ItemComparator())

    // insert all arrays first element in minHeap
    for (i in 0..< k) {
        val item = Item(kArrays[i][0], i, 0)
        minHeap.add(item)
    }

    while (minHeap.size > 0) {
        val temp = minHeap.remove()

        ans.add(temp.data)

        val row = temp.row
        val col = temp.col

        if (col + 1 < kArrays[row].size) {
            val item = Item(kArrays[row][col + 1], row, col + 1)
            minHeap.add(item)
        }
    }

    return ans
}

private class ItemComparator : Comparator<Item> {
    override fun compare(i1: Item, i2: Item): Int {
        if (i1.data < i2.data) return -1
        else if (i1.data > i2.data) return 1

        return 0
    }
}

private class Item(var data: Int, var row: Int, var col: Int)


