package lecture127_Unique_Binary_Search_Trees

/**
 *    https://leetcode.com/problems/unique-binary-search-trees/description/
 */
fun main() {
    println(solveMem(3, IntArray(3 + 1) { -1 }))
    println(solveMem(1, IntArray(1 + 1) { -1 }))
    println(solveMem(4, IntArray(4 + 1) { -1 }))
    println(solveTab(3))
    println(solveTab(1))
    println(solveTab(4))
}

private fun solve(n: Int): Int {

    // Base case
    if (n <= 1) return 1

    var ans = 0
    // think i as root node
    for (i in 1 .. n) {
        ans += solve(i - 1) * solve(n - i)
    }

    return ans
}

// Memorization
private fun solveMem(n: Int, dp: IntArray): Int {

    // Base case
    if (n <= 1) return 1

    if (dp[n] != -1) {
        return dp[n]
    }

    var ans = 0
    // think i as root node
    for (i in 1 .. n) {
        ans += solveMem(i - 1, dp) * solveMem(n - i, dp)
    }

    dp[n] = ans

    return dp[n]
}

// Tabulation
private fun solveTab(n: Int): Int {

    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = 1

    // i = number of nodes
    for (i in 2 .. n) {
        // j = root node
        for (j in 1 .. i) {
            dp[i] += dp[j - 1] * dp[i - j]
        }
    }

    return dp[n]
}








