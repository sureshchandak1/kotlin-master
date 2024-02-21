fun main() {
    val arr1: List<Int> = listOf(1, -4, 2, 10, -2, 3, 1, 0, -20)
    println(minSubArraySum(arr1, 8, 4))
}

private fun minSubArraySum(arr: List<Int>, n: Int, k: Int): Int {
    var minSum = 0

    var index = 0
    while (index < n - k + 1) {

        var sum = 0
        var j = 0
        while (j < k) {
            sum += arr[index + j]
            j++
        }
        println("index = $index, Sum = $sum, minSum = $minSum")

        if (minSum == 0 || sum < minSum) {
            minSum = sum
        }

        index++
    }

    return minSum
}