package heap

import printArray

/**
 *   https://www.geeksforgeeks.org/problems/heap-sort/1
 *   Time Complexity: O(N * Log(N))
 *   Space Complexity: O(1)
 */
fun main() {
    printArray(sortArray(intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 8, 1)))
    printArray(sortArray(intArrayOf(10, 7, 8, 11)))
    printArray(sortArray(intArrayOf(5, -2, 3, -1, 8)))
}

private fun sortArray(nums: IntArray): IntArray {
    heapSort(nums, nums.size)

    return nums
}

private fun heapSort(arr: IntArray, size: Int) {

    // Step 1: create max heap
    buildHeap(arr, size)

    // Step 2: start sorting
    var n = size - 1

    while (n > 0) {
        swap(arr, n, 0)

        n--

        heapify(arr, n, 0)
    }
}

private fun buildHeap(arr: IntArray, size: Int) {
    for (index in size/2 downTo 0) {
        heapify(arr, size - 1, index)
    }
}

private fun heapify(arr: IntArray, size: Int, index: Int) {

    var largest = index
    val leftIndex = 2 * index + 1
    val rightIndex = 2 * index + 2

    if (leftIndex <= size && arr[largest] < arr[leftIndex]) {
        largest = leftIndex
    }

    if (rightIndex <= size && arr[largest] < arr[rightIndex]) {
        largest = rightIndex
    }

    if (largest != index) {
        swap(arr, largest, index)

        heapify(arr, size, largest)
    }
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

private fun print(arr: IntArray, size: Int) {
    for (i in 0 ..< size) {
        print("${arr[i]}, ")
    }
    println()
}



