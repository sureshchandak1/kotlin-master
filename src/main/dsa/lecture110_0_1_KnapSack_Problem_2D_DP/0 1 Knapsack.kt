package lecture110_0_1_KnapSack_Problem_2D_DP

import java.util.*
import kotlin.math.max

/**
 *    https://www.naukri.com/code360/problems/0-1-knapsack_920542
 */
fun main() {
    var weight = intArrayOf(25, 4, 25, 49, 9, 11, 31, 5, 37, 7, 11, 47, 37, 1, 33, 25, 29, 11, 1, 41, 19, 14, 43, 21, 1, 21, 23, 37, 12, 11, 45, 13, 36, 11, 17)
    var value = intArrayOf(86, 55, 17, 31, 88, 82, 27, 57, 18, 1, 61, 56, 36, 82, 51, 85, 55, 21, 11, 76, 91, 36, 85, 32, 99, 43, 41, 61, 41, 28, 83, 27, 35, 61, 16)
    println(knapsack(weight, value, weight.size, 869))

    weight = intArrayOf(30, 3, 43, 25, 20, 21, 2, 34, 39, 48, 14, 35, 15, 46, 49, 15, 11, 26, 38, 33, 1, 21, 17, 1, 44, 44, 33, 17, 33)
    value = intArrayOf(1, 13, 75, 46, 87, 98, 31, 91, 23, 43, 85, 18, 35, 1, 83, 26, 77, 91, 85, 76, 74, 65, 35, 36, 98, 42, 37, 83, 54)
    println(knapsack(weight, value, weight.size, 424))
}

private fun knapsack(weight: IntArray, value: IntArray, n: Int, maxWeight: Int): Int {

    //return solve(weight, value, n - 1, maxWeight)

    /*val dp = Array(n) { IntArray(maxWeight + 1) }
    for (a in dp) {
        Arrays.fill(a, -1)
    }

    return solveMem(weight, value, n - 1, maxWeight, dp)*/

    //return solveTab(weight, value, n, maxWeight)

    //return solveSpaceOptimize(weight, value, n, maxWeight)

    return solveSpaceOptimize1(weight, value, n, maxWeight)
}

private fun solve(weight: IntArray, value: IntArray, index: Int, maxWeight: Int): Int {

    // Base case
    if (index == 0) {
        return if (weight[index] <= maxWeight) {
            value[index]
        } else {
            0
        }
    }

    // include value
    var include = 0
    if (weight[index] <= maxWeight) {
        include = value[index] + solve(weight, value, index - 1, maxWeight - weight[index])
    }

    // not include value
    val exclude = 0 + solve(weight, value, index - 1, maxWeight)

    val ans = max(include.toDouble(), exclude.toDouble()).toInt()

    return ans
}

// Top-Down DP (Memoization)
private fun solveMem(weight: IntArray, value: IntArray, index: Int, maxWeight: Int, dp: Array<IntArray>): Int {

    // Base case
    if (index == 0) {
        return if (weight[index] <= maxWeight) {
            value[index]
        } else {
            0
        }
    }

    if (dp[index][maxWeight] != -1) {
        return dp[index][maxWeight]
    }

    // include value
    var include = 0
    if (weight[index] <= maxWeight) {
        include = value[index] + solveMem(weight, value, index - 1, maxWeight - weight[index], dp)
    }

    // not include value
    val exclude = 0 + solveMem(weight, value, index - 1, maxWeight, dp)

    dp[index][maxWeight] = max(include.toDouble(), exclude.toDouble()).toInt()

    return dp[index][maxWeight]
}

// Bottom-Up (Tabulation)
private fun solveTab(weight: IntArray, value: IntArray, n: Int, maxWeight: Int): Int {

    // step1: create dp array
    val dp = Array(n) { IntArray(maxWeight + 1) }
    for (a in dp) {
        Arrays.fill(a, 0)
    }

    // step2: set base case value
    for (w in weight[0]..maxWeight) {
        if (weight[0] <= maxWeight) {
            dp[0][w] = value[0]
        } else {
            dp[0][w] = 0
        }
    }

    // step3: remaining part
    for (index in 1..<n) {
        for (w in 0..maxWeight) {

            // include value
            var include = 0
            if (weight[index] <= w) {
                include = value[index] + dp[index - 1][w - weight[index]]
            }

            // not include value
            val exclude = 0 + dp[index - 1][w]

            dp[index][w] = max(include.toDouble(), exclude.toDouble()).toInt()
        }
    }

    return dp[n - 1][maxWeight]
}

// Space optimize solution
private fun solveSpaceOptimize(weight: IntArray, value: IntArray, n: Int, maxWeight: Int): Int {

    // step1
    var prev = IntArray(maxWeight + 1)
    val curr = IntArray(maxWeight + 1)

    // step2: set base case value
    for (w in weight[0]..maxWeight) {
        if (weight[0] <= maxWeight) {
            prev[w] = value[0]
        } else {
            prev[w] = 0
        }
    }

    // step3: remaining part
    for (index in 1..< n) {
        for (w in 0..maxWeight) {

            // include value
            var include = 0
            if (weight[index] <= w) {
                include = value[index] + prev[w - weight[index]]
            }

            // not include value
            val exclude = 0 + prev[w]

            curr[w] = max(include.toDouble(), exclude.toDouble()).toInt()
        }

        prev = curr.copyOf(curr.size)
    }

    return prev[maxWeight]
}

private fun solveSpaceOptimize1(weight: IntArray, value: IntArray, n: Int, maxWeight: Int): Int {

    // step1
    val curr = IntArray(maxWeight + 1)

    // step2: set base case value
    for (w in weight[0]..maxWeight) {
        if (weight[0] <= maxWeight) {
            curr[w] = value[0]
        } else {
            curr[w] = 0
        }
    }

    // step3: remaining part
    for (index in 1..< n) {
        for (w in maxWeight downTo 0) {

            // include value
            var include = 0
            if (weight[index] <= w) {
                include = value[index] + curr[w - weight[index]]
            }

            // not include value
            val exclude = 0 + curr[w]

            curr[w] = max(include.toDouble(), exclude.toDouble()).toInt()
        }
    }

    return curr[maxWeight]
}














