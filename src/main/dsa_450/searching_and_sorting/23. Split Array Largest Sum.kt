package searching_and_sorting

/**
 *    https://leetcode.com/problems/split-array-largest-sum/description/
 *    Time complexity: O(n log(n))
 *    Space complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(7, 2, 5, 10, 8)
    println(splitArray(arr, 2))
    arr = intArrayOf(1, 2, 3, 4, 5)
    println(splitArray(arr, 2))
}

private fun splitArray(nums: IntArray, k: Int): Int {

    var maxi = nums[0]
    var sum = 0

    for (value in nums) {
        maxi = Math.max(maxi, value)
        sum += value
    }

    // start binary search
    var start = maxi
    var end = sum
    var mid = start + (end - start) / 2

    while (start <= end) {

        val partitions = countPartitions(nums, mid)

        if (partitions > k) {
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    return start
}

private fun countPartitions(nums: IntArray, maxSum: Int): Int {

    var partitions = 1
    var subarraySum = 0

    for (value in nums) {

        if (value + subarraySum <= maxSum) {
            // insert element to current subarray
            subarraySum += value
        } else {
            // insert element to next subarray
            partitions++
            subarraySum = value
        }
    }

    return partitions
}


















