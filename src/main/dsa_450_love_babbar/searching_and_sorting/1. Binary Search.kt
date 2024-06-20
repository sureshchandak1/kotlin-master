package searching_and_sorting

/**
 *    https://leetcode.com/problems/binary-search/description/
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    val arr = intArrayOf(-1, 0, 3, 5, 9, 12)
    println(binarySearch(arr, 9))
    println(binarySearch(arr, 2))
}

private fun binarySearch(nums: IntArray, target: Int): Int {

    var start = 0
    var end = nums.size - 1
    var mid = start + (end - start) / 2

    while (start <= end) {

        if (nums[mid] == target) {
            return mid
        }

        if (target > nums[mid]) {
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    return -1

}



