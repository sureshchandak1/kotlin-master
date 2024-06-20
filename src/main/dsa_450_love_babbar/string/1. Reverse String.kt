package string

/**
 *    https://leetcode.com/problems/reverse-string/
 */
fun main() {
    println(reverseString("hello"))
    println(reverseString("abcd"))
    println(reverseString("hello".toCharArray()))
    println(reverseString("abcd".toCharArray()))
}

private fun reverseString(str: String) : String {

    val length = str.length

    val builder = StringBuilder(str)

    var start = 0
    var end = length - 1

    while (start < end) {
        swap(builder, start, end)
        start++
        end--
    }

    return builder.toString()
}

private fun reverseString(str: CharArray) : CharArray {

    val size = str.size

    var start = 0
    var end = size - 1

    var temp: Char
    while (start < end) {
        temp = str[start]
        str[start] = str[end]
        str[end] = temp

        start++
        end--
    }

    return str
}

private fun swap(builder: StringBuilder, i: Int, j: Int) {
    val temp: Char = builder[i]
    builder[i] = builder[j]
    builder[j] = temp
}




