package _15

import java.util.*


fun main() {
    val arr = intArrayOf(0, 3, 4, 7, 10, 9)
    val result = aggressiveCows(arr, 4)
    println(result)
}

private fun aggressiveCows(stalls: IntArray, k: Int): Int {
    Arrays.sort(stalls)

    var max = stalls[0]
    for (i in stalls.indices) {
        if (stalls[i] > max) {
            max = stalls[i]
        }
    }

    var start = 0
    var end = max

    var mid = start + (end - start) / 2

    var ans = -1

    while (start <= end) {
        if (isProceed(stalls, k, mid)) {
            ans = mid
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    return ans
}

private fun isProceed(stalls: IntArray, k: Int, mid: Int): Boolean {
    var cowCount = 1
    var lastPos = stalls[0]

    for (i in stalls.indices) {
        if (stalls[i] - lastPos >= mid) {
            cowCount++
            if (cowCount == k) {
                return true
            }
            lastPos = stalls[i]
        }
    }

    return false
}