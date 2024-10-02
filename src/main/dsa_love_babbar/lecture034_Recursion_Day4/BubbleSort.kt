package lecture034_Recursion_Day4

import printArray

fun main() {
    val arr1 = intArrayOf(2, 5, 1, 9, 6)
    printArray(arr1)
    sortArray(arr1, arr1.size)
    printArray(arr1)
}

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