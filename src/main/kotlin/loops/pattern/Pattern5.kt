package loops.pattern

/*
*          *                          1                 1
*          * *                        2 2               2 3
*          * * *                      3 3 3             4 5 6
*          * * * *                    4 4 4 4           7 8 9 10
*          * * * * *                  5 5 5 5 5         11 12 13 14 15
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
            print("* ")
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
            print("$row ")
            ++col
        }
        println()

        ++row
    }
}

private fun printPattern2(n: Int) {
    var count = 1
    var row = 1
    while (row <= n) {
        var col = 0
        while (col < row) {
            print("$count ")
            ++count
            ++col
        }
        println()

        ++row
    }
}