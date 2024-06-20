package lecture036_Recursion_Day6

import printArray

fun main() {
    val arr1 = mutableListOf(2, 4, 1, 6, 9, 9, 9, 9, 9, 9)
    printArray(arr1)
    quickSort(arr1, 0, arr1.size - 1)
    printArray(arr1)
}

private fun quickSort(arr: MutableList<Int>, start: Int, end: Int) {

    if (start >= end) {
        return
    }

    // partition
    val p = partition(arr, start, end)

    // left part sorting
    quickSort(arr, start, p - 1)

    // right part sorting
    quickSort(arr, p + 1, end)
}

private fun partition(arr: MutableList<Int>, start: Int, end: Int): Int {

    val pivot = arr[start]

    var count = 0
    for (i in start + 1..end) {
        if (arr[i] <= pivot) {
            count++
        }
    }

    //place pivot at right position
    val pivotIndex = start + count
    var temp = arr[pivotIndex]
    arr[pivotIndex] = arr[start]
    arr[start] = temp

    // handle pivot left and right part
    var i = start
    var j = end

    while (i < pivotIndex && j > pivotIndex) {
        while (arr[i] <= pivot) {
            i++
        }

        while (arr[j] > pivot) {
            j--
        }

        if (i < pivotIndex && j > pivotIndex) {
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }

        i++
        j--
    }

    return pivotIndex
}
