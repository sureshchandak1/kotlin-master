package lecture023_2D_arrays

fun main(args: Array<String>) {
    val first: Array<IntArray> = arrayOf(
        intArrayOf(2, 4, 6),
        intArrayOf(1, 3, 5),
        intArrayOf(7, 9, 8)
    )

    printArray2D(first)

    println(isPresent(first, 3, 3, 3))
    println(isPresent(first, 30, 3, 3))
}

private fun isPresent(arr: Array<IntArray>, target: Int, rowSize: Int, colSize: Int) : Boolean {
    for (row in 0 ..< rowSize) {
        for (col in 0 ..< colSize) {
            if (arr[row][col] == target) {
                return true
            }
        }
    }

    return false
}