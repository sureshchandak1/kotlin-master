package searching_and_sorting

/**
 *    Time complexity: O(log n) + O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    val arr = intArrayOf(1, 1, 2, 2, 2, 2, 3)
    println(count(arr, arr.size, 2))
    println(count(arr, arr.size, 4))
}

private fun count(arr: IntArray, n: Int, x: Int): Int {
    val first = findFirst(arr, n, x)

    if (first == -1) return 0

    val last = findLast(arr, n, x)

    return last - first + 1
}

private fun findFirst(arr: IntArray, n: Int, x: Int): Int {
    var start = 0
    var end = n - 1
    var ans = -1

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (arr[mid] == x) {
            ans = mid
            end = mid - 1
        } else if (x > arr[mid]) {
            start = mid + 1
        } else if (x < arr[mid]) {
            end = mid - 1
        }
    }

    return ans
}

private fun findLast(arr: IntArray, n: Int, x: Int): Int {
    var start = 0
    var end = n - 1
    var ans = -1

    while (start <= end) {
        val mid = start + (end - start) / 2

        if (arr[mid] == x) {
            ans = mid
            start = mid + 1
        } else if (x > arr[mid]) {
            start = mid + 1
        } else if (x < arr[mid]) {
            end = mid - 1
        }
    }

    return ans
}











