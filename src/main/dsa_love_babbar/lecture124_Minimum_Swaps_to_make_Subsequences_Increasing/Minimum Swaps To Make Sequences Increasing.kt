package lecture124_Minimum_Swaps_to_make_Subsequences_Increasing

/**
 *    https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/
 */
fun main() {
    println(minSwap(intArrayOf(1, 3, 5, 4), intArrayOf(1, 2, 3, 7)))
    println(minSwap(intArrayOf(0, 3, 5, 8, 9), intArrayOf(2, 1, 4, 6, 9)))
    println(minSwap(
        intArrayOf(4,10,13,14,17,19,21,24,26,27,28,29,34,37,38,42,44,46,48,51,52,53,54,57,58,59,64,65,66,67,71,73,75,76,80,81,82,83,86,88,89,90,95,97,98,99,101,105,106,108,109,110,111,112,115,119,121,122,123,124,125,126,127,128,129,130,131,133,136,138,143,145,147,149,150,153,158,160,163,164,165,167,168,169,172,173,174,176,178,179,183,184,186,188,189,192,193,194,198,200),
        intArrayOf(0,1,3,5,6,7,11,13,15,16,17,21,37,39,41,42,43,45,47,50,53,55,56,57,64,66,67,68,69,70,71,72,74,75,76,77,79,80,87,88,89,95,96,97,98,100,101,105,106,107,108,112,113,115,116,118,119,122,124,125,126,127,128,131,135,136,137,138,139,140,144,145,148,150,151,154,159,160,161,162,163,167,168,170,171,174,176,178,179,180,181,185,187,189,190,191,192,198,199,200)
    ))
}

private fun minSwap(nums1: IntArray, nums2: IntArray): Int {

    val n = nums1.size
    val num1 = IntArray(nums1.size + 1)
    val num2 = IntArray(nums2.size + 1)

    num1[0] = -1
    num2[0] = -1

    var index = 1
    for (i in 0..<nums1.size) {
        num1[index] = nums1[i]
        num2[index] = nums2[i]
        index++
    }

    //return solve(num1, num2, 1, false)

    //val dp = Array(n + 1) { IntArray(2) { -1 } }
    //return solveMem(num1, num2, 1, 0, dp)

    //return solveTab(num1, num2)

    return solveSO(num1, num2)
}

// Recursion
private fun solve(nums1: IntArray, nums2: IntArray, index: Int, swapped: Boolean): Int {

    // Base case
    if (index == nums1.size) {
        return 0
    }

    var ans = Int.MAX_VALUE

    var prev1 = nums1[index - 1]
    var prev2 = nums2[index - 1]

    // we not swap value in arrays, so we swap prev1 and prev2
    if (swapped) {
        val temp = prev1
        prev1 = prev2
        prev2 = temp
    }

    // No-swap
    if (nums1[index] > prev1 && nums2[index] > prev2) {
        ans = solve(nums1, nums2, index + 1, false)
    }

    // swap
    if (nums1[index] > prev2 && nums2[index] > prev1) {
        val temp = 1 + solve(nums1, nums2, index + 1, true)
        ans = Math.min(ans, temp)
    }

    return ans
}

// Recursion + Memorization
// T.C = O(n), S.C = O(n)
private fun solveMem(nums1: IntArray, nums2: IntArray, index: Int, swapped: Int, dp: Array<IntArray>): Int {

    // Base case
    if (index == nums1.size) {
        return 0
    }

    if (dp[index][swapped] != -1) {
        return dp[index][swapped]
    }

    var ans = Int.MAX_VALUE

    var prev1 = nums1[index - 1]
    var prev2 = nums2[index - 1]

    // we not swap value in arrays, so we swap prev1 and prev2
    if (swapped == 1) {
        val temp = prev1
        prev1 = prev2
        prev2 = temp
    }

    // No-swap
    if (nums1[index] > prev1 && nums2[index] > prev2) {
        ans = solveMem(nums1, nums2, index + 1, 0, dp)
    }

    // swap
    if (nums1[index] > prev2 && nums2[index] > prev1) {
        val temp = 1 + solveMem(nums1, nums2, index + 1, 1, dp)
        ans = Math.min(ans, temp)
    }

    dp[index][swapped] = ans

    return dp[index][swapped]
}

// Tabulation
// T.C = O(n), S.C = O(n)
private fun solveTab(nums1: IntArray, nums2: IntArray): Int {

    val n = nums1.size
    val dp = Array(n + 1) { IntArray(2) { 0 } }

    for (index in n - 1 downTo 1) {
        for (swapped in 1 downTo 0) {

            var ans = Int.MAX_VALUE

            var prev1 = nums1[index - 1]
            var prev2 = nums2[index - 1]

            // we not swap value in arrays, so we swap prev1 and prev2
            if (swapped == 1) {
                val temp = prev1
                prev1 = prev2
                prev2 = temp
            }

            // No-swap
            if (nums1[index] > prev1 && nums2[index] > prev2) {
                ans = dp[index + 1][0]
            }

            // swap
            if (nums1[index] > prev2 && nums2[index] > prev1) {
                val temp = 1 + dp[index + 1][1]
                ans = Math.min(ans, temp)
            }

            dp[index][swapped] = ans

        }
    }

    return dp[1][0]

}

// Space Optimization
// T.C = O(n), S.C = O(1)
private fun solveSO(nums1: IntArray, nums2: IntArray): Int {

    val n = nums1.size

    var swap = 0
    var noSwap = 0
    var currSwap = 0
    var currNoSwap = 0

    for (index in n - 1 downTo 1) {
        for (swapped in 1 downTo 0) {

            var ans = Int.MAX_VALUE

            var prev1 = nums1[index - 1]
            var prev2 = nums2[index - 1]

            // we not swap value in arrays, so we swap prev1 and prev2
            if (swapped == 1) {
                val temp = prev1
                prev1 = prev2
                prev2 = temp
            }

            // No-swap
            if (nums1[index] > prev1 && nums2[index] > prev2) {
                ans = noSwap
            }

            // swap
            if (nums1[index] > prev2 && nums2[index] > prev1) {
                val temp = 1 + swap
                ans = Math.min(ans, temp)
            }

            if (swapped == 1) {
                currSwap = ans
            } else {
                currNoSwap = ans
            }

        }

        swap = currSwap
        noSwap = currNoSwap
    }

    return Math.min(swap, noSwap)

}












