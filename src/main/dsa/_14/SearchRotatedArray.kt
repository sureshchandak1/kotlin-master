package _14

fun main() {
    val arr = intArrayOf(7, 9, 1, 2, 3)
    val search = 2
    val pivot = getPivot(arr)
    val size = arr.size - 1

    if (search >= arr[pivot] && search <= arr[size]) {
        val result = binarySearch(arr, pivot, size, search)
        println(result)
    } else {
        val result = binarySearch(arr, 0, pivot - 1, search)
        println(result)
    }
}

private fun getPivot(nums: IntArray): Int {
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

private fun binarySearch(arr: IntArray, s: Int, e: Int, key: Int): Int {

    var start = s
    var end = e

    var mid = start + (end - start) / 2

    while (start <= end) {

        if (key == arr[mid]) {
            return mid
        }

        if (key > arr[mid]) {
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2

    }

    return -1

}