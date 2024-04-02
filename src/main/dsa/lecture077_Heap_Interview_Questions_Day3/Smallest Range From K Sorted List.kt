package lecture077_Heap_Interview_Questions_Day3

import java.util.*
import kotlin.math.max
import kotlin.math.min

/*
*   https://www.naukri.com/code360/problems/smallest-range-from-k-sorted-list_1069356
* */
fun main() {
    var arr = arrayOf(
        intArrayOf(1, 10, 11),
        intArrayOf(2, 3, 20),
        intArrayOf(5, 6, 12)
    )
    println(kSorted(a = arr, k = 3, n = 3))

    arr = arrayOf(
        intArrayOf(2, 4, 5),
        intArrayOf(5, 6, 7)
    )
    println(kSorted(a = arr, k = 2, n = 3))

    arr = arrayOf(
        intArrayOf(4, 7, 30),
        intArrayOf(1, 2, 12),
        intArrayOf(20, 40, 50)
    )
    println(kSorted(a = arr, k = 3, n = 3))
}

private fun kSorted(a: Array<IntArray>, k: Int, n: Int): Int {

    var mini = Int.MAX_VALUE
    var maxi = Int.MIN_VALUE

    // step 1: create a min heap for starting element of each list and tracking mini/maxi value
    val minHeap = PriorityQueue(ItemComparator())

    for (i in 0..< k) {
        val element = a[i][0]
        mini = min(mini.toDouble(), element.toDouble()).toInt()
        maxi = max(maxi.toDouble(), element.toDouble()).toInt()
        minHeap.add(Item(element, i, 0))
    }

    var start = mini
    var end = maxi

    // step 2: process ranges
    while (!minHeap.isEmpty()) {

        // mini fetch
        val temp = minHeap.remove()

        mini = temp.data

        // range or answer updations
        if (maxi - mini < end - start) {
            start = mini
            end = maxi
        }

        // next element exists
        if (temp.col + 1 < n) {
            maxi = max(maxi.toDouble(), a[temp.row][temp.col + 1].toDouble()).toInt()
            minHeap.add(Item(a[temp.row][temp.col + 1], temp.row, temp.col + 1))
        } else {
            // next element not exists
            break
        }
    }

    // return difference of range
    return end - start + 1
}

private class ItemComparator : Comparator<Item> {
    override fun compare(i1: Item, i2: Item): Int {
        if (i1.data < i2.data) return -1
        else if (i1.data > i2.data) return 1

        return 0
    }
}

private class Item(var data: Int, var row: Int, var col: Int)



