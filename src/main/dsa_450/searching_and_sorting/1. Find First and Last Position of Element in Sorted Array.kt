package searching_and_sorting

import printArray

/**
 *    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(5, 7, 7, 8, 8, 10)
    printArray(searchRange(arr, 8))

    arr = intArrayOf(5, 7, 7, 8, 8, 10)
    printArray(searchRange(arr, 6))
}

private fun searchRange(nums: IntArray, target: Int): IntArray {

    val result = IntArray(2)

    firstPosition(nums, target, result)
    lastPosition(nums, target, result)

    return result
}

private fun firstPosition(nums: IntArray, target: Int, result: IntArray) {

    var start = 0
    var end = nums.size - 1
    var mid = start + (end - start) / 2
    var ans = -1

    while (start <= end) {

        if (target == nums[mid]) {
            ans = mid
            end = mid - 1
        } else if (target > nums[mid]) {
            start = mid + 1
        } else if (target < nums[mid]) {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    result[0] = ans
}

private fun lastPosition(nums: IntArray, target: Int, result: IntArray) {

    var start = 0
    var end = nums.size - 1
    var mid = start + (end - start) / 2
    var ans = -1

    while (start <= end) {

        if (target == nums[mid]) {
            ans = mid
            start = mid + 1
        } else if (target > nums[mid]) {
            start = mid + 1
        } else if (target < nums[mid]) {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    result[1] = ans
}





