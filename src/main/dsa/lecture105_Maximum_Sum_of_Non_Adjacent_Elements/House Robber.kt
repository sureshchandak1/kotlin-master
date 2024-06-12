package lecture105_Maximum_Sum_of_Non_Adjacent_Elements

/**
 *    https://leetcode.com/problems/house-robber/
 */
fun main() {
    var arr = intArrayOf(1, 2, 3, 1)
    println(rob(arr))
    arr = intArrayOf(2, 7, 9, 3, 1)
    println(rob(arr))
    arr = intArrayOf(1, 2)
    println(rob(arr))
}

private fun rob(nums: IntArray): Int {
    val size = nums.size

    //val ans = robMoneyRec(nums, size - 1)
    //return ans

    //val dp = IntArray(size) { -1 }
    //return robMoneyMem(nums, size-1, dp)

    //return robMoneyTab(nums)

    return robMoneyOptimize(nums)
}

// Recursion
private fun robMoneyRec(nums: IntArray, n: Int): Int {

    // Base case
    if (n < 0) return 0
    if (n == 0) return nums[0]

    // include current element
    val include = robMoneyRec(nums, n - 2) + nums[n]

    // exclude current element
    val exclude = robMoneyRec(nums, n - 1)

    return Math.max(include, exclude)
}

// Recursion + Memoisation
// T.C = O(n), S.C = O(n) + O(n)
private fun robMoneyMem(nums: IntArray, n: Int, dp: IntArray): Int {

    // Base case
    if (n < 0) return 0
    if (n == 0) return nums[0]

    if (dp[n] != -1) return dp[n]

    // include current element
    val include = robMoneyRec(nums, n - 2) + nums[n]

    // exclude current element
    val exclude = robMoneyRec(nums, n - 1)

    dp[n] = Math.max(include, exclude)
    return dp[n]
}

// Tabulation
// T.C = O(n), S.C = O(n)
private fun robMoneyTab(nums: IntArray): Int {

    val n = nums.size

    val dp = IntArray(n) { 0 }

    dp[0] = nums[0]

    for (i in 1..<n) {
        val include = if (i - 2 >= 0) dp[i - 2] + nums[i] else nums[i]
        val exclude = dp[i - 1]

        dp[i] = Math.max(include, exclude)
    }

    return dp[n - 1]
}

// Space optimization
// T.C = O(n), S.C = O(1)
private fun robMoneyOptimize(nums: IntArray): Int {

    val n = nums.size

    var prev1 = nums[0]
    var prev2 = 0

    for (i in 1..<n) {
        val include = prev2 + nums[i]
        val exclude = prev1

        val ans = Math.max(include, exclude)
        prev2 = prev1
        prev1 = ans
    }

    return prev1
}













