package lecture022_Strings

fun main() {
    val str = "c1 O$@eeD o1c"
    println(checkPalindrome(str))

    println(reverseWords("My name is Suresh"))

    println(getMaxOccCharacter("output"))

    println(removeOccurrences("daabcbaabcbc", "abc"))

}

private fun getLength(arr: CharArray): Int {
    var count = 0

    var i = 0
    while (arr[i] != '\u0000') {
        count++
        i++
    }

    return count
}

private fun reverseString(s: CharArray): String {

    var start = 0
    var end = s.size - 1

    while (start < end) {
        s[start] = s[end].also { s[end] = s[start] }

        start++
        end--
    }

    return s.concatToString()
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

private fun reverseWords(str: String): String {

    val words: List<String> = str.split(" ")

    val builder = StringBuilder()

    for (word in words) {
        val reverse = reverseString(word.toCharArray())
        builder.append(reverse)
        builder.append(" ")
    }

    return builder.toString()
}

private fun getMaxOccCharacter(s: String): Char {

    val arr = IntArray(26) { 0 }

    for (i in s.indices) {
        val ch = s[i]

        val number = if (ch in 'a'..'z') {
            ch - 'a'
        } else {
            ch - 'A'
        }

        arr[number]++
    }

    var max = 0
    var maxIndex = 0
    for (i in 0..25) {
        if (max < arr[i]) {
            maxIndex = i
            max = arr[i]
        }
    }

    val result = 'a' + maxIndex

    return result
}

private fun removeOccurrences(s: String, part: String): String {

    var str = s
    while (str.isNotEmpty()) {
        val startIndex = str.indexOf(part)
        if (startIndex < 0) break
        val endIndex = startIndex + part.length
        str = str.removeRange(startIndex, endIndex)
    }

    return str

}

