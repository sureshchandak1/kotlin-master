package array

import printArray

/**
 *   https://www.geeksforgeeks.org/program-to-reverse-an-array/
 *   Time Complexity: O(n)
 *   Space Complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(1, 2, 3, 4, 5)
    printArray(arr)
    reverseArray(arr)
    printArray(arr)

    arr = intArrayOf(4, 5, 1, 2)
    printArray(arr)
    reverseArray(arr)
    printArray(arr)
}

private fun reverseArray(arr: IntArray) {

    var start = 0
    var end = arr.size - 1

    while (start < end) {
        val temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp

        start++
        end--
    }
}


