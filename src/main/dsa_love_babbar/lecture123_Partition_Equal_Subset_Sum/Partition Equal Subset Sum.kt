package lecture123_Partition_Equal_Subset_Sum

/**
 *   https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
 *   https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
fun main() {
    var arr = intArrayOf(1, 5, 11, 5)
    println(equalPartition(arr.size, arr))
    arr = intArrayOf(1, 3, 5)
    println(equalPartition(arr.size, arr))
    arr = intArrayOf(1, 2, 3, 5)
    println(equalPartition(arr.size, arr))
}

private fun equalPartition(n: Int, arr: IntArray): Int {

    var sum = 0
    for (i in 0..<n) {
        sum += arr[i]
    }

    if (sum % 2 != 0) { // odd number
        return 0
    }

    val target = sum / 2

    //return solve(0, N, arr, target)

    /*
    val dp = Array(N) { IntArray(target + 1) }
    for (a in dp) {
        Arrays.fill(a, -1)
    }
    return solveMem(0, N, arr, target, dp)*/

    //return solveTab(N, arr, sum)

    return solveSC(n, arr, sum)
}

// Recursion
private fun solve(index: Int, n: Int, arr: IntArray, target: Int): Int {

    // Base case
    if (index >= n) return 0
    if (target < 0) return 0
    if (target == 0) return 1

    val include = solve(index + 1, n, arr, target - arr[index])

    val exclude = solve(index + 1, n, arr, target)

    return include or exclude
}

// Recursion + Memorization
// T.C = O(n * total/2), S.C = O(n * total/2)
private fun solveMem(index: Int, n: Int, arr: IntArray, target: Int, dp: Array<IntArray>): Int {

    // Base case
    if (index >= n) return 0
    if (target < 0) return 0
    if (target == 0) return 1

    if (dp[index][target] != -1) {
        return dp[index][target]
    }

    val include = solveMem(index + 1, n, arr, target - arr[index], dp)

    val exclude = solveMem(index + 1, n, arr, target, dp)

    dp[index][target] = include or exclude

    return dp[index][target]
}

// Tabulation
// T.C = O(n * total/2), S.C = O(n * total/2)
private fun solveTab(n: Int, arr: IntArray, total: Int): Int {

    val dp = Array(n + 1) { IntArray(total / 2 + 1) }

    // based on base case
    for (i in 0..n) {
        dp[i][0] = 1
    }

    for (index in n - 1 downTo 0) {
        for (target in 0..total / 2) {
            var include = 0
            if (target - arr[index] >= 0) {
                include = dp[index + 1][target - arr[index]]
            }

            val exclude = dp[index + 1][target]

            dp[index][target] = include or exclude
        }
    }

    return dp[0][total / 2]
}

// Space Optimization
// T.C = O(n * total/2), S.C = O(total/2)
private fun solveSC(n: Int, arr: IntArray, total: Int): Int {

    val curr = IntArray(total / 2 + 1)
    var next = IntArray(total / 2 + 1)

    // based on base case
    curr[0] = 1
    next[0] = 1

    for (index in n - 1 downTo 0) {
        for (target in 0..total / 2) {
            var include = 0
            if (target - arr[index] >= 0) {
                include = next[target - arr[index]]
            }

            val exclude = next[target]

            curr[target] = include or exclude
        }

        next = curr.copyOf(curr.size)
    }

    return next[total / 2]
}









