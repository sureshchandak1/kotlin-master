import java.util.*

fun main() {
    var arr = intArrayOf(3, -6, 7, -7, 0)
    println(minDiff(arr.size, arr))
    arr = intArrayOf(-3, 3)
    println(minDiff(arr.size, arr))
}

private fun minDiff(n: Int, arr: IntArray): Int {

    Arrays.sort(arr)

    var ans = Int.MAX_VALUE

    for (i in 0..<n - 1) {
        if (arr[i + 1] - arr[i] < ans) {
            ans = arr[i + 1] - arr[i]
        }
    }

    return ans
}