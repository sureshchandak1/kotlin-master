package _23

fun main() {
    val arr: Array<IntArray> = arrayOf(
        intArrayOf(1, 4, 7, 11, 15),
        intArrayOf(2, 5, 8, 12, 19),
        intArrayOf(3, 6, 9, 16, 22),
        intArrayOf(10, 13, 14, 17, 24),
        intArrayOf(18, 21, 23, 26, 30)
    )

    println(searchMatrix(arr, 5))
    println(searchMatrix(arr, 100))
}

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

    val row = matrix.size
    val col = matrix[0].size

    var rowIndex = 0
    var colIndex = col - 1

    while (rowIndex < row && colIndex >= 0) {

        val element = matrix[rowIndex][colIndex]

        if (element == target) {
            return true
        }

        if (element < target) {
            rowIndex++
        } else {
            colIndex--
        }

    }

    return false
}