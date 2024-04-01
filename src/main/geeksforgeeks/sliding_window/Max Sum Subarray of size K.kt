package sliding_window

import kotlin.math.max

/*
*   https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
* */
fun main() {
    var arr = arrayListOf(100, 200, 300, 400)
    println(maximumSumSubArray(2, arr, arr.size))

    arr = arrayListOf(100, 200, 300, 400, 500, 600)
    println(maximumSumSubArray(4, arr, arr.size))

    arr = arrayListOf(100, 200, 300, 400)
    println(maximumSumSubArray(4, arr, arr.size))
}

private fun maximumSumSubArray(k: Int, arr: ArrayList<Int>, n: Int): Long {

    var i = 0 // start
    var j = 0 // end

    var sum = 0L
    var maxi = Long.MIN_VALUE

    while (j < n) {

        sum += arr[j].toLong()

        if (j - i + 1 < k) {
            j++
        } else if (j - i + 1 == k) {
            maxi = max(maxi.toDouble(), sum.toDouble()).toLong()

            sum -= arr[i] // Remove window exit value

            i++
            j++
        }
    }

    return maxi
}