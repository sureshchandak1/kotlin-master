/**
 *    https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 */
fun main() {
    println(maxDepth("(1+(2*3)+((8)/4))+1"))
    println(maxDepth("(1)+((2))+(((3)))"))
    println(maxDepth("1+((2))+(((3)))"))
    println(maxDepth("1+((2))+((3))"))
}

private fun maxDepth(s: String): Int {
    val size = s.length

    var maxDepth: Int = 0
    var current: Int = 0

    for (i in 0 ..< size) {
        if (s[i] == '(' ) {
            current++
        } else if (s[i] == ')' ) {
            current--
        }

        maxDepth = Math.max(maxDepth, current)
    }

    return maxDepth
}

