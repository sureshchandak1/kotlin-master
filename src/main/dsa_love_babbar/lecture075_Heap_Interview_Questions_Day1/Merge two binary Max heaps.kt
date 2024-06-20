package lecture075_Heap_Interview_Questions_Day1

import printArray

/*
*   https://www.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1
* */
fun main() {
    val a = intArrayOf(10, 5, 6, 2)
    val b = intArrayOf(12, 7, 9)

    val ans = mergeHeaps(a, b, a.size, b.size)

    printArray(ans)
}

private fun mergeHeaps(a: IntArray, b: IntArray, n: Int, m: Int): IntArray {

    // merge 2 arrays to single array
    val ans = IntArray(n + m)

    var count = 0
    for (value in a) {
        ans[count++] = value
    }
    for (value in b) {
        ans[count++] = value
    }

    // create heap
    val size = ans.size

    for (i in size / 2 - 1 downTo 0) {
        heapify(ans, size, i)
    }

    return ans
}

// 0 - bases indexing
private fun heapify(arr: IntArray, size: Int, index: Int) {

    var largest = index
    val left = 2 * index + 1
    val right = 2 * index + 2

    if (left < size && arr[largest] < arr[left]) {
        largest = left
    }
    if (right < size && arr[largest] < arr[right]) {
        largest = right
    }

    if (largest != index) {
        val temp = arr[largest]
        arr[largest] = arr[index]
        arr[index] = temp

        heapify(arr, size, largest)
    }
}

