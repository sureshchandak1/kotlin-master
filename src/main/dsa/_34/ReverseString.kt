package _34

fun main() {
    val str = StringBuilder("Suresh")
    reverseString(str, 0, str.length - 1)

    println(str.toString())
}

private fun reverseString(str: StringBuilder, startIndex: Int, endIndex: Int) {

    if (startIndex > endIndex) {
        return
    }

    val temp = str[startIndex]
    str[startIndex] = str[endIndex]
    str[endIndex] = temp

    reverseString(str, startIndex + 1, endIndex - 1)
}