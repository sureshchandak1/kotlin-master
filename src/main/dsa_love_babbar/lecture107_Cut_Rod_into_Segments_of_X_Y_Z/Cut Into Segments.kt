package lecture107_Cut_Rod_into_Segments_of_X_Y_Z

import java.util.*
import kotlin.math.max

/**
 *    https://www.naukri.com/code360/problems/cut-into-segments_1214651
 */
fun main() {
    println(cutSegments(7, 5, 2, 2))
    println(cutSegments(8, 3, 3, 3))
    println(cutSegments(7, 3, 2, 2))
    println(cutSegments(8, 1, 4, 4))
}

fun cutSegments(n: Int, x: Int, y: Int, z: Int): Int {
    /*int ans = solve(n, x, y, z);
        if (ans < 0) {
            return 0;
        }
        return ans;*/

    /*int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int ans = solveMem(n, x, y, z, dp);
        if (ans < 0) {
            return 0;
        }
        return ans;*/

    return solveTab(n, x, y, z)
}

// T.C = infinite
private fun solve(n: Int, x: Int, y: Int, z: Int): Int {

    // Base case
    if (n == 0) {
        return 0
    }
    if (n < 0) {
        return Int.MIN_VALUE
    }

    val a = solve(n - x, x, y, z) + 1
    val b = solve(n - y, x, y, z) + 1
    val c = solve(n - z, x, y, z) + 1

    val ans = max(a.toDouble(), max(b.toDouble(), c.toDouble())).toInt()

    return ans
}

// Memoization
// T.C = O(n), S.C = O(n) + O(n)
private fun solveMem(n: Int, x: Int, y: Int, z: Int, dp: IntArray): Int {

    // Base case
    if (n == 0) {
        return 0
    }
    if (n < 0) {
        return Int.MIN_VALUE
    }

    if (dp[n] != -1) {
        return dp[n]
    }

    val a = solveMem(n - x, x, y, z, dp) + 1
    val b = solveMem(n - y, x, y, z, dp) + 1
    val c = solveMem(n - z, x, y, z, dp) + 1

    val ans = max(a.toDouble(), max(b.toDouble(), c.toDouble())).toInt()

    dp[n] = ans

    return dp[n]
}

// Tabulation
// T.C = O(n), S.C = O(n)
private fun solveTab(n: Int, x: Int, y: Int, z: Int): Int {

    val dp = IntArray(n + 1)
    Arrays.fill(dp, -1)

    dp[0] = 0 // Base case

    for (i in 1..n) {
        if (i - x >= 0 && dp[i - x] != -1) {
            dp[i] = max(dp[i].toDouble(), (dp[i - x] + 1).toDouble()).toInt()
        }

        if (i - y >= 0 && dp[i - y] != -1) {
            dp[i] = max(dp[i].toDouble(), (dp[i - y] + 1).toDouble()).toInt()
        }

        if (i - z >= 0 && dp[i - z] != -1) {
            dp[i] = max(dp[i].toDouble(), (dp[i - z] + 1).toDouble()).toInt()
        }
    }

    if (dp[n] < 0) {
        return 0
    }
    return dp[n]
}












