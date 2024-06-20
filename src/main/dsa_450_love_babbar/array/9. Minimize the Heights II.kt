package array

import java.util.*
import kotlin.math.max
import kotlin.math.min


/**
 *    https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
 *    https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
 *    Time Complexity: O(N * log(N))
 *    Auxiliary Space: O(1)
 */
fun main() {
    var arr = intArrayOf(1, 5, 8, 10)
    var n = arr.size; var k = 2
    println(getMinDiff(arr, n, k))

    arr = intArrayOf(3, 9, 12, 16, 20)
    n = arr.size; k = 3
    println(getMinDiff(arr, n, k))
}

private fun getMinDiff(arr: IntArray, n: Int, k: Int): Int {

    var min = 0
    var max = 0
    var result = 0

    // sort array
    Arrays.sort(arr)

    result = arr[n - 1] - arr[0]

    for (i in 1..< n) {
        if (arr[i] >= k) {
            max = max((arr[i - 1] + k).toDouble(), (arr[n - 1] - k).toDouble()).toInt()
            min = min((arr[i] - k).toDouble(), (arr[0] + k).toDouble()).toInt()

            result = min(result.toDouble(), (max - min).toDouble()).toInt()
        }
    }

    return result
}



