package searching_and_sorting

/**
 *    https://leetcode.com/problems/kth-missing-positive-number/description/
 *    Time Complexity: O(logN)
 *    Space Complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(2, 3, 4, 7, 11)
    println(findKthPositive(arr, 5))
    arr = intArrayOf(1, 2, 3, 4)
    println(findKthPositive(arr, 2))
}

private fun findKthPositive(arr: IntArray, k: Int): Int {

    var start = 0
    var end = arr.size - 1
    var mid = start + (end - start) / 2

    while (start <= end) {

        val missing = arr[mid] - (mid + 1)

        if (missing < k) {
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    return k + end + 1
}










