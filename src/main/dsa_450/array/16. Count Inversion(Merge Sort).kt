package array

import printArray

/**
 *   https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 */
fun main() {
    var arr = intArrayOf(2, 4, 1, 3, 5)
    printArray(arr)
    mergeSort(arr, 0, arr.size - 1)
    printArray(arr)

    arr = intArrayOf(2, 4, 1, 3, 5)
    println("Inversion count = ${mergeSortAndCount(arr, 0, arr.size - 1)}")
    printArray(arr)

    arr = intArrayOf(5, 4, 3, 2, 1)
    println("Inversion count = ${mergeSortAndCount(arr, 0, arr.size - 1)}")
    printArray(arr)
}

/**
 *    ----- Brute Force Approach -----
 *    Time Complexity: O(N2)
 *    Space Complexity: O(1)
 */
private fun inversionCount(arr: IntArray) : Int {
    val size = arr.size
    var invCount = 0
    for (i in 0 ..< size) {
        for (j in i + 1 ..< size) {
            if (arr[i] > arr[j]) {
                invCount++
            }
        }
    }

    return invCount
}

/**
 *    Time Complexity: O(N*logN)
 *    Space Complexity: O(N)
 */
private fun mergeSortAndCount(arr: IntArray, start: Int, end: Int) : Int {

    var invCount = 0

    // base case
    if (start >= end) {
        return invCount
    }

    val mid = start + (end - start) / 2

    // left
    invCount += mergeSortAndCount(arr, start, mid)

    // right
    invCount += mergeSortAndCount(arr, mid + 1, end)

    // merge
    invCount += mergeAndCount(arr, start, end)

    return invCount
}

private fun mergeAndCount(arr: IntArray, start: Int, end: Int) : Int {

    val mid = start + (end - start) / 2

    val len1 = mid - start + 1
    val len2 = end - mid

    val first = IntArray(len1)
    val second = IntArray(len2)

    // copy values
    var mainArrayIndex = start
    for (i in 0 ..< len1) {
        first[i] = arr[mainArrayIndex++]
    }

    mainArrayIndex = mid + 1
    for (i in 0 ..< len2) {
        second[i] = arr[mainArrayIndex++]
    }

    // merge 2 sorted arrays
    var index1 = 0
    var index2 = 0
    mainArrayIndex = start

    var invCount = 0

    while (index1 < len1 && index2 < len2) {
        if (first[index1] <= second[index2]) {
            arr[mainArrayIndex++] = first[index1++]
        } else {
            arr[mainArrayIndex++] = second[index2++]
            invCount += (mid + 1) - (start + index1)
        }
    }

    while (index1 < len1) {
        arr[mainArrayIndex++] = first[index1++]
    }
    while (index2 < len2) {
        arr[mainArrayIndex++] = second[index2++]
    }

    return invCount

}

/**
 *       Merge Sort
 */
private fun mergeSort(arr: IntArray, start: Int, end: Int) {

    // Base case
    if (start >= end) {
        return
    }

    val mid = start + (end - start) / 2

    // left
    mergeSort(arr, start, mid)

    // right
    mergeSort(arr, mid + 1, end)

    // merge
    merge(arr, start, end)
}

private fun merge(arr: IntArray, start: Int, end: Int) {

    val mid = start + (end - start) / 2

    val len1 = mid - start + 1
    val len2 = end - mid

    val first = IntArray(len1)
    val second = IntArray(len2)

    // copy values
    var mainArrayIndex = start
    for (i in 0 ..< len1) {
        first[i] = arr[mainArrayIndex++]
    }

    mainArrayIndex = mid + 1
    for (i in 0 ..< len2) {
        second[i] = arr[mainArrayIndex++]
    }

    // merge 2 sorted arrays
    var index1 = 0
    var index2 = 0
    mainArrayIndex = start

    while (index1 < len1 && index2 < len2) {
        if (first[index1] < second[index2]) {
            arr[mainArrayIndex++] = first[index1++]
        } else {
            arr[mainArrayIndex++] = second[index2++]
        }
    }

    while (index1 < len1) {
        arr[mainArrayIndex++] = first[index1++]
    }
    while (index2 < len2) {
        arr[mainArrayIndex++] = second[index2++]
    }
}


