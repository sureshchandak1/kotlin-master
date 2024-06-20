package string

/**
 *    https://leetcode.com/problems/valid-palindrome/description/
 *    https://www.geeksforgeeks.org/problems/palindrome-string0817/1
 */
fun main() {
    println(checkPalindrome("A man, a plan, a canal: Panama"))
    println(checkPalindrome("race a car"))
    println(checkPalindrome(" "))

    println(isPalindrome("abba"))
    println(isPalindrome("abc"))
}

private fun checkPalindrome(str: String): Boolean {

    if (str.isEmpty()) return true

    var start = 0
    var end = str.length - 1

    while (start < end) {

        if (!isValidChar(str[start])) {
            start++
            continue
        }

        if (!isValidChar(str[end])) {
            end--
            continue
        }

        val sCh = toLowerCase(str[start])
        val eCh = toLowerCase(str[end])

        if (sCh != eCh) {
            return false
        }

        start++
        end--
    }

    return true
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

private fun isValidChar(ch: Char): Boolean {
    return (ch in 'a'..'z') ||
            (ch in 'A'..'Z') ||
            (ch in '0'..'9')
}

private fun toLowerCase(ch: Char): Char {
    return if ((ch in 'a'..'z') || (ch in '0'..'9')) {
        ch
    } else {
        (ch.code - 'A'.code + 'a'.code).toChar()
    }
}






