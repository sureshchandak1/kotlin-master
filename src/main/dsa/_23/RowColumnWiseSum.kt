package _23

fun main() {
    val arr = Array(3) { Array(3) { 0 } }

    for (row in 0 ..< 3) {
        for (col in 0 ..< 3) {
            arr[row][col] = readln().toInt()
        }
    }

    println("-----------------------")
    printArray2D(arr)
    println("-----------------------")

    rowWiseSum(arr, 3, 3)
    println("-----------------------")
    columnWiseSum(arr, 3, 3)
    println("-----------------------")
    println("Largest sum row is = ${largestRowSum(arr, 3, 3)}")
    println("-----------------------")
}

private fun rowWiseSum(arr: Array<Array<Int>>, rowSize: Int, colSize: Int) {
    for (row in 0 ..< rowSize) {
        var sum = 0
        for (col in 0 ..< colSize) {
            sum += arr[row][col]
        }
        println("Row $row sum is = $sum")
    }
}

private fun columnWiseSum(arr: Array<Array<Int>>, rowSize: Int, colSize: Int) {
    for (col in 0 ..< colSize) {
        var sum = 0
        for (row in 0 ..< rowSize) {
            sum += arr[row][col]
        }
        println("Column $col sum is = $sum")
    }

}

private fun largestRowSum(arr: Array<Array<Int>>, rowSize: Int, colSize: Int) : Int {
    var maxSum = Int.MIN_VALUE
    var maxSumRow = -1
    for (row in 0 ..< rowSize) {
        var sum = 0
        for (col in 0 ..< colSize) {
            sum += arr[row][col]
        }

        if (sum > maxSum) {
            maxSum = sum
            maxSumRow = row
        }
    }

    println("Maximum sum is = $maxSum")
    return maxSumRow
}
