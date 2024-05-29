package searching_and_sorting

/**
 *    https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 */
fun main() {
    var arr = intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)
    println(findDuplicate2(arr))

    arr = intArrayOf(3, 3, 7, 7, 10, 11, 11)
    println(findDuplicate2(arr))
}

/**
 *   Time complexity: O(n)
 *   Space complexity: O(1)
 */
private fun findDuplicate1(nums: IntArray): Int {
    var ans = 0;

    for (value in nums) {
        ans = ans xor value
    }

    return ans
}

/**
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
private fun findDuplicate2(nums: IntArray): Int {

    val size = nums.size
    if (size == 1) {
        return nums[0]
    }
    if (nums[0] != nums[1]) {
        return nums[0]
    }
    if (nums[size - 1] != nums[size - 2]) {
        return nums[nums.size - 1]
    }

    var start = 0
    var end = nums.size - 1

    while (start <= end) {

        val mid = start + (end - start) / 2

        // if mid is single element
        if ((mid + 1 < size && nums[mid] != nums[mid + 1]) &&
            (mid - 1 >= 0 && nums[mid] != nums[mid - 1])
        ) {

            return nums[mid]
        }

        // if (i % 2 == 0 and arr[i] == arr[i+1]) or (i%2 == 1 and arr[i] == arr[i-1]), we are in the left half.
        // if (i % 2 == 0 and arr[i] == arr[i-1]) or (i%2 == 1 and arr[i] == arr[i+1]), we are in the right half.
        if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
            (mid % 2 == 1 && nums[mid] == nums[mid - 1])
        ) {

            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    return -1
}













