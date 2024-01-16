package easy

import kotlin.math.pow

fun main() {
    val n = readln()
    println(bitwiseComplement(n.toInt()))
}

private fun bitwiseComplement(n: Int): Int {

    var m = n
    var mask = 0

    while (m != 0) {
        mask = (mask shl 1) or 1
        m = m shr 1
    }

    val ans = (n.inv()) and mask

    return ans

}

private fun decimalToBinary(n: Int) : Int {

    var value = n
    var ans = 0
    var i = 0

    while (value != 0) {
        val bit = value and 1

        // ans = (bit * Math.pow(10, i) + ans
        ans += bit * 10.0.pow(i.toDouble()).toInt()

        value = value shr 1
        ++i
    }

    return ans
}

