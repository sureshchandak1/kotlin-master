import kotlin.math.pow

fun main() {
    println(isPowerOfTwo(26))
    println(isPowerOfTwo(2036))

    println(isPowerOfTwo1(26))
    println(isPowerOfTwo1(2036))

    println(isPowerOfTwo2(0))
    println(isPowerOfTwo2(1))
    println(isPowerOfTwo2(26))
    println(isPowerOfTwo2(2036))

    val n = 1000
    println(n.countOneBits())
}

private fun isPowerOfTwo(n: Int): Boolean {
    if (n == 1) return true
    return ((n % 2) == 0)
}

private fun isPowerOfTwo1(n: Int): Boolean {
    for (index in 0 .. 30) {
        if (2.0.pow(index.toDouble()).toInt() == n) {
            return true
        }
    }

    return false
}

private fun isPowerOfTwo2(n: Int): Boolean {
    if (n < 0) {
        return false
    }
    return (n.countOneBits() == 1)
}