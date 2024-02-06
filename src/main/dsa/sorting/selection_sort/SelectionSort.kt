package sorting.selection_sort

import easy.printArray

/*
*   Space Complexity - O(1)
*   Time Complexity - O(n^2)
*
*   Use Case - When array size is small
* */

fun main() {
    val arr = intArrayOf(29, 72, 98, 13, 87, 66, 52, 51, 36)
    printArray(arr)
    selectionSort(arr)
    printArray(arr)
}

fun selectionSort(arr: IntArray) {

    val size = arr.size - 1 // counting from 0

    for (i in 0..<size) {

        var minIndex = i

        for (j in i + 1 ..size) {
            if (arr[minIndex] > arr[j]) {
                minIndex = j
            }
        }

        val temp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = temp

    }

}

private fun selectionSort(arr: IntArray, n: Int) {
    var temp = 0
    for (i in 0..<n - 1) {
        var minIndex = i

        for (j in i + 1..<n) {
            if (arr[minIndex] > arr[j]) minIndex = j
        }

        temp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = temp
    }
}