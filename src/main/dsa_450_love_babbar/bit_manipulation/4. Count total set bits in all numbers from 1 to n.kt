package bit_manipulation

/**
 *     https://www.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
 */
fun main() {
    println(countSetBits(4))
    println(countSetBits(17))
}

private fun countSetBits(n: Int): Int {
    var setBitsCount = 0

    for (i in 1..n) {
        val count = getSetBitsCount(i)
        //setBitsCount += Integer.bitCount(i)
        setBitsCount += count
    }

    return setBitsCount
}

private fun getSetBitsCount(n: Int): Int {

    var value = n
    var count = 0

    while (value > 0) {
        val bit = value and 1

        if (bit == 1) {
            count++
        }

        value = value shr 1
    }

    return count
}




