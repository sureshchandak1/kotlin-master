package loops.pattern

/*
*          A A A A       A B C D       A B C D     A B C D
*          B B B B       A B C D       E F G H     B C D E
*          C C C C       A B C D       I J K L     C D E F
*          D D D D       A B C D       M N O P     D E F G
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
        while (col < n) {
            print("${('A' + row) - 1} ")
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
        while (col < n) {
            print("${('A' + col)} ")
            ++col
        }
        println()

        ++row
    }
}

private fun printPattern2(n: Int) {
    var count = 'A'
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

private fun printPattern3(n: Int) {

    var row = 'A'
    while (row < ('A' + n)) {

        var col = 0
        while (col < n) {
            print("${(row + col)} ")
            ++col
        }
        println()

        ++row
    }
}