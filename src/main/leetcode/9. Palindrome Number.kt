fun main() {
    println(isPalindrome(121))
    println(isPalindrome(11211))
    println(isPalindrome(0))
    println(isPalindrome(1))
    println(isPalindrome(10))
    println(isPalindrome(-121))
}

private fun isPalindrome(x: Int): Boolean {
    var x = x

    if (x < 0 || (x != 0 && x % 10 == 0)) {
        return false
    }

    var reverseNumber = 0

    while (x > reverseNumber) {
        reverseNumber = (reverseNumber * 10) + (x % 10)
        x /= 10
    }

    return (x == reverseNumber) || (x == reverseNumber / 10)
}