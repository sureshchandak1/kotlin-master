package lecture111_Combination_Sum_IV_Problem

/**
 *    https://leetcode.com/problems/combination-sum-iv/description/
 */
fun main() {
    println(findWays(intArrayOf(1, 2, 3), 4))
    println(findWays(intArrayOf(9), 3))
    println(findWays(intArrayOf(1, 2, 5), 5))
}

private fun findWays(num: IntArray, tar: Int): Int {

    //return solve(num, tar)

    /*val dp = IntArray(tar + 1)
    Arrays.fill(dp, -1)
    return solveMem(num, tar, dp)*/

    return solveTab(num, tar)
}

// Recursion
// T.C = exponentially
private fun solve(num: IntArray, tar: Int): Int {

    // base case
    if (tar < 0) return 0
    if (tar == 0) return 1

    var ans = 0
    for (i in num.indices) {
        ans += solve(num, tar - num[i])
    }

    return ans
}

// Memoization
// T.C = O(n), S.C = O(n) + O(n)
private fun solveMem(num: IntArray, tar: Int, dp: IntArray): Int {

    // base case
    if (tar < 0) return 0
    if (tar == 0) return 1

    if (dp[tar] != -1) return dp[tar]

    var ans = 0
    for (i in num.indices) {
        ans += solveMem(num, tar - num[i], dp)
    }

    dp[tar] = ans
    return dp[tar]
}

// Tabulation
// T.C = O(n), S.C = O(n)
private fun solveTab(num: IntArray, tar: Int): Int {

    // step1
    val dp = IntArray(tar + 1) { 0 }

    // step2: set base value
    dp[0] = 1

    // traversing from target 1 to tar
    for (i in 1..tar) {

        // traversing on num array
        for (j in num.indices) {
            if (i - num[j] >= 0) {
                dp[i] += dp[i - num[j]]
            }
        }
    }

    return dp[tar]
}









