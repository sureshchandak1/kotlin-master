package heap

import printArray

/**
 *   https://www.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1
 *   Time Complexity: O(n log(n))
 *   Space Complexity: O(n + m)
 */
fun main() {
    var arr1 = intArrayOf(10, 5, 6, 2); var arr2 = intArrayOf(12, 7, 9)
    printArray(mergeHeaps(arr1, arr2, arr1.size, arr2.size))

    arr1 = intArrayOf(20, 10, 9, 7, 5, 6, 2); arr2 = intArrayOf(12, 7, 9, 8, 8, 5, 4)
    printArray(mergeHeaps(arr1, arr2, arr1.size, arr2.size))
}

private fun mergeHeaps(a: IntArray, b: IntArray, n: Int, m: Int): IntArray {

    val ans = IntArray(n + m)

    // merge 2 array in single array
    var index = 0
    for (value in a) {
        ans[index++] = value
    }

    for (value in b) {
        ans[index++] = value
    }

    // build heap using heapify algo
    val size = n + m

    for (i in size / 2 - 1 downTo 0) {
        heapify(ans, size, i)
    }

    return ans
}

// 0-based index
private fun heapify(arr: IntArray, n: Int, index: Int) {

    var largest = index
    val leftIndex = 2 * index + 1
    val rightIndex = 2 * index + 2

    if (leftIndex < n && arr[largest] < arr[leftIndex]) {
        largest = leftIndex
    }

    if (rightIndex < n && arr[largest] < arr[rightIndex]) {
        largest = rightIndex
    }

    if (largest != index) {
        swap(arr, largest, index)

        heapify(arr, n, largest)
    }
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}




