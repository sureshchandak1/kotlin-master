package lecture020_ArrayQuestions

import printArray


fun main() {
    val arr = mutableListOf(1, 2, 3, 4, 5, 6)
    printArray(arr)
    reverseArray(arr, 3)
    printArray(arr)
}

fun reverseArray(arr: MutableList<Int>, m: Int) {
    var start = m + 1
    var end = arr.size - 1

    var temp = 0
    while (start <= end) {

        temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp

        ++start
        --end
    }
}

fun reverseArray(nums: IntArray, i: Int, j: Int) {

    // Using two pointers approach, swap elements until pointers meet or cross
    var i = i
    var j = j
    while (i < j) {
        // Temporary variable to hold a value during the swap
        val temp = nums[i]

        // Perform swap
        nums[i] = nums[j]
        nums[j] = temp

        // Move pointers towards each other
        ++i
        --j
    }
}