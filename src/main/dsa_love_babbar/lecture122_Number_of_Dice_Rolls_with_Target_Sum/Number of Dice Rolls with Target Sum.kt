package lecture122_Number_of_Dice_Rolls_with_Target_Sum

/**
 *    https://www.geeksforgeeks.org/problems/dice-throw5349/1
 */
fun main() {
    println(noOfWays(6, 3, 12))
    println(noOfWays(2, 3, 6))
    println(noOfWays(6, 1, 3))
    println(noOfWays(6, 2, 7))
    println(noOfWays(30, 30, 500))
}

private const val modulo  = 1000000007

/**
 *   @param m = Faces
 *   @param n = Dice
 *   @param x = Target
 */
private fun noOfWays(m: Int, n: Int, x: Int): Long {
    //return solve(N, M, X);

    /*
        long[][] dp = new long[N+1][X + 1];
        for (long[] a : dp) {
            Arrays.fill(a, -1);
        }

        return solveMem(N, M, X, dp);
        */

    //return solveTab(N, M, X);

    return solveSC(n, m, x)
}

// Recursion
private fun solve(dice: Int, faces: Int, target: Int): Long {

    // Base case
    if (target < 0) return 0
    if (dice == 0 && target != 0) return 0
    if (dice != 0 && target == 0) return 0
    if (dice == 0 && target == 0) return 1

    var ans: Long = 0
    for (i in 1..faces) {
        ans += solve(dice - 1, faces, target - i)
    }

    return ans
}

// Recursion + Memorization
// T.C = O(d * f * t), S.C = O(d * t)
private fun solveMem(dice: Int, faces: Int, target: Int, dp: Array<LongArray>): Long {

    // Base case
    if (target < 0) return 0
    if (dice == 0 && target != 0) return 0
    if (dice != 0 && target == 0) return 0
    if (dice == 0 && target == 0) return 1

    if (dp[dice][target] != -1L) {
        return dp[dice][target]
    }

    var ans: Long = 0
    for (i in 1..faces) {
        ans += solveMem(dice - 1, faces, target - i, dp)
    }

    dp[dice][target] = ans

    return dp[dice][target]
}

// Tabulation
// T.C = O(d * f * t), S.C = O(d * t)
private fun solveTab(d: Int, f: Int, t: Int): Long {

    val dp = Array(d + 1) { LongArray(t + 1) } // default value 0

    // Base case analysing
    dp[0][0] = 1

    for (dice in 1..d) {
        for (target in 1..t) {
            var ans: Long = 0
            for (i in 1..f) {
                if (target - i >= 0) {
                    ans += dp[dice - 1][target - i]
                }
            }

            dp[dice][target] = ans
        }
    }

    return dp[d][t]
}

// Space Optimization
// T.C = O(d * f * t), S.C = O(t)
private fun solveSC(d: Int, f: Int, t: Int): Long {

    var prev = LongArray(t + 1)
    val curr = LongArray(t + 1)

    prev[0] = 1

    for (dice in 1..d) {
        for (target in 1..t) {
            var ans: Long = 0
            for (i in 1..f) {
                if (target - i >= 0) {
                    ans = ((ans % modulo) + (prev[target - i] % modulo)) % modulo
                }
            }

            curr[target] = ans
        }

        prev = curr.copyOf(curr.size)
    }

    return prev[t]
}

/**
 *    ( a + b) % c = ( ( a % c ) + ( b % c ) ) % c
 *    ( a * b) % c = ( ( a % c ) * ( b % c ) ) % c
 *    ( a – b) % c = ( ( a % c ) – ( b % c ) ) % c
 */







