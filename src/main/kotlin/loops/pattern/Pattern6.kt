package loops.pattern

/*
*          1                    1
*          2 3                  2 1
*          3 4 5                3 2 1
*          4 5 6 7              4 3 2 1
*          5 6 7 8 9            5 4 3 2 1
* */

fun main(args: Array<String>) {
    printPattern(5)
    println("------------------")
    printPattern(3)
    println("------------------")
    printPattern1(5)
    println("------------------")
    printPattern2(5)
}

private fun printPattern(n: Int) {
    var row = 1
    while (row <= n) {
        var col = 0
        while (col < row) {
            print("${row + col} ")
            ++col
        }
        println()

        ++row
    }
}

private fun printPattern1(n: Int) {
    var row = 1
    while (row <= n) {
        var col = 0
        while (col < row) {
            print("${row - col} ")
            ++col
        }
        println()

        ++row
    }
}

private fun printPattern2(n: Int) {
    var row = 1
    while (row <= n) {
        var col = 1
        while (col <= row) {
            print("${row - col + 1} ")
            ++col
        }
        println()

        ++row
    }
}