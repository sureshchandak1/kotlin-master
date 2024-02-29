import java.util.*

fun main() {
    var arr = intArrayOf(3, 4, 2, 1)
    printArray(kLargest(arr, 2, arr.size))
    arr = intArrayOf(2, 2, 3, 3, 1)
    printArray(kLargest(arr, 1, arr.size))
    arr = intArrayOf(0, 10, 1, 2, 2)
    printArray(kLargest(arr, 5, arr.size))
    arr = intArrayOf(-2, 12, -1, 1, 20, 1)
    printArray(kLargest(arr, 2, arr.size))
}

private fun kLargest(a: IntArray, k: Int, n: Int): IntArray {
    Arrays.sort(a)

    val ans = IntArray(k)

    var end = n - k
    var count = 0
    while (count < k) {
        ans[count++] = a[end++]
    }

    return ans
}