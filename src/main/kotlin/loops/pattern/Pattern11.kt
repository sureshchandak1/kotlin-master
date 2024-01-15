package loops.pattern

/*
*                 1 2 3 4 5 5 4 3 2 1
*                 1 2 3 4 * * 4 3 2 1
*                 1 2 3 * * * * 3 2 1
*                 1 2 * * * * * * 2 1
*                 1 * * * * * * * * 1
* */

fun main(args: Array<String>) {
    printPattern1(5)
    println("------------------")
}

private fun printPattern1(n: Int) {
    var row = 1
    while (row <= n) {

        // print 1st triangle
        var col1 = 1
        while (col1 <= (n - row) + 1) {
            print("$col1")
            ++col1
        }


        // print 2nd triangle
        if (row > 0) {
            val starCount = 2
            var col2 = 0
            while (col2 < starCount) {
                print("*")
                ++col2
            }
        }


        // print 3rd triangle


        println()

        ++row
    }
}








