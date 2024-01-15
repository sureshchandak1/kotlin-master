package loops.pattern

/*
*              *     * * * *      * * * *
*            * *     * * *          * * *
*          * * *     * *              * *
*        * * * *     *                  *
* */

fun main(args: Array<String>) {
    printPattern1(4)
    println("------------------")

    printPattern2(4)
    println("------------------")

    printPattern3(4)
    println("------------------")

    printPattern4(4)
    println("------------------")

    printPattern5(4)
    println("------------------")

    printPattern6(4)
    println("------------------")

    printPattern7(4)
    println("------------------")
}

private fun printPattern1(n: Int) {
    var row = 1
    while (row <= n) {

        // Space print
        var space = n - row
        while (space > 0) {
            print(" ")
            --space
        }

        // Star print
        var col = 1
        while (col <= row) {
            print("*")
            ++col
        }

        println()

        ++row
    }
}

private fun printPattern2(n: Int) {
    var row = 0
    while (row < n) {

        var col = (n - row)
        while (col > 0) {
            print("* ")
            --col
        }

        println()

        ++row
    }
}

private fun printPattern3(n: Int) {
    var row = 1
    while (row <= n) {

        // Space print
        var space = row - 1
        while (space > 0) {
            print(" ")
            --space
        }

        // Star print
        val star = n - row + 1
        var col = 0
        while (col < star) {
            print("*")
            ++col
        }

        println()

        ++row
    }
}

private fun printPattern4(n: Int) {
    var row = 1
    while (row <= n) {

        // Space print
        var space = row - 1
        while (space > 0) {
            print(" ")
            --space
        }

        // Star print
        val star = n - row + 1
        var col = 1
        while (col <= star) {
            print("$row")
            ++col
        }

        println()

        ++row
    }
}

private fun printPattern5(n: Int) {
    var row = 1
    while (row <= n) {

        // Space print
        var space = row - 1
        while (space > 0) {
            print(" ")
            --space
        }

        // Star print
        val star = n - row + 1
        var col = 0
        while (col < star) {
            print("${row + col}")
            ++col
        }

        println()

        ++row
    }
}

private fun printPattern6(n: Int) {
    var row = 1
    while (row <= n) {

        // Space print
        var space = n - row
        while (space > 0) {
            print(" ")
            --space
        }

        // Star print
        var col = 1
        while (col <= row) {
            print("$row")
            ++col
        }

        println()

        ++row
    }
}

private fun printPattern7(n: Int) {
    var count = 1
    var row = 1
    while (row <= n) {

        // Space print
        var space = n - row
        while (space > 0) {
            print(" ")
            --space
        }

        // Star print
        var col = 1
        while (col <= row) {
            print("$count")
            ++count
            ++col
        }

        println()

        ++row
    }
}



