package bit_manipulation

/**
 *    https://www.geeksforgeeks.org/problems/bit-difference-1587115620/1
 */
fun main() {
    println(countBitsFlip(10, 20))
    println(countBitsFlip(20, 25))
}

private fun countBitsFlip(a: Int, b: Int): Int {

    var n = a xor b
    var count = 0

    while (n != 0) {
        n = n and (n - 1)
        count++
    }

    return count
}



