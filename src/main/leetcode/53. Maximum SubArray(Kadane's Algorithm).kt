/**
 *   https://leetcode.com/problems/maximum-subarray
 *
 *   Kadane's Algorithm
 */
fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
}

private fun maxSubArray(nums: IntArray): Int {

    var max: Int = Int.MIN_VALUE
    var sum = 0

    val size = nums.size
    for (i in 0..<size) {
        sum += nums[i]
        if (max < sum) {
            max = sum
        }
        if (sum < 0) {
            sum = 0
        }
    }

    return max
}