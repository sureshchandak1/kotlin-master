package easy

fun main() {
    println(hammingWeight(11))
    println(decimalToBinary(11))
}

fun hammingWeight(n: Int): Int {

    var value = n
    var count = 0

    while (value != 0) {
        val bit: Int = value and 1

        if (bit == 1) {
            ++count
        }

        value = value shr 1
    }

    return count
}

private fun hammingWeight1(n: Int): Int {

    var binaryString = Integer.toBinaryString(n)

    var count = 0
    while (binaryString.isNotEmpty()) {
        if (binaryString.last() == '1') {
            ++count
        }
        binaryString = binaryString.substring(0, binaryString.length - 1)
    }

    return count
}

private fun decimalToBinary(n: Int): Int {

    var value = n
    var ans = 0
    var i = 0

    while (value != 0) {

        val bit = value and 1

        ans = (bit * Math.pow(10.0, i.toDouble())).toInt() + ans

        value = value shr 1

        ++i

    }

    return ans
}