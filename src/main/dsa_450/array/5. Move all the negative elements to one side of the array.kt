package array

import printArray

/**
 *    https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
 *    Time Complexity: O(N)
 *    Auxiliary Space: O(1)
 */
fun main() {
    var arr = intArrayOf(-12, 11, -13, -5, 6, -7, 5, -3, -6)
    moveNegativeStart1(arr)
    printArray(arr)

    arr = intArrayOf(-1, 2, -3, 4, 5, 6, -7, 8, 9)
    moveNegativeStart1(arr)
    printArray(arr)

    arr = intArrayOf(-12, 11, -13, -5, 6, -7, 5, -3, -6)
    moveNegativeStart2(arr)
    printArray(arr)

    arr = intArrayOf(-1, 2, -3, 4, 5, 6, -7, 8, 9)
    moveNegativeStart2(arr)
    printArray(arr)

    arr = intArrayOf(-12, 11, -13, -5, 6, -7, 5, -3, -6)
    moveNegativeEnd1(arr)
    printArray(arr)

    arr = intArrayOf(-1, 2, -3, 4, 5, 6, -7, 8, 9)
    moveNegativeEnd2(arr)
    printArray(arr)
}

private fun moveNegativeStart1(arr: IntArray) {
    val size = arr.size

    var index = 0

    for (i in 0 ..< size) {
        if (arr[i] < 0) {
            if (i != index) {
                val temp = arr[index]
                arr[index] = arr[i]
                arr[i] = temp
            }
            index++
        }
    }
}

// using Dutch National Flag Algorithm
private fun moveNegativeStart2(arr: IntArray) {

    var start = 0
    var end = arr.size - 1

    while (start <= end) {
        if (arr[start] <= 0) {
            start++
        } else {
            swap(arr, start, end)
            end--
        }
    }
}

private fun moveNegativeEnd1(arr: IntArray) {
    val size = arr.size

    var index = size - 1

    for (i in size - 1 downTo 0) {
        if (arr[i] < 0) {
            if (i != index) {
                val temp = arr[index]
                arr[index] = arr[i]
                arr[i] = temp
            }
            index--
        }
    }
}

// using Dutch National Flag Algorithm
private fun moveNegativeEnd2(arr: IntArray) {

    var start = 0
    var end = arr.size - 1

    while (start <= end) {
        if (arr[end] <= 0) {
            end--
        } else {
            swap(arr, start, end)
            start++
        }
    }
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}



