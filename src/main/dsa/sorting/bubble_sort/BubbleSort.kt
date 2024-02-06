package sorting.bubble_sort

import easy.printArray

/*
*   Space Complexity - O(1)
*   Time Complexity - O(n^2)
*
*   Use Case -
* */
fun main() {
    val arr = intArrayOf(6, 2, 8, 4, 10)
    printArray(arr)
    bubbleSort(arr)
    printArray(arr)
}

fun bubbleSort(arr: IntArray) {

    val size = arr.size - 1

    var temp = 0
    for (i in 0 ..< size) {

        var swapped = false

        for (j in 0 ..< size - i) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp

                swapped = true
            }
        }

        if (!swapped) {
            break
        }
    }

}

private fun bubbleSort(arr: IntArray, n: Int) {
    var temp = 0
    for (round in 0..< n - 1) {

        var swapped = false

        for (j in 0..< (n - round) - 1) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp

                swapped = true
            }
        }

        if (!swapped) {
            // already sorted
            break
        }
    }
}