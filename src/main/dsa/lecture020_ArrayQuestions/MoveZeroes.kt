package lecture020_ArrayQuestions

import printArray

fun main() {
    val arr = intArrayOf(0, 1, 0, 3, 12)
    printArray(arr)
    moveZeroes(arr)
    printArray(arr)
}

fun moveZeroes(nums: IntArray): Unit {

    var index = -1

    var temp = -1
    for (i in nums.indices) {
        if (nums[i] != 0) {
            index++

            temp = nums[index]
            nums[index] = nums[i]
            nums[i] = temp
        }
    }

}