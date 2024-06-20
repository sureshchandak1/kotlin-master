package array

/**
 *   https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 *   Time Complexity: O(N)
 *   Auxiliary Space: O(1)
 */
fun main() {
    var arr = intArrayOf(1, 2, 3, -2, 5)
    println(maxSubArraySum(arr, arr.size))
    maxSubArraySum1(arr, arr.size)

    arr = intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
    println(maxSubArraySum(arr, arr.size))
    maxSubArraySum1(arr, arr.size)
}

private fun maxSubArraySum(arr: IntArray, n: Int): Long {
    var maxSum = Int.MIN_VALUE.toLong()
    var sum: Long = 0

    for (i in 0..< n) {
        sum += arr[i].toLong()

        if (maxSum < sum) {
            maxSum = sum
        }
        if (sum < 0) {
            sum = 0
        }
    }

    return maxSum
}

private fun maxSubArraySum1(arr: IntArray, size: Int) {
    var maxSum = Int.MIN_VALUE
    var sum = 0
    var start = 0
    var end = 0
    var s = 0

    for (i in 0..< size) {
        sum += arr[i]

        if (maxSum < sum) {
            maxSum = sum
            start = s
            end = i
        }

        if (sum < 0) {
            sum = 0
            s = i + 1
        }
    }
    println("Maximum contiguous sum is $maxSum")
    println("Starting index $start")
    println("Ending index $end")
}




