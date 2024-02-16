package medium

fun main() {

}

private fun longestPalindrome(s: String): String {

    var str: String = ""

    var index = 0
    while (index < s.length) {

        if (isPalindrome(str + s[index])) {
            str += s[index]
        }
    }

    return str
}

private fun isPalindrome(str: String): Boolean {
    var start = 0
    var end = str.length - 1

    while (start < end) {
        if (str[start] != str[end]) {
            return false
        }

        start++
        end--
    }

    return true
}

private fun toLowerCase(ch: Char): Char {
    if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
        return ch
    } else {
        return (ch.code - 'A'.code + 'a'.code).toChar()
    }
}