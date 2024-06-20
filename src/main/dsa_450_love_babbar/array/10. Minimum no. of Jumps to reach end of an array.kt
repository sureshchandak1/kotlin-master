package array

import kotlin.math.max

/**
 *   https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
 *   Time Complexity: O(N)
 *   Space Complexity: O(1)
 */
fun main() {
    println(minJumps(intArrayOf(0)))
    println(minJumps(intArrayOf(0, 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))
    println(minJumps(intArrayOf(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))
}

private fun minJumps(arr: IntArray): Int {

    var max = 0
    var jump = 0
    var halt = 0
    val length = arr.size

    if (length == 1 && arr[0] == 0) {
        return 0
    }
    if (arr[0] == 0) {
        return -1
    }

    for (i in 0..< length - 1) {
        max = max(max.toDouble(), (i + arr[i]).toDouble()).toInt()

        /*if (max >= length - 1) {
            jump++
            return jump
        }*/

        if (i == halt) {
            halt = max
            jump++
        }
    }

    if (halt >= length - 1) {
        return jump
    }

    return -1
}




