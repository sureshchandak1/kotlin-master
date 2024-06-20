package searching_and_sorting

/**
 *    https://leetcode.com/problems/search-insert-position/description/
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    val arr = intArrayOf(1,3,5,6)
    println(searchInsert(arr, 5))
    println(searchInsert(arr, 2))
    println(searchInsert(arr, 7))
}

private fun searchInsert(nums: IntArray, target: Int): Int {

    var start = 0
    var end = nums.size
    var mid = start + (end - start) / 2

    while (start < end) {

        if (nums[mid] >= target) {
            end = mid
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2

    }

    return start

}









