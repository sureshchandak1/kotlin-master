package lecture136_Longest_Palindromic_Subsequence

/**
 *    https://leetcode.com/problems/longest-palindromic-subsequence/description/
 */
fun main() {
    println(longestPalindromeSubSeq("bbbab"))
    println(longestPalindromeSubSeq("cbbd"))
}

private fun longestPalindromeSubSeq(s: String): Int {
    val revStr = s.reversed()
    return solve(s, revStr)
}

// T.C = O(n * m), S.C = O(m)
private fun solve(text1: String, text2: String): Int {

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



