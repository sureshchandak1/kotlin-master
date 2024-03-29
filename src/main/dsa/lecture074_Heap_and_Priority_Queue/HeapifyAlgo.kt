package lecture074_Heap_and_Priority_Queue

import printArray

fun main() {
    val arr = intArrayOf(-1, 54, 53, 55, 52, 50)
    val n = 5
    for (i in n/2 downTo 1) { // 1 - based indexing
        heapify(arr, n, i)
    }

    for (i in 1 .. n) {
        print("${arr[i]}  ")
    }
    println()
}

private fun heapify(arr: IntArray, n: Int, i: Int) {

    var largest = i
    val left = 2 * i
    val right = 2 * i + 1

    if (left <= n && arr[largest] < arr[left]) {
        largest = left
    }
    if (right <= n && arr[largest] < arr[right]) {
        largest = right
    }

    if (largest != i) {
        arr[largest] = arr[i].also { arr[i] = arr[largest] } // swap

        heapify(arr, n, largest)
    }
}