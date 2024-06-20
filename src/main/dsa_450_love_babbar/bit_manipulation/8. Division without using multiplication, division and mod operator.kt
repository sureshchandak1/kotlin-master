package bit_manipulation

import kotlin.math.abs

/**
 *    https://www.geeksforgeeks.org/problems/division-without-using-multiplication-division-and-mod-operator/1
 */
fun main() {
    println(divide(10, 3))
    println(divide(43, -8))
}

private fun divide(a: Long, b: Long): Long {

    var dividend = a
    var divisor = b

    // store sign positive/negative
    val sign = (if (((dividend < 0) xor (divisor < 0))) -1 else 1).toLong()

    // convert both number to positive
    dividend = abs(dividend.toDouble()).toLong()
    divisor = abs(divisor.toDouble()).toLong()

    var quotient: Long = 0

    while (dividend >= divisor) {
        dividend -= divisor // subtract divisor number
        ++quotient
    }

    if (sign == -1L) {
        quotient = -quotient
    }

    return quotient
}








