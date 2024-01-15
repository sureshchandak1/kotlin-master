package loops.pattern

/*
*          1 2 3 4
*          1 2 3 4
*          1 2 3 4
*          1 2 3 4
*
* */

fun main(args: Array<String>) {
    printPattern(4)
    println("------------------")
    printPattern(3)
    println("------------------")
    printPattern1(3)
}

private fun printPattern(n: Int) {
    var row = 1
    while (row <= n) {
        var col = 1
        while (col <= n) {
            print("$col ")
            ++col
        }
        println()

        ++row
    }
}

private fun printPattern1(n: Int) {
    var row = 1
    while (row <= n) {
        var col = 3
        while (col >= 1) {
            print("$col ")
            --col
        }
        println()

        ++row
    }
}