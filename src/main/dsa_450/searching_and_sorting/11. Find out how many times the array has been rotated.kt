package searching_and_sorting

/**
 *    https://www.geeksforgeeks.org/problems/rotation4723/1
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(66, 67, 7, 10, 14, 19, 27, 33, 36, 40, 44, 54, 60)
    println(findRotation1(arr, arr.size)); println(findRotation2(arr, arr.size)); println()

    arr = intArrayOf(5, 1, 2, 3, 4)
    println(findRotation1(arr, arr.size)); println(findRotation2(arr, arr.size)); println()

    arr = intArrayOf(1, 2, 3, 4, 5)
    println(findRotation1(arr, arr.size)); println(findRotation2(arr, arr.size)); println()

}

private fun findRotation1(arr: IntArray, n: Int): Int {
    var start = 0
    var end = n - 1
    var mini = Int.MAX_VALUE
    var minIndex = 0

    if (arr[start] <= arr[end]) {
        return 0
    }

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (arr[start] <= arr[end]) {
            if (mini > arr[start]) {
                minIndex = start
            }
            break
        }

        // check left part
        if (arr[mid] >= arr[start]) {
            if (mini > arr[start]) {
                minIndex = start
                mini = arr[start]
            }
            start = mid + 1
        } else if (arr[mid] <= arr[end]) { // check right part
            if (mini > arr[mid]) {
                minIndex = mid
                mini = arr[mid]
            }
            end = mid - 1
        }
    }

    return minIndex
}

private fun findRotation2(arr: IntArray, n: Int): Int {
    var start = 0
    var end = n - 1

    while (start < end) {
        val mid = start + (end - start) / 2

        if (arr[mid] < arr[end]) {
            end = mid
        } else {
            start = mid + 1
        }
    }

    return start
}













