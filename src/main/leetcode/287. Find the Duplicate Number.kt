/***
 *  Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *  There is only one repeated number in nums, return this repeated number.
 *  You must solve the problem without modifying the array nums and uses only constant extra space.
 ***/

fun main() {
    println(findDuplicateNumber1(intArrayOf(1, 3, 4, 2, 2)))
    println(findDuplicateNumber2(intArrayOf(1, 3, 4, 2, 2)))

    println(findDuplicateNumber1(intArrayOf(3, 1, 3, 4, 2)))
    println(findDuplicateNumber2(intArrayOf(3, 1, 3, 4, 2)))

}

private fun findDuplicateNumber1(nums: IntArray): Int {

    var ans = 0

    for (value in nums) {
        ans = ans xor value
    }

    for (index in nums.indices) {
        ans = ans xor index
    }

    return ans
}

private fun findDuplicateNumber2(nums: IntArray): Int {

    var start = 0
    var end = nums.size - 1
    var mid = start + (end - start) / 2

    while (start < end) {

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

