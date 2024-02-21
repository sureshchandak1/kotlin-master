package lecture023_2D_arrays

import printArray

fun main() {
    val arr: Array<IntArray> = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )

    printArray(arr[0])

    println(searchMatrix(arr, 3))
    println(searchMatrix(arr, 100))
}

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    val row = matrix.size
    val col = matrix[0].size

    var start = 0
    var end = row * col - 1

    var mid = start + (end - start) / 2

    while (start <= end) {

        val element = matrix[mid / col][mid % col]

        if (element == target) {
            return true
        }

        if (element < target) {
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2

    }

    return false

}