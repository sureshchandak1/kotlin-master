package sorting.bubble_sort

import printArray

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
    for (round in 0 ..< size) {

        var swapped = false

        for (j in 0 ..< size - round) {
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

// Using Recursion solve bubble sort
private fun sortArray(arr: IntArray, n: Int) {

    // Base case - already sorted
    if (n == 0 || n == 1) {
        return
    }

    var temp = 0
    var swapped = false
    // Move largest element to end position
    for (i in 0 ..< n - 1) {
        if (arr[i] > arr[i + 1]) {
            temp = arr[i]
            arr[i] = arr[i + 1]
            arr[i + 1] = temp

            swapped = true
        }
    }

    if (swapped) {
        sortArray(arr, n - 1)
    }

}