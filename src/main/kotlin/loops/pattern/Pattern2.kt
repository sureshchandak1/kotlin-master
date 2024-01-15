package loops.pattern

/*
*          1 1 1 1 1
*          2 2 2 2 2
*          3 3 3 3 3
*          4 4 4 4 4
*          5 5 5 5 5
*
* */

fun main(args: Array<String>) {
    printPattern(5)
    println("------------------")
    printPattern(3)
}

private fun printPattern(n: Int) {
    var row = 1
    while (row <= n) {
        var col = 0
        while (col < n) {
            print("$row ")
            ++col
        }
        println()

        ++row
    }
}