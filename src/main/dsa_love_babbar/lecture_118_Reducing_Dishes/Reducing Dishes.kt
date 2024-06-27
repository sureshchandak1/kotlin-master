package lecture_118_Reducing_Dishes

/**
 *    https://leetcode.com/problems/reducing-dishes/description/
 */
fun main() {
    println(maxSatisfaction(intArrayOf(-1, -8, 0, 5, -7)))
    println(maxSatisfaction(intArrayOf(4, 3, 2)))
    println(maxSatisfaction(intArrayOf(-1, -4, -5)))
}

private fun maxSatisfaction(satisfaction: IntArray): Int {

    satisfaction.sort() // sort array O(n(log n))

    //return solve(satisfaction, 0, 1)

    //val n = satisfaction.size
    //val dp = Array(n + 1) { IntArray(n + 1) { -1 } }
    //return solveMem(satisfaction, 0, 1, dp)

    //return solveTab(satisfaction)

    return solveSC(satisfaction)
}

// Recursion
private fun solve(satisfaction: IntArray, index: Int, time: Int): Int {

    // Base case
    if (index == satisfaction.size) {
        return 0
    }

    val include = satisfaction[index] * time + solve(satisfaction, index + 1, time + 1)

    val exclude = 0 + solve(satisfaction, index + 1, time)

    return Math.max(include, exclude)
}

// Recursion + Memorization
// T.C = O(n * n), S.C = O(n * n)
private fun solveMem(satisfaction: IntArray, index: Int, time: Int, dp: Array<IntArray>): Int {

    // Base case
    if (index == satisfaction.size) {
        return 0
    }

    // return if already calculate
    if (dp[index][time] != -1) {
        return dp[index][time]
    }

    val include = satisfaction[index] * time + solveMem(satisfaction, index + 1, time + 1, dp)

    val exclude = 0 + solveMem(satisfaction, index + 1, time, dp)

    // store in dp array
    dp[index][time] = Math.max(include, exclude)

    return dp[index][time]
}

// Tabulation
// T.C = O(n * n), S.C = O(n * n)
private fun solveTab(satisfaction: IntArray): Int {

    val n = satisfaction.size
    val dp = Array(n + 1) { IntArray(n + 1) { 0 } }

    for (index in n - 1 downTo 0) {
        for (time in index downTo 0) {

            val include = satisfaction[index] * (time + 1) + dp[index + 1][time + 1]

            val exclude = 0 + dp[index + 1][time]

            // store in dp array
            dp[index][time] = Math.max(include, exclude)

        }
    }

    return dp[0][0]
}

// Space Optimization
// T.C = O(n * n), S.C = O(n)
private fun solveSC(satisfaction: IntArray): Int {

    val n = satisfaction.size

    val curr = IntArray(n + 1)
    var next = IntArray(n + 1)

    for (index in n - 1 downTo 0) {
        for (time in index downTo 0) {

            val include = satisfaction[index] * (time + 1) + next[time + 1]

            val exclude = 0 + next[time]

            curr[time] = Math.max(include, exclude)

        }

        next = curr.copyOf(curr.size)
    }

    return next[0]
}













