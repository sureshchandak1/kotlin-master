package lecture139_Wildcard_Pattern_Matching

/**
 *    https://leetcode.com/problems/wildcard-matching/description/
 */
fun main() {
    println(isMatch("aa", "a"))
    println(isMatch("aa", "*"))
    println(isMatch("cb", "?a"))
    println(isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*"))
}

private fun isMatch(s: String, p: String): Boolean {

    //return solve(s, p, s.length - 1, p.length - 1)

    val dp = Array(s.length) { IntArray(p.length) { -1 } }
    return solveMem(s, p, s.length - 1, p.length - 1, dp)
}

private fun solve(s: String, p: String, i: Int, j: Int): Boolean {

    // Base case
    if (i < 0 && j < 0) return true
    if (i >= 0 && j < 0) return false
    if (i < 0 && j >= 0) {
        for (k in 0 .. j) {
            if (p[k] != '*') {
                return false
            }
        }
        return true
    }

    if (s[i] == p[j] || p[j] == '?') {
        return solve(s, p, i - 1, j - 1)
    }
    else if (p[j] == '*') {
        val replace1 = solve(s, p, i - 1, j) // * replace with space ' '
        val replace2 = solve(s, p, i, j - 1) // * replace with *Char ex. '*b'
        return replace1 || replace2
    }
    else {
        return false
    }
}

private fun solveMem(s: String, p: String, i: Int, j: Int, dp: Array<IntArray>): Boolean {

    // Base case
    if (i < 0 && j < 0) return true
    if (i >= 0 && j < 0) return false
    if (i < 0 && j >= 0) {
        for (k in 0 .. j) {
            if (p[k] != '*') {
                return false
            }
        }
        return true
    }

    if (dp[i][j] != -1) {
        if (dp[i][j] == 1) return true
        if (dp[i][j] == 0) return false
    }

    var ans = false
    if (s[i] == p[j] || p[j] == '?') {
        ans = solveMem(s, p, i - 1, j - 1, dp)
    }
    else if (p[j] == '*') {
        val replace1 = solveMem(s, p, i - 1, j, dp) // * replace with space ' '
        val replace2 = solveMem(s, p, i, j - 1, dp) // * replace with *Char ex. '*b'
        ans = replace1 || replace2
    }

    if (ans) {
        dp[i][j] = 1
        return true
    } else {
        dp[i][j] = 0
        return false
    }
}





