package searching_and_sorting

import java.util.*
import kotlin.math.max

/**
 *    https://www.geeksforgeeks.org/problems/aggressive-cows/0
 *    Time Complexity: O(N log(N))
 *    Space Complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(1, 2, 4, 8, 9)
    println(solve(arr.size, 3, arr))
    arr = intArrayOf(0, 3, 4, 7, 10, 9)
    println(solve(arr.size, 4, arr))
}

private fun solve(n: Int, k: Int, stalls: IntArray): Int {

    Arrays.sort(stalls)

    var maxi = Int.MIN_VALUE

    for (stall in stalls) {
        maxi = max(maxi.toDouble(), stall.toDouble()).toInt()
    }

    // binary search
    var start = 0
    var end = maxi
    var mid = start + (end - start) / 2

    var ans = -1

    while (start <= end) {
        if (isPossible(stalls, k, mid)) {
            ans = mid
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    return ans
}

private fun isPossible(stalls: IntArray, k: Int, mid: Int): Boolean {
    var cowCount = 1
    var lastPos = stalls[0]

    for (stall in stalls) {
        if (stall - lastPos >= mid) {
            cowCount++

            if (cowCount == k) {
                return true
            }

            lastPos = stall
        }
    }

    return false
}



















