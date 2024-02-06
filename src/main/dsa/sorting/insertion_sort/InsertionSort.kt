package sorting.insertion_sort

import easy.printArray

/*
*   Space Complexity - O(1)
*   Time Complexity - O(n^2)
*
*   Use Case -
* */
fun main() {
    val arr1 = intArrayOf(4, 12, 11, 20)
    printArray(arr1)
    insertionSort(arr1)
    printArray(arr1)
    println("----------------------------------")
    val arr2 = intArrayOf(10, 1, 7, 4, 8, 2, 11)
    printArray(arr2)
    insertionSort(arr2)
    printArray(arr2)
}

fun insertionSort(arr: IntArray) {

    var i = 1
    while (i < arr.size) {
        val temp = arr[i]

        var j = i - 1
        while (j >= 0) {
            if (arr[j] > temp) {
                // shift
                arr[j + 1] = arr[j]
            } else {
                break
            }

            j--
        }

        arr[j + 1] = temp

        i++
    }
}

private fun insertionSort(n: Int, arr: IntArray) {

    var i = 1
    while (i < n) {
        val temp = arr[i]

        var j = i - 1
        while (j >= 0) {
            if (arr[j] > temp) {
                // shift
                arr[j + 1] = arr[j]
            } else {
                break
            }

            j--
        }

        arr[j + 1] = temp

        i++
    }
}