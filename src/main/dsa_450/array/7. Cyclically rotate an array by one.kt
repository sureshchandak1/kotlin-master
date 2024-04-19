package array

import printArray

/**
 *    https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
 *    Time Complexity: O(n)
 *    Auxiliary Space: O(1)
 */
fun main() {
    var arr = intArrayOf(1, 2, 3, 4, 5)
    rotate1(arr, arr.size)
    printArray(arr)

    arr = intArrayOf(1, 2, 3, 4, 5)
    rotate2(arr, arr.size)
    printArray(arr)

    arr = intArrayOf(1, 2, 3, 4, 5)
    rotate3(arr, arr.size)
    printArray(arr)
}

private fun rotate1(arr: IntArray, n: Int) {
    if (n == 0 || n == 1) {
        return
    }

    val last = arr[n - 1]

    for (i in n - 1 downTo 1) {
        arr[i] = arr[i - 1]
    }

    arr[0] = last
}

// two-pointer
private fun rotate2(arr: IntArray, n: Int) {

    var start = 0
    val end = n - 1

    while (start != end) {
        val temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp

        start++
    }
}

private fun rotate3(arr: IntArray, n: Int) {

    val k = 1 // No. of rotations

    // reverse n-k-1 element
    var i = 0
    var j = n - k - 1
    while (i < j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp

        i++
        j--
    }

    // reverse entire array
    i = 0
    j = n - 1
    while (i < j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp

        i++
        j--
    }
}



