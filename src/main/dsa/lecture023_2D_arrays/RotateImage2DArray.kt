package lecture023_2D_arrays

fun main() {
    val arr: Array<IntArray> = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    printArray2D(arr)

    rotate1(arr)

    println("--------------------")

    printArray2D(arr)
}

private fun rotate1(matrix: Array<IntArray>) {

    val row = matrix.size

    var temp = 0
    for (i in 0 ..< row) {
        for (j in 0 .. i) {
            temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    for (i in 0 ..< row) {
        reverseArray(matrix[i])
    }

}

private fun reverseArray(arr: IntArray) {

    var start = 0
    var end = arr.size - 1

    var temp = 0
    while (start < end) {
        temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp

        start++
        end--
    }

}