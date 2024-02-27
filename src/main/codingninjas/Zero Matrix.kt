import lecture023_2D_arrays.printArray2D

fun main() {
    val matrix = mutableListOf(
        mutableListOf(2, 4, 3),
        mutableListOf(1, 0, 0)
    )
    printArray2D(matrix)
    println("--------------------------------------------")

    zeroMatrix(matrix, 2, 3)

    printArray2D(matrix)
}

private fun zeroMatrix(
    matrix: MutableList<MutableList<Int>>,
    n: Int, m: Int
) {

    val zeroRows = BooleanArray(n)
    val zeroCol = BooleanArray(m)

    for (i in 0..< n) {
        for (j in 0..< m) {
            if (matrix[i][j] == 0) {
                zeroRows[i] = true
                zeroCol[j] = true
            }
        }
    }

    for (i in 0..< n) {
        for (j in 0..< m) {
            if (zeroRows[i] || zeroCol[j]) {
                matrix[i][j] = 0
            }
        }
    }

}