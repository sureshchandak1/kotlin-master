fun main() {
    val n = readlnOrNull()
    n?.let {
        printCounting1(it.toInt())
        println()
        printCounting2(it.toInt())
    }
}

private fun printCounting1(n: Int) {

    // Base case
    if (n == 0) return

    println(n)

    printCounting1(n - 1)
}

private fun printCounting2(n: Int) {

    // Base case
    if (n == 0) return

    printCounting2(n - 1)

    println(n)
}