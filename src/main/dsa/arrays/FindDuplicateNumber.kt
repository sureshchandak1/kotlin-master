package arrays

/*
*  There is only one repeated number in nums, return this repeated number.
*
*  You must solve the problem without modifying the array nums and uses only constant extra space.
*
* */

fun main() {
    println(findDuplicateNumber(intArrayOf(2, 2, 1, 3, 4)))
}

private fun findDuplicateNumber(nums: IntArray): Int {

    var start = 0
    var end = nums.size - 1
    var mid = start + (end - start) / 2

    while (start < end) {

        println("Mid = $mid")

        var count = 0
        for (value in nums) {
            if (value <= mid) {
                count++
            }
        }

        if (count > mid) {
            end = mid
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2

    }

    return start

}