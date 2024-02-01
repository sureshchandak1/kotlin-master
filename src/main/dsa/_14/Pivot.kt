package _14

fun main() {
    val arr = intArrayOf(1, 3, 8, 10, 17)
    val result = pivotIndex(arr)
    println(result)
}

private fun pivotIndex(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1
    var mid = start + (end - start) / 2

    while (start < end) {

        if (nums[mid] > nums[end]) {
            start = mid + 1
        } else {
            end = mid
        }

        mid = start + (end - start) / 2

    }

    return start
}