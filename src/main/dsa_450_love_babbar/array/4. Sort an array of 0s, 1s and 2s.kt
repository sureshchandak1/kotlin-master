package array

import printArray

/**
 *    https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 *    Time Complexity: O(n)
 *    Space Complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(0, 2, 1, 2, 0)
    sort012(arr, arr.size)
    printArray(arr)

    arr = intArrayOf(2, 2, 2, 1, 1, 1, 0)
    sort012(arr, arr.size)
    printArray(arr)

    arr = intArrayOf(1, 1, 1, 2, 0, 1, 0)
    sort012(arr, arr.size)
    printArray(arr)

}

private fun sort012(arr: IntArray, n: Int) {

    var zeroIndex = 0 // start
    var oneIndex = 0 // mid
    var twoIndex = n - 1 // end

    while (oneIndex <= twoIndex) {
        if (arr[oneIndex] == 0) {
            swap(arr, zeroIndex, oneIndex)
            zeroIndex++
            oneIndex++
        } else if (arr[oneIndex] == 1) {
            oneIndex++
        } else {
            swap(arr, twoIndex, oneIndex)
            twoIndex--
        }
    }
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}





