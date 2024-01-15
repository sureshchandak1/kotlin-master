package loops.pattern

/*
*          * * * * *
*          * * * * *
*          * * * * *
*          * * * * *
*          * * * * *
*  row = col
* */

fun main(args: Array<String>) {
    printPattern(5)
    println("------------------")
    printPattern(3)
}

private fun printPattern(n: Int) {
    var row = n
    while (row > 0) {
        var col = 0
        while (col < n) {
            print("* ")
            ++col
        }
        println()

        --row
    }
}