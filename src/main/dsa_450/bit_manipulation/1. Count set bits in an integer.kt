package bit_manipulation

/**
 *    https://www.geeksforgeeks.org/problems/set-bits0143/1
 *    Time Complexity: O(log n)
 *    Space Complexity: O(1)
 */
fun main() {
    println(setBits(6))
    println(setBits(8))
}

private fun setBits(n: Int): Int {

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







