
/*
*   https://leetcode.com/problems/length-of-last-word/description/
* */
fun main() {
    println(lengthOfLastWord("Hello World"))
    println(lengthOfLastWord("   fly me   to   the moon  "))
    println(lengthOfLastWord("luffy is still joyboy"))
}

private fun lengthOfLastWord(s: String): Int {

    var end = s.length - 1

    var len = 0
    while (end >= 0) {
        if (s[end] == ' ' && len == 0) {
            end--
            continue
        } else {
            if (s[end] == ' ') {
                return len
            }
            len++
        }

        end--
    }

    return len
}