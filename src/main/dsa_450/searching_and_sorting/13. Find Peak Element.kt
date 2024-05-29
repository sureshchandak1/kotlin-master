package searching_and_sorting

/**
 *   https://leetcode.com/problems/find-peak-element/description/
 *   Time complexity: O(log n)
 *   Space complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(1, 2, 3, 1)
    println(findPeakElement(arr))
    arr = intArrayOf(1, 2, 1, 3, 5, 6, 4)
    println(findPeakElement(arr))
    arr = intArrayOf(3, 4, 3, 2, 1)
    println(findPeakElement(arr))
    arr = intArrayOf(1, 2, 1, 2, 1)
    println(findPeakElement(arr))
}

private fun findPeakElement(nums: IntArray): Int {

    val n = nums.size

    if (n == 0) return -1
    if (n == 1) return 0
    if (nums[0] > nums[1]) return 0
    if (nums[n - 1] > nums[n - 2]) return n - 1

    return findPeak2(nums, n)
}

private fun findPeak1(nums: IntArray, n: Int): Int {

    var start = 0
    var end = n - 1

    while (start <= end) {

        val mid = start + (end - start) / 2

        if ((mid + 1 < n && nums[mid] > nums[mid + 1]) && (mid - 1 >= 0 && nums[mid] > nums[mid - 1])) {
            return mid
        }

        if (mid - 1 >= 0 && nums[mid] > nums[mid - 1]) {
            // we are in the left half
            start = mid + 1
        } else if (mid + 1 < n && nums[mid] > nums[mid + 1]) {
            // we are in the right half
            end = mid
        }

    }

    return -1
}

private fun findPeak2(nums: IntArray, n: Int): Int {

    var start = 0
    var end = n - 1

    while (start < end) {

        val mid = start + (end - start) / 2

        if (nums[mid] < nums[mid + 1]) {
            start = mid + 1
        } else {
            end = mid
        }
    }

    return start
}















