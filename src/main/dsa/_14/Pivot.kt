package _14

fun main() {
    val arr = intArrayOf( 3, 8, 10, 17, 1)
    val result = pivotIndex(arr)
    println(result)

    //println("Max = ${pivotIndex1(intArrayOf(7, 9, 1, 2, 3, 4))}")
    //println("Max = ${pivotIndex1(arr)}")
}

private fun pivotIndex(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1
    var mid = start + (end - start) / 2

    while (start < end) {

        if (nums[mid] >= nums[0]) {
            start = mid + 1
        } else {
            end = mid
        }

        mid = start + (end - start) / 2
    }

    return start
}

private fun pivotIndex1(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1
    var mid = start + (end - start) / 2

    while (start < end) {

        if (nums[mid] < nums[0]) {
            end = mid - 1
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return start
}