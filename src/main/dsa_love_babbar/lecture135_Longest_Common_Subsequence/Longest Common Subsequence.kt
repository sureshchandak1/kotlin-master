package lecture135_Longest_Common_Subsequence

/**
 *    https://leetcode.com/problems/longest-common-subsequence/description/
 */
fun main() {
    println(longestCommonSubsequence("abcde", "ace"))
    println(longestCommonSubsequence("abc", "abc"))
    println(longestCommonSubsequence("abc", "def"))
}

private fun longestCommonSubsequence(text1: String, text2: String): Int {

    //return solve(text1, text2, 0, 0)

    //val dp = Array(text1.length) { IntArray(text2.length) { -1 } }
    //return solveMem(text1, text2, 0, 0, dp)

    //return solveTab(text1, text2)

    return solveSO(text1, text2)
}

private fun solve(text1: String, text2: String, i: Int, j: Int): Int {

    // Base case
    if (text1.length == i || text2.length == j) return 0

    var ans = 0
    if (text1[i] == text2[j]) {
        ans = 1 + solve(text1, text2, i + 1, j + 1)
    }
    else {
        val iIncrement = solve(text1, text2, i + 1, j)
        val jIncrement = solve(text1, text2, i, j + 1)

        ans = Math.max(iIncrement, jIncrement)
    }

    return ans
}

// Memorization
// T.C = O(n * m), S.C = O(n * m)
private fun solveMem(text1: String, text2: String, i: Int, j: Int, dp: Array<IntArray>): Int {

    // Base case
    if (text1.length == i || text2.length == j) return 0

    if (dp[i][j] != -1) {
        return dp[i][j]
    }

    var ans = 0
    if (text1[i] == text2[j]) {
        ans = 1 + solveMem(text1, text2, i + 1, j + 1, dp)
    }
    else {
        val iIncrement = solveMem(text1, text2, i + 1, j, dp)
        val jIncrement = solveMem(text1, text2, i, j + 1, dp)

        ans = Math.max(iIncrement, jIncrement)
    }

    dp[i][j] = ans

    return dp[i][j]
}

// Tabulation
// T.C = O(n * m), S.C = O(n * m)
private fun solveTab(text1: String, text2: String): Int {

    val l1 = text1.length
    val l2 = text2.length

    val dp = Array(l1 + 1) { IntArray(l2 + 1) }

    for (i in l1 - 1 downTo 0) {
        for (j in l2 - 1 downTo 0) {

            var ans = 0
            if (text1[i] == text2[j]) {
                ans = 1 + dp[i + 1][j + 1]
            }
            else {
                ans = Math.max(dp[i + 1][j], dp[i][j + 1])
            }

            dp[i][j] = ans

        }
    }

    return dp[0][0]
}

// Space Optimization
// T.C = O(n * m), S.C = O(m)
private fun solveSO(text1: String, text2: String): Int {

    val l1 = text1.length
    val l2 = text2.length

    val curr = IntArray(l2 + 1)
    var next = IntArray(l2 + 1)

    for (i in l1 - 1 downTo 0) {
        for (j in l2 - 1 downTo 0) {

            var ans = 0
            if (text1[i] == text2[j]) {
                ans = 1 + next[j + 1]
            }
            else {
                ans = Math.max(next[j], curr[j + 1])
            }

            curr[j] = ans

        }

        next = curr.copyOf()
    }

    return next[0]
}










