package lecture021_Solving_ArrayQuestions2

import lecture020_ArrayQuestions.reverseArray
import printArray

fun main(args: Array<String>) {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    printArray(arr)
    val k = 3
    rotate(arr, k)

    printArray(arr)
}

fun rotate(nums: IntArray, k: Int) {
    // Assign the input array to the class-level variable
    var k = k

    // Number of elements in the array
    val n = nums.size

    // Normalize the number of steps k to avoid extra rotations
    k %= n

    // Reverse the entire array
    reverseArray(nums, 0, n - 1)

    // Reverse the first part (up to k elements)
    reverseArray(nums, 0, k - 1)

    // Reverse the second part (from k to the end of the array)
    reverseArray(nums, k, n - 1)
}

