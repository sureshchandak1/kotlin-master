package loops.pattern

/*
*                             1
*                           1 2 1
*                         1 2 3 2 1
*                       1 2 3 4 3 2 1
* */

fun main(args: Array<String>) {
    printPattern1(4)
    println("------------------")

    printPattern1(5)
    println("------------------")
}

private fun printPattern1(n: Int) {
    var row = 1
    while (row <= n) {

        // print 1st triangle
        var space = n - row
        while (space > 0) {
            print(" ")
            --space
        }

        // print 2nd triangle
        var col = 1
        while (col <= row) {
            print("$col")
            ++col
        }

        // print 3rd triangle
        var value = row - 1
        while (value > 0) {
            print("$value")
            --value
        }

        println()

        ++row
    }
}








