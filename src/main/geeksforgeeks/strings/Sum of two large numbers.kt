package strings

/*
*   https://www.geeksforgeeks.org/problems/sum-of-numbers-or-number1219/1
* */

fun main() {
    println(findSum("1", "1"))
    println(findSum("5", "10"))
    println(findSum("100", "100"))
    println(findSum("928972900", "46238746224242000"))
    println(findSum("0000", "000000000000"))
    println(findSum("3", "00000000000005"))
    println(findSum("5", "100000000005"))
    println(findSum("293874932", "0327423"))
    println(findSum("293875626362532534264932", "0327345563453453456356363423"))
}

private fun findSum(num1: String, num2: String): String {

    val len1 = num1.length
    val len2 = num2.length

    val ans = StringBuilder()
    var sum = 0
    var carry = 0

    var end1 = len1 - 1
    var end2 = len2 - 1

    while (end1 >= 0 || end2 >= 0 || carry != 0) {
        var v1 = 0
        var v2 = 0

        if (end1 >= 0) {
            v1 = num1[end1].code - '0'.code
        }
        if (end2 >= 0) {
            v2 = num2[end2].code - '0'.code
        }

        sum = v1 + v2 + carry
        carry = sum / 10

        ans.append(sum % 10)

        end1--
        end2--
    }

    var result = ans.reverse().toString()
    result = removeStartZeros(StringBuilder(result), result.length)
    if (result.isEmpty()) {
        return "0"
    }

    return result
}

private fun removeStartZeros(str: StringBuilder, size: Int): String {
    var start = 0

    while (start < size) {
        if (str[start] == '0') {
            str.setCharAt(start, ' ')
        } else {
            break
        }

        start++
    }

    return str.toString().trim { it <= ' ' }
}

