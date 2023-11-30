fun main() {
    val array: Array<Array<Int>> = arrayOf(arrayOf(11, 2, 4), arrayOf(4, 5, 6), arrayOf(10, 8, -12))

    println(diagonalDifference(array))

}

private fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var sumLeftToRight = 0
    var sumRightToLeft = 0
    for (index in 0 until arr.size) {
        sumLeftToRight += arr[index][index]
        sumRightToLeft += arr[index][(arr.size - 1) - index]
    }
    return Math.abs((sumLeftToRight - sumRightToLeft))
}







