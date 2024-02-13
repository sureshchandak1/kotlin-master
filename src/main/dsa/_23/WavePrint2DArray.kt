package _23

fun main() {
    val arr = Array(3) { Array(4) { 0 } }

    for (row in 0 ..< 3) {
        for (col in 0 ..< 4) {
            arr[row][col] = readln().toInt()
        }
    }

    printArray2D(arr, 3, 4)
    println("-------------------------------")
    wavePrint(arr, 3, 4)
}

private fun wavePrint(arr: Array<Array<Int>>, rowSize: Int, colSize: Int) {
    for (col in 0 ..< colSize) {
        if (col % 2 != 0) {
            for (row in (rowSize - 1) downTo 0 ) {
                print(arr[row][col])
                print(" ")
            }
        } else {
            for (row in 0 ..< rowSize) {
                print(arr[row][col])
                print(" ")
            }
        }
    }
}