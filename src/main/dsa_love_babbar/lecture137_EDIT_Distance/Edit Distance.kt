package lecture137_EDIT_Distance

/**
 *    https://leetcode.com/problems/edit-distance/description/
 */
fun main() {
    println(minDistance("horse", "ros"))
    println(minDistance("intention", "execution"))
    println(minDistance("b", ""))
}

private fun minDistance(word1: String, word2: String): Int {

    //return solve(word1, word2, 0, 0)

    //val dp = Array(word1.length) { IntArray(word2.length) { -1 } }
    //return solveMem(word1, word2, 0, 0, dp) // Memorization

    //return solveTab(word1, word2) // Tabulation

    if (word1.length == 0) return word2.length
    if (word2.length == 0) return word1.length
    return solveSO(word1, word2) // Space Optimized
}

private fun solve(str1: String, str2: String, i: Int, j: Int): Int {

    // Base case
    if (i == str1.length) return str2.length - j
    if (j == str2.length) return str1.length - i

    var ans = 0
    if (str1[i] == str2[j]) {
        return solve(str1, str2, i + 1, j + 1)
    }
    else {
        val insertAns = 1 + solve(str1, str2, i, j + 1) // insert
        val deleteAns = 1 + solve(str1, str2, i + 1, j) // delete
        val replaceAns = 1 + solve(str1, str2, i + 1, j + 1) // replace

        ans = Math.min(insertAns, Math.min(deleteAns, replaceAns))
    }

    return ans
}

// Memorization
private fun solveMem(str1: String, str2: String, i: Int, j: Int, dp: Array<IntArray>): Int {

    // Base case
    if (i == str1.length) return str2.length - j
    if (j == str2.length) return str1.length - i

    if (dp[i][j] != -1) {
        return dp[i][j]
    }

    var ans = 0
    if (str1[i] == str2[j]) {
        return solveMem(str1, str2, i + 1, j + 1, dp)
    }
    else {
        val insertAns = 1 + solveMem(str1, str2, i, j + 1, dp) // insert
        val deleteAns = 1 + solveMem(str1, str2, i + 1, j, dp) // delete
        val replaceAns = 1 + solveMem(str1, str2, i + 1, j + 1, dp) // replace

        ans = Math.min(insertAns, Math.min(deleteAns, replaceAns))
    }

    dp[i][j] = ans

    return dp[i][j]
}

// Tabulation
private fun solveTab(str1: String, str2: String): Int {

    val l1 = str1.length
    val l2 = str2.length
    val dp = Array(l1 + 1) { IntArray(l2 + 1) }
    // From base case
    for (j in 0 ..< l2) {
        dp[l1][j] = l2 - j
    }
    for (i in 0 ..< l1) {
        dp[i][l2] = l1 - i
    }

    for (i in l1 - 1 downTo 0) {
        for (j in l2 - 1 downTo 0) {

            var ans = 0
            if (str1[i] == str2[j]) {
                ans = dp[i + 1][j + 1]
            }
            else {
                val insertAns = 1 + dp[i][j + 1] // insert
                val deleteAns = 1 + dp[i + 1][j] // delete
                val replaceAns = 1 + dp[i + 1][j + 1] // replace

                ans = Math.min(insertAns, Math.min(deleteAns, replaceAns))
            }

            dp[i][j] = ans
        }
    }

    return dp[0][0]
}

// Space Optimized
private fun solveSO(str1: String, str2: String): Int {

    val l1 = str1.length
    val l2 = str2.length

    val curr = IntArray(l2 + 1)
    var next = IntArray(l2 + 1)

    // From base case
    for (j in 0 ..< l2) {
        next[j] = l2 - j
    }

    for (i in l1 - 1 downTo 0) {
        for (j in l2 - 1 downTo 0) {

            // From base case
            curr[l2] = l1 - i

            var ans = 0
            if (str1[i] == str2[j]) {
                ans = next[j + 1]
            }
            else {
                val insertAns = 1 + curr[j + 1] // insert
                val deleteAns = 1 + next[j] // delete
                val replaceAns = 1 + next[j + 1] // replace

                ans = Math.min(insertAns, Math.min(deleteAns, replaceAns))
            }

            curr[j] = ans
        }

        next = curr.copyOf()
    }

    return next[0]
}


















