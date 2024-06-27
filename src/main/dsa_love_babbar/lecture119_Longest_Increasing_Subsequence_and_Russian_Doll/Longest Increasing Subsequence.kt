package lecture119_Longest_Increasing_Subsequence_and_Russian_Doll

/**
 *    https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
fun main() {
    println(lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
    println(lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
    println(lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
}

private fun lengthOfLIS(nums: IntArray): Int {
    //return solve(nums, 0, -1)

    //val n = nums.size
    //val dp = Array(n) { IntArray(n + 1) { -1 } }
    //return solveMem(nums, 0, -1, dp)

    //return solveTab(nums)

    //return solveSC(nums)

    return solveBinarySearch(nums)
}

// Recursion
private fun solve(nums: IntArray, curr: Int, prev: Int): Int {

    // Base case
    if (curr == nums.size) {
        return 0
    }

    var include = 0
    if (prev == -1 || nums[curr] > nums[prev]) {
        include = 1 + solve(nums, curr + 1, curr)
    }

    val exclude = 0 + solve(nums, curr + 1, prev)

    return Math.max(include, exclude)
}

// Recursion + Memorization
// T.C = O(n * n), S.C = O(n * n)
private fun solveMem(nums: IntArray, curr: Int, prev: Int, dp: Array<IntArray>): Int {

    // Base case
    if (curr == nums.size) {
        return 0
    }

    if (dp[curr][prev + 1] != -1) {
        return dp[curr][prev + 1]
    }

    var include = 0
    if (prev == -1 || nums[curr] > nums[prev]) {
        include = 1 + solveMem(nums, curr + 1, curr, dp)
    }

    val exclude = 0 + solveMem(nums, curr + 1, prev, dp)

    dp[curr][prev + 1] = Math.max(include, exclude)

    return dp[curr][prev + 1]
}

// Tabulation: Bottom-Up
// T.C = O(n * n), S.C = O(n * n)
private fun solveTab(nums: IntArray): Int {

    val n = nums.size
    val dp = Array(n + 1) { IntArray(n + 1) }

    for (curr in n - 1 downTo 0) {
        for (prev in curr - 1 downTo -1) {

            var include = 0
            if (prev == -1 || nums[curr] > nums[prev]) {
                include = 1 + dp[curr + 1][curr + 1]
            }

            val exclude = 0 + dp[curr + 1][prev + 1]

            dp[curr][prev + 1] = Math.max(include, exclude)

        }
    }

    return dp[0][0]
}

// Space Optimization
// T.C = O(n * n), S.C = O(n)
private fun solveSC(nums: IntArray): Int {

    val n = nums.size

    val currRow = IntArray(n + 1)
    var nextRow = IntArray(n + 1)

    for (curr in n - 1 downTo 0) {
        for (prev in curr - 1 downTo -1) {

            var include = 0
            if (prev == -1 || nums[curr] > nums[prev]) {
                include = 1 + nextRow[curr + 1]
            }

            val exclude = 0 + nextRow[prev + 1]

            currRow[prev + 1] = Math.max(include, exclude)

        }

        nextRow = currRow.copyOf(currRow.size)
    }

    return nextRow[0]
}

// DP + Binary Search
// T.C = O(n log n)
private fun solveBinarySearch(nums: IntArray): Int {
    val n = nums.size

    if (n == 0) return 0

    val ans = ArrayList<Int>()
    ans.add(nums[0])

    for (i in 1..<n) {

        if (nums[i] > ans.last()) {
            ans.add(nums[i])
        } else {
            // find index of just bigger element in ans
            val index = lowerBound(ans, nums[i])
            ans[index] = nums[i]
        }
    }

    return ans.size
}

private fun lowerBound(arr: ArrayList<Int>, element: Int): Int {

    val size = arr.size
    var start = 0
    var end = size - 1
    var mid = start + (end - start) / 2

    while (start < end) {

        if (arr[mid] < element) {
            start = mid + 1
        } else {
            end = mid
        }

        mid = start + (end - start) / 2
    }

    return start
}













