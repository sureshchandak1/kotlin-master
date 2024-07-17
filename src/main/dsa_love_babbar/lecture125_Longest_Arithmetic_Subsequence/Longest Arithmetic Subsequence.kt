package lecture125_Longest_Arithmetic_Subsequence

import kotlin.math.max

/**
 *    https://leetcode.com/problems/longest-arithmetic-subsequence/description/
 *    https://www.geeksforgeeks.org/problems/longest-arithmetic-progression1019/1
 *    Time Complexity: O(N + N)
 *    Space Complexity: O(N + N)
 */
fun main() {
    var arr = intArrayOf(1, 7, 10, 13, 14, 19)
    println(lengthOfLongestAP(arr, arr.size))

    arr = intArrayOf(2, 4, 6, 8, 10)
    println(lengthOfLongestAP(arr, arr.size))
}

private fun lengthOfLongestAP(arr: IntArray, n: Int): Int {

    if (n <= 2) {
        return n
    }

    var ans = 0

    /*
    for (i in 0..<n) {
        for (j in i + 1..<n) {
            val temp = 2 + solve(i, arr[j] - arr[i], arr)
            ans = max(ans.toDouble(), temp.toDouble()).toInt()
        }
    }
     */

    /*
    val dp: MutableList<MutableMap<Int, Int>> = ArrayList()
    for (i in 0..n + 1) {
        dp.add(HashMap())
    }

    for (i in 0..<n) {
        for (j in i + 1..<n) {
            val temp = 2 + solveMem(i, arr[j] - arr[i], arr, dp)
            ans = max(ans.toDouble(), temp.toDouble()).toInt()
        }
    }

    return ans
     */

    return solveTab(arr, n)
}

// Backward check
private fun solve(index: Int, diff: Int, arr: IntArray): Int {

    // Base case
    if (index < 0) {
        return 0
    }

    var ans = 0

    for (j in index - 1 downTo 0) {
        if (arr[index] - arr[j] == diff) {
            val temp = 1 + solve(j, diff, arr)
            ans = max(ans.toDouble(), temp.toDouble()).toInt()
        }
    }

    return ans
}

// Memorization
private fun solveMem(index: Int, diff: Int, arr: IntArray, dp: List<MutableMap<Int, Int>>): Int {

    // Base case
    if (index < 0) {
        return 0
    }

    if (dp[index].containsKey(diff)) {
        return dp[index][diff]!!
    }

    var ans = 0

    for (j in index - 1 downTo 0) {
        if (arr[index] - arr[j] == diff) {
            val temp = 1 + solveMem(j, diff, arr, dp)
            ans = max(ans.toDouble(), temp.toDouble()).toInt()
        }
    }

    dp[index][diff] = ans

    return dp[index][diff]!!
}

// Tabulation
private fun solveTab(arr: IntArray, n: Int): Int {

    val dp = Array<MutableMap<Int, Int>>(n + 1) { HashMap() }

    /*
    val dp: MutableList<MutableMap<Int, Int>> = ArrayList()
    for (i in 0..n + 1) {
        dp.add(HashMap())
    }*/

    var ans = 0

    for (i in 1..<n) {
        for (j in 0..<i) {

            val diff = arr[i] - arr[j]

            var count = 1

            // check if answer already present
            if (dp[j].containsKey(diff)) {
                count = dp[j][diff]!!
            }

            dp[i][diff] = 1 + count

            ans = max(ans.toDouble(), dp[i][diff]!!.toDouble()).toInt()
        }
    }

    return ans
}








