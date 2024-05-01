package heap

import printArray

fun main() {
    val arr = intArrayOf(9, 3, 2, 6, 7)
    printArray(arr)

    buildMinHeap(arr)
    printArray(arr)
}

private fun buildMinHeap(arr: IntArray): IntArray {
    val n = arr.size
    for (i in n / 2 - 1 downTo 0) { // 0-based index
        heapify(arr, n, i)
    }

    return arr
}

private fun heapify(arr: IntArray, n: Int, i: Int) {
    // 0-based index
    var smallest = i
    val left = 2 * i + 1
    val right = 2 * i + 2

    if (left < n && arr[smallest] > arr[left]) {
        smallest = left
    }
    if (right < n && arr[smallest] > arr[right]) {
        smallest = right
    }

    if (smallest != i) {
        val temp = arr[smallest]
        arr[smallest] = arr[i]
        arr[i] = temp

        heapify(arr, n, smallest)
    }
}





