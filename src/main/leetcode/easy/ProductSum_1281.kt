package easy

/*
*                   Input: n = 234
*                   Output: 15
*                   Explanation:
*                   Product of digits = 2 * 3 * 4 = 24
*                   Sum of digits = 2 + 3 + 4 = 9
*                   Result = 24 - 9 = 15
*
* */
fun main() {
    println(subtractProductAndSum(234))
    println(subtractProductAndSum(4421))
}

private fun subtractProductAndSum(n: Int): Int {
    var productDigits = 1
    var sumDigits = 0

    var value = n
    while (value != 0) {
        val digit = value % 10
        productDigits *= digit
        sumDigits += digit

        value /= 10
    }

    val result = productDigits - sumDigits
    return result
}