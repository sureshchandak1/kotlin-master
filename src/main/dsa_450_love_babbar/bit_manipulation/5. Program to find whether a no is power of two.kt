package bit_manipulation

/**
 *    https://leetcode.com/problems/power-of-two/description/
 */
fun main() {
    println(isPowerOfTwo1(1))
    println(isPowerOfTwo1(16))
    println(isPowerOfTwo1(3))

    println(isPowerOfTwo2(1))
    println(isPowerOfTwo2(16))
    println(isPowerOfTwo2(3))
}

/**
 *   Time complexity: O(1)
 *   Space complexity: O(1)
 */
private fun isPowerOfTwo1(x: Int): Boolean {
    /* First x in the below expression is
          for the case when x is 0 */
    return x != 0 && ((x and (x - 1)) == 0)
}

/**
 *   Time complexity: O(log N)
 *   Space complexity: O(1)
 */
private fun isPowerOfTwo2(n: Int): Boolean {

    val setBits = getSetBits(n)

    // if setBits = 1 only then it is power of 2
    return setBits == 1
}

private fun getSetBits(n: Int): Int {

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







