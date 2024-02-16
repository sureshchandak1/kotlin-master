package _31

fun main() {
    println(power(2, 4))
}

private fun power(n : Int, p: Int): Int {

    // Base case
    if (p == 0) {
        return 1
    }

    val small = power(n, p - 1)
    val ans = n * small

    return ans
}