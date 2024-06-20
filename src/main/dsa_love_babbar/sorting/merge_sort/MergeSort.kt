package sorting.merge_sort

import printArray

fun main() {
    val arr1 = intArrayOf(3, 7, 0, 1, 5, 8, 3, 2, 34, 66, 87, 23, 12, 12, 12)
    printArray(arr1)
    mergeSort(arr1, 0, arr1.size - 1)
    printArray(arr1)
}

private fun mergeSort(arr: IntArray, start: Int, end: Int) {

    // Base case
    if (start >= end) {
        return
    }

    val mid = start + (end - start) / 2

    // left part sort
    mergeSort(arr, start, mid)

    // right part sort
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

    // Copy values
    var mainArrayIndex = start
    for (i in 0..<len1) {
        first[i] = arr[mainArrayIndex++]
    }

    mainArrayIndex = mid + 1
    for (i in 0..<len2) {
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