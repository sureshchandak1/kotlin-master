package mathematical

/*
*   https://www.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not2751/1
*
*   The digit sum of 56 is 5+6=11.Since, 11 is a palindrome number.Thus, answer is 1.
* */
fun main() {
    println(isDigitSumPalindrome(56))
    println(isDigitSumPalindrome(98))
}

private fun isDigitSumPalindrome(n: Int): Int {
    var temp = n
    var sum = 0
    while (temp > 0) {
        val digit = temp % 10
        sum = sum + digit
        temp = temp / 10
    }

    val reverse = reverseNumber(sum)

    return if (reverse == sum) {
        1
    } else {
        0
    }
}

private fun reverseNumber(n: Int): Int {
    var n = n
    var ans = 0
    while (n > 0) {
        val digit = n % 10
        ans = ans * 10 + digit
        n = n / 10
    }

    return ans
}



