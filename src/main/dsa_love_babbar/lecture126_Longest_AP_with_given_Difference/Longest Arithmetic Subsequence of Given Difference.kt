package lecture126_Longest_AP_with_given_Difference

/**
 *    https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
fun main() {
    println(longestSubsequence(intArrayOf(1, 2, 3, 4), 1))
    println(longestSubsequence(intArrayOf(1, 3, 5, 7), 1))
    println(longestSubsequence(intArrayOf(1, 5, 7, 8, 5, 3, 4, 2, 1), -2))
}

private fun longestSubsequence(arr: IntArray, difference: Int): Int {

    val dp: MutableMap<Int, Int> = HashMap()

    var ans = 0

    for (i in arr.indices) {

        val temp = arr[i] - difference
        var tempAns = 0

        // check answer exist for temp already or not
        if (dp.containsKey(temp)) {
            tempAns = dp[temp]!!
        }

        // current answer update
        dp[arr[i]] = 1 + tempAns

        // ans update
        ans = Math.max(ans, dp[arr[i]]!!)

    }

    return ans

}






