package bit_manipulation

/**
 *    https://leetcode.com/problems/number-of-1-bits/description/
 *    https://www.geeksforgeeks.org/problems/set-bits0143/1
 *    Time Complexity: O(log n)
 *    Space Complexity: O(1)
 */
fun main() {
    println(setBits1(6))
    println(setBits1(8))
}

private fun setBits1(n:Int):Int {

    // Kernighan's Algorithm

    var value = n
    var count = 0

    while (value != 0) {
        // Right most set bit mask
        // -value = 2's complement
        val rsbMask = (value and -value)
        value -= rsbMask
        count++
    }

    return count

}

private fun setBits2(n: Int): Int {
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







