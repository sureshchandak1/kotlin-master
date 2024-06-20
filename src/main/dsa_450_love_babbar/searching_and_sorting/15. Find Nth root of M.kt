package searching_and_sorting

/**
 *    https://leetcode.com/problems/powx-n/description/
 *    Time complexity: O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    println(myPow(2.0, 10))
    println(myPow(2.10, 3))
    println(myPow(2.0, -2))
}

private fun myPow(x: Double, n: Int): Double {
    return if (n >= 0) {
        quickPow(x, n.toLong())
    } else {
        1 / quickPow(x, -n.toLong())
    }
}

private fun quickPow(base: Double, exponent: Long): Double {

    var base = base
    var exponent = exponent
    var result = 1.0

    while (exponent > 0) {
        // odd
        if ((exponent and 1L) == 1L) {
            result *= base
        }

        // update base value
        base *= base

        // right shift equivalent to integer division by 2
        exponent = exponent shr 1
    }

    return result
}



