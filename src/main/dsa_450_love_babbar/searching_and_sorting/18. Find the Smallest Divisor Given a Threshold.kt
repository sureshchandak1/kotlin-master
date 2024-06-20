package searching_and_sorting

/**
 *   https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 *   Time complexity: O(n log(n))
 *   Space complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(1, 2, 5, 9)
    println(smallestDivisor(arr, 6))
    arr = intArrayOf(44, 22, 33, 11, 1)
    println(smallestDivisor(arr, 5))
}

private fun smallestDivisor(nums: IntArray, threshold: Int): Int {

    if (nums.size > threshold) {
        return -1
    }

    var maxi = Int.MIN_VALUE
    for (value in nums) {
        maxi = Math.max(maxi, value)
    }

    // binary search
    var start = 1
    var end = maxi
    var mid = start + (end - start) / 2

    while (start <= end) {

        if (sumByDivisor(nums, mid.toDouble()) <= threshold) {
            end = mid - 1
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return start
}

private fun sumByDivisor(nums: IntArray, div: Double): Int {

    var sum = 0.0

    for (value in nums) {
        sum += Math.ceil(value.toDouble() / div)
    }

    return sum.toInt()
}
















