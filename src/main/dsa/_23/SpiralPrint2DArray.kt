package _23

import printArray

fun main() {
    val arr = Array(3) { Array(4) { 0 } }

    for (row in 0 ..< 3) {
        for (col in 0 ..< 4) {
            arr[row][col] = readln().toInt()
        }
    }

    printArray2D(arr)
    println("-------------------------------")
    val result = spiralPrint(arr)
    printArray(result.toIntArray())

    var count = 0
    val total = 5
    val ending = 0

    {
        var index = 0
        while (count < total && index <= ending) {
            count++
            index++
        }
    }
}

private fun spiralPrint(arr: Array<Array<Int>>) : List<Int> {

    val list = mutableListOf<Int>()

    val row = arr.size
    val col = arr[0].size

    var count = 0
    val total = row * col

    // index
    var startingRow = 0
    var startingCol = 0
    var endingRow = row - 1
    var endingCol = col - 1

    var index = 0

    while (count < total) {

        // print starting row
        index = startingCol
        while (count < total && index <= endingCol) {
            list.add(arr[startingRow][index])
            count++
            index++
        }
        startingRow++

        // print ending column
        index = startingRow
        while (count < total && index <= endingRow) {
            list.add(arr[index][endingCol])
            count++
            index++
        }
        endingCol--

        // print ending row
        index = endingCol
        while (count < total && index >= startingCol) {
            list.add(arr[endingRow][index])
            count++
            index--
        }
        endingRow--

        // print starting column
        index = endingRow
        while (count < total && index >= startingRow) {
            list.add(arr[index][startingCol])
            count++
            index--
        }
        startingCol++

    }

    return list
}