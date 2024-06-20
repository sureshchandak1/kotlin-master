package bit_manipulation

/**
 *    https://www.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
 */
fun main() {
    println(findPosition(2))
    println(findPosition(5))
}

private fun findPosition(n: Int): Int {

    if (!isPowerOfTwo(n)) {
        return -1
    }

    var i = 1
    var pos = 1

    while ((i and n) == 0) {
        i = i shl 1
        pos++
    }

    return pos
}

private fun isPowerOfTwo(n: Int): Boolean {
    return (n > 0 && ((n and (n - 1)) == 0))
}



