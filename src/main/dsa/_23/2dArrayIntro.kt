package _23

fun main() {

    val first: Array<IntArray> = arrayOf(
        intArrayOf(2, 4, 6),
        intArrayOf(1, 3, 5),
        intArrayOf(7, 9, 8)
    )

    printArray2D(first, 3, 3)

    // A 3x4 array of Int, all set to 0.
    val arr = Array(3) { Array(4) { 0 } }

    println("Row wise input")
    // Taking input - row wise input
    for (row in 0 ..< 3) {
        for (col in 0 ..< 4) {
            arr[row][col] = readln().toInt()
        }
    }

    // Print
    for (row in 0 ..< 3) {
        for (col in 0 ..< 4) {
            print(arr[row][col])
            print("  ")
        }
        println()
    }

    println("Col wise input")
    // Taking input - col wise input
    for (col in 0 ..< 4) {
        for (row in 0 ..< 3) {
            arr[row][col] = readln().toInt()
        }
    }

    // Print
    for (row in 0 ..< 3) {
        for (col in 0 ..< 4) {
            print(arr[row][col])
            print("  ")
        }
        println()
    }


}

fun printArray2D(arr: Array<IntArray>, rowSize: Int, colSize: Int) {
    for (row in 0 ..< rowSize) {
        for (col in 0 ..< colSize) {
            print(arr[row][col])
            print("  ")
        }
        println()
    }
}

fun printArray2D(arr: Array<Array<Int>>, rowSize: Int, colSize: Int) {
    for (row in 0 ..< rowSize) {
        for (col in 0 ..< colSize) {
            print(arr[row][col])
            print("  ")
        }
        println()
    }
}