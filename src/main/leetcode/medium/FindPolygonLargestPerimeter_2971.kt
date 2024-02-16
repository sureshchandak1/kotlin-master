package medium

import java.util.Arrays

fun main() {
    val arr1 = intArrayOf(1, 12, 1, 2, 5, 50, 3)
    val arr2 = intArrayOf(5, 5, 5)
    val arr3 = intArrayOf(5, 5, 50)

    println(largestPerimeter(arr1))
    println(largestPerimeter(arr2))
    println(largestPerimeter(arr3))
}

private fun largestPerimeter(nums: IntArray): Long {

    Arrays.sort(nums)

    val size = nums.size

    var endIndex = size - 1

    while (endIndex >= 2) {

        val max = nums[endIndex]

        var sum: Long = 0
        var i = endIndex - 1
        while (i >= 0) {
            sum += nums[i--]
        }

        if (sum > max) {
            return sum + max
        }

        endIndex--

    }

    return -1

}