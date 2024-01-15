package loops.pattern

/*
*          A           A             A             D
*          B B         B C           B C           C D
*          C C C       D E F         C D E         B C D
*          D D D D     G H I J       D E F G       A B C D
* */

fun main(args: Array<String>) {
    printPattern(4)
    println("------------------")
    printPattern1(4)
    println("------------------")
    printPattern2(4)
    println("------------------")
    printPattern3(4)
    println("------------------")
}

private fun printPattern(n: Int) {
    var row = 1
    while (row <= n) {
        var col = 0
        while (col < row) {
            print("${('A' + row) - 1} ")
            ++col
        }
        println()

        ++row
    }
}

private fun printPattern1(n: Int) {
    var count = 'A'
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

private fun printPattern2(n: Int) {

    var row = 1
    while (row <= n) {

        var col = 0
        while (col < row) {
            print("${('A' + row + col) - 1} ")
            ++col
        }
        println()

        ++row
    }
}

private fun printPattern3(n: Int) {

    var row = 1
    while (row <= n) {

        var col = 1
        while (col <= row) {
            print("${('A' + n - row + col) - 1} ")
            ++col
        }
        println()

        ++row
    }
}

