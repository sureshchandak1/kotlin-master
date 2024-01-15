package loops.pattern

/*
*          1 2 3
*          4 5 6
*          7 8 9
*
* */

fun main(args: Array<String>) {
    printPattern(5)
    println("------------------")
    printPattern(3)
}

private fun printPattern(n: Int) {
    var count = 1
    var row = 1
    while (row <= n) {
        var col = 0
        while (col < n) {
            print("$count ")
            ++count
            ++col
        }
        println()

        ++row
    }
}