package searching_and_sorting

/**
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    val arr = intArrayOf(3, 5, 8, 9, 15, 19)
    println(upperBound(arr, arr.size, 9))
    println(upperBound(arr, arr.size, 15))
    println(upperBound(arr, arr.size, 19))
    println(upperBound(arr, arr.size, 20))
}

// The upper bound algorithm finds the first or the smallest index in a sorted array
// where the value at that index is greater than the given key i.e. x.
private fun upperBound(arr: IntArray, n: Int, x: Int): Int {

    var low = 0
    var high = n - 1
    var ans = -1

    while (low <= high) {

        val mid = low + (high - low) / 2

        if (arr[mid] > x) {
            ans = mid
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return ans
}