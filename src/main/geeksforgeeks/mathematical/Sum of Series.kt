package mathematical

/*
*    https://www.geeksforgeeks.org/problems/sum-of-series2811/1
* */

fun main() {
    println(sumSeries(5))
    println(sumSeries(4407895))

    println(sumOfSumSeries(5))
    println(sumOfSumSeries(4407895))
}

/*
*       For n = 5, sum will be 15.
*       1 + 2 + 3 + 4 + 5 = 15.
* */
private fun sumSeries(n: Int): Long {
    if (n == 0 || n == 1) {
        return n.toLong()
    }

    val v = n.toLong()
    val ans = (v * (v + 1)) / 2
    return ans
}

/*
*      Input: N = 5
*      Output: 35
*      Explanation: Sum of sum-series of {1, 2, 3, 4, 5} i.e. {1 + 3 + 6 + 10 + 15} is 35.
*
* */
private fun sumOfSumSeries(n: Int): Long {

    var sum = 0L

    // Calculate sum-series for every natural number and add them
    for (i in 1..n) {
        sum += (i * (i + 1)) / 2
    }

    return sum
}

