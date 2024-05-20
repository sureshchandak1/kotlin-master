package bit_manipulation.basics

fun main() {
    println("Enter Number: ")
    val n: Int = readln().toInt()

    println(josephusSolution(n))
}

/**
 * @return (2 * l) + 1
 */
private fun josephusSolution(n: Int): Int {
    // highest power of 2
    val hp2 = powerOf2(n)
    val l = n - hp2
    val ans = (2 * l) + 1
    return ans
}

private fun powerOf2(n: Int): Int {
    var i = 1

    while (i * 2 <= n) {
        i *= 2
    }

    return i
}