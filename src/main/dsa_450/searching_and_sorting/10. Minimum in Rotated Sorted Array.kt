package searching_and_sorting

/**
 *    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(3, 4, 5, 1, 2)
    println(findMin(arr))
    println(findMinimum(arr))
    println()
    arr = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    println(findMin(arr))
    println(findMinimum(arr))
    println()
    arr = intArrayOf(11, 13, 15, 17)
    println(findMin(arr))
    println(findMinimum(arr))
    println()
    arr = intArrayOf(0, 1, 2, 4, 5, 6, 7)
    println(findMin(arr))
    println(findMinimum(arr))
    println()
}

private fun findMin(nums: IntArray): Int {

    var start = 0
    var end = nums.size - 1

    while (start < end) {

        val mid = start + (end - start) / 2

        if (nums[mid] < nums[end]) {
            end = mid
        } else {
            start = mid + 1
        }
    }

    return nums[start]
}

private fun findMinimum(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1
    var ans = Int.MAX_VALUE

    if (nums[start] <= nums[end]) {
        return nums[start]
    }

    while (start <= end) {

        val mid = start + (end - start) / 2

        if (nums[start] <= nums[end]) {
            ans = Math.min(ans, nums[start])
            break
        }

        if (nums[mid] >= nums[start]) { // check left part is sorted or not
            ans = Math.min(ans, nums[start])

            start = mid + 1
        } else if (nums[mid] <= nums[end]) { // check right part is sorted or not
            ans = Math.min(ans, nums[mid])

            end = mid - 1
        }
    }

    return ans
}












