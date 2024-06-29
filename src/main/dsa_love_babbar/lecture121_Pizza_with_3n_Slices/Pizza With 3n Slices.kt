package lecture121_Pizza_with_3n_Slices

/**
 *   https://leetcode.com/problems/pizza-with-3n-slices/description/
 *   Time complexity: O(n * n)
 *   Space complexity: O(2 + n)
 */
fun main() {
    println(maxSizeSlices(intArrayOf(1, 2, 3, 4, 5, 6)))
    println(maxSizeSlices(intArrayOf(8, 9, 8, 6, 1, 1)))
    println(maxSizeSlices(intArrayOf(9, 5, 1, 7, 8, 4, 4, 5, 5, 8, 7, 7)))
    println(maxSizeSlices(intArrayOf(7,8,5,6,9,10,1,6,5,10,8,10,5,4,7,2,8,5,9,7,5,9,3,7,7,2,2,10,7,6,4,6,5,7,7,9,6,8,10,7,5,7,2,5,4,9,6,10,10,2,10)))

}

private fun maxSizeSlices(slices: IntArray): Int {
    val k = slices.size
    //val case1 = solve(0, k-2, slices, k/3)
    //val case2 = solve(1, k-1, slices, k/3)
    //return Math.max(case1, case2)

    /*
    val dp1 = Array(k) { IntArray(k) { -1 } }
    val case1 = solveMem(0, k-2, slices, k/3, dp1)

    val dp2 = Array(k) { IntArray(k) { -1 } }
    val case2 = solveMem(1, k-1, slices, k/3, dp2)
    return Math.max(case1, case2)
    */

    //return solveTab(slices)

    return solveSC(slices)
}

// Recursion
private fun solve(index: Int, endIndex: Int, slices: IntArray, totalEat: Int): Int {

    // Base case
    if (totalEat == 0 || index > endIndex) return 0

    // take slice
    val include = slices[index] + solve(index + 2, endIndex, slices, totalEat - 1)

    // not take slice
    val exclude = 0 + solve(index + 1, endIndex, slices, totalEat)

    return Math.max(include, exclude)
}

// Recursion + Memorization
private fun solveMem(index: Int, endIndex: Int, slices: IntArray, totalEat: Int, dp: Array<IntArray>): Int {

    // Base case
    if (totalEat == 0 || index > endIndex) return 0

    if (dp[index][totalEat] != -1) return dp[index][totalEat]

    // take slice
    val include = slices[index] + solveMem(index + 2, endIndex, slices, totalEat - 1, dp)

    // not take slice
    val exclude = 0 + solveMem(index + 1, endIndex, slices, totalEat, dp)

    dp[index][totalEat] = Math.max(include, exclude)

    return dp[index][totalEat]
}

// Tabulation
private fun solveTab(slices: IntArray): Int {

    val k = slices.size
    val dp1 = Array(k + 2) { IntArray(k + 2) { 0 } }
    val dp2 = Array(k + 2) { IntArray(k + 2) { 0 } }

    for (index in k - 2 downTo 0) {
        for (eat in 1..k / 3) {

            // take slice
            val include = slices[index] + dp1[index + 2][eat - 1]

            // not take slice
            val exclude = 0 + dp1[index + 1][eat]

            dp1[index][eat] = Math.max(include, exclude)

        }
    }
    val case1 = dp1[0][k / 3]

    for (index in k - 1 downTo 1) {
        for (eat in 1..k / 3) {

            // take slice
            val include = slices[index] + dp2[index + 2][eat - 1]

            // not take slice
            val exclude = 0 + dp2[index + 1][eat]

            dp2[index][eat] = Math.max(include, exclude)

        }
    }
    val case2 = dp2[1][k / 3]

    return Math.max(case1, case2)
}

// Space Optimization
private fun solveSC(slices: IntArray): Int {

    val k = slices.size

    val prev1 = IntArray(k + 2) { 0 }
    var curr1 = IntArray(k + 2) { 0 }
    var next1 = IntArray(k + 2) { 0 }

    val prev2 = IntArray(k + 2) { 0 }
    var curr2 = IntArray(k + 2) { 0 }
    var next2 = IntArray(k + 2) { 0 }

    for (index in k - 2 downTo 0) {
        for (eat in 1..k / 3) {

            // take slice
            val include = slices[index] + next1[eat - 1]

            // not take slice
            val exclude = 0 + curr1[eat]

            prev1[eat] = Math.max(include, exclude)

        }

        next1 = curr1.copyOf(curr1.size)
        curr1 = prev1.copyOf(prev1.size)
    }
    val case1 = curr1[k / 3]

    for (index in k - 1 downTo 1) {
        for (eat in 1..k / 3) {

            // take slice
            val include = slices[index] + next2[eat - 1]

            // not take slice
            val exclude = 0 + curr2[eat]

            prev2[eat] = Math.max(include, exclude)

        }

        next2 = curr2.copyOf(curr2.size)
        curr2 = prev2.copyOf(prev2.size)
    }
    val case2 = curr2[k / 3]

    return Math.max(case1, case2)
}










