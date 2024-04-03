
/*
*   https://leetcode.com/problems/isomorphic-strings/description/
* */

fun main() {
    println(isIsomorphic("egg", "add"))
    println(isIsomorphic("foo", "bar"))
    println(isIsomorphic("paper", "title"))
    println(isIsomorphic("bbbaaaba", "aaabbbba"))
}

private fun isIsomorphic(s: String, t: String): Boolean {
    // s = bbbaaaba ,  t = aaabbbba
    // Create two arrays to store the last seen positions of characters
    val lastSeenPositionInS = IntArray(256) // Assuming extended ASCII
    val lastSeenPositionInT = IntArray(256) // Assuming extended ASCII

    val length = s.length

    for (i in 0 ..< length) {

        val charS: Char = s[i]
        val charT: Char = t[i]

        // If the last seen position of the respective characters
        // in the two strings are not the same, then they are not isomorphic
        if (lastSeenPositionInS[charS.code] != lastSeenPositionInT[charT.code]) {
            return false
        }

        // Update the last seen position of the characters
        // i + 1 is used because default value in int arrays is 0,
        // and we are using the index as a check (can't use 0 as it is the default)
        lastSeenPositionInS[charS.code] = i + 1
        lastSeenPositionInT[charT.code] = i + 1
    }

    return true
}


