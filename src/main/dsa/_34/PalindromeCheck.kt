package _34

fun main() {
    val str = "abcde"
    println(isPalindromeString(str, 0, str.length - 1))
}

private fun isPalindromeString(str: String, startIndex: Int, endIndex: Int): Boolean {

    if (startIndex > endIndex) {
        return true
    }

    if (str[startIndex] != str[endIndex]) {
        return false
    } else {
        val remainingPart = isPalindromeString(str, startIndex + 1, endIndex - 1)
        return remainingPart
    }

}