package searching_and_sorting

/**
 *    distinct values (contains unique elements) (no duplicates)
 *    https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    // distinct values (contains unique elements) (no duplicates)
    val arr = intArrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6)
    var target = 1
    var searchIndex = search(arr, arr.size, target)
    println("Target $target index = $searchIndex")
    target = 8
    searchIndex = search(arr, arr.size, target)
    println("Target $target index = $searchIndex")
    target = 10
    searchIndex = search(arr, arr.size, target)
    println("Target $target index = $searchIndex")
    target = 5
    searchIndex = search(arr, arr.size, target)
    println("Target $target index = $searchIndex")
}

private fun search(arr: IntArray, n: Int, target: Int): Int {

    var start = 0
    var end = n - 1

    while (start <= end) {

        val mid = start + (end - start) / 2

        if (target == arr[mid]) {
            return mid
        }

        if (arr[start] <= arr[mid]) { // check left part is sorted or not
            if (target >= arr[start] && target <= arr[mid]) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        } else if (arr[mid] <= arr[end]) { // check right part is sorted or not
            if (target >= arr[mid] && target <= arr[end]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }

    return -1
}