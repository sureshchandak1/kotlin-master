package bit_manipulation

/**
 *    https://www.geeksforgeeks.org/calculate-square-of-a-number-without-using-and-pow/
 */
fun main() {
    println(square(5))
    println(square(10))
    println(square(25))
}

private fun square(n: Int): Int {

    var value = n
    // Base case
    if (value == 0) return 0

    // Handle negative number
    if (value < 0) value = -value

    // Get floor(n/2) using
    // right shift
    val x = value shr 1


    // If n is odd
    return if (value % 2 != 0) {
        (square(x) shl 2) + (x shl 2) + 1
    }
    else  { // If n is even
        square(x) shl 2
    }
}








