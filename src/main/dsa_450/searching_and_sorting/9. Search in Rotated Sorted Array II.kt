package searching_and_sorting

/**
 *    contain duplicate values
 *    https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    // contain duplicate values
    val arr = intArrayOf(2,5,6,0,0,1,2)
    println(search(arr, 0))
    println(search(arr, 3))
}


private fun search(arr: IntArray, target: Int): Boolean {

    var start = 0
    var end = arr.size - 1

    while (start <= end) {

        val mid = start + (end - start) / 2

        if (target == arr[mid]) {
            return true
        }

        // reduce boundary and continue
        if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
            start += 1
            end -= 1
            continue
        }

        // check left part is sorted or not
        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target <= arr[mid]) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        else if (arr[mid] <= arr[end]) { // check right part is sorted or not
            if (target >= arr[mid] && target <= arr[end]) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
    }

    return false

}