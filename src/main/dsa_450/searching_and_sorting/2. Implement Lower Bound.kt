package searching_and_sorting

/**
 *    https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    val arr = longArrayOf(1,2,8,10,11,12,19)
    println(findFloor(arr, arr.size, 0))
    println(findFloor(arr, arr.size, 5))
}

private fun findFloor(arr: LongArray, n: Int, x: Long): Int {

    // If last element is smaller than x
    if (x >= arr[n - 1]) return n - 1

    // If first element is greater than x
    if (x < arr[0]) return -1

    var start = 0
    var end = n - 1
    var mid = start + (end - start) / 2

    var ans = -1

    while (start <= end) {

        if (arr[mid] == x) return mid

        // If x lies between mid-1 and mid
        if (mid > 0 && x >= arr[mid - 1] && x < arr[mid]) return mid - 1

        if (arr[mid] > x) {
            ans = mid
            end = mid - 1
        } else if (arr[mid] < x) {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return ans
}













