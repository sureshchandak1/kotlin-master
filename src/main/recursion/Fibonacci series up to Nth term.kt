/*
*   https://www.geeksforgeeks.org/problems/fibonacci-series-up-to-nth-term/1
* */

fun main() {
    printArray(series(1))
    printArray(series(2))
    printArray(series(5))
    printArray(series(10))
    printArray(series(336))
}

private const val modulo: Long = 1000000007

fun series(n: Int): IntArray {

    /*val ans = IntArray(n + 1)

    ans[0] = 0
    ans[1] = 1

    nthSeries(n + 1, 0, 1, ans, 2)*/

    return nthSeries(n)
}

private fun nthSeries(n: Int): IntArray {

    val ans = IntArray(n + 1)

    ans[0] = 0
    ans[1] = 1

    var first: Long = 0
    var second: Long = 1

    for (i in 2..n) {
        val next = ((first % modulo) + (second % modulo)) % modulo
        first = second
        second = next
        ans[i] = next.toInt()
    }

    return ans
}

private fun nthSeries(n: Int, first: Long, second: Long, ans: IntArray, index: Int) {

    // Base case
    if (n == 0 || index >= n) {
        return
    }

    val next = ((first % modulo) + (second % modulo)) % modulo
    ans[index] = next.toInt()

    nthSeries(n, second, next, ans, index + 1)
}