package mathematical

import kotlin.math.pow

/*
*   https://www.geeksforgeeks.org/problems/print-the-kth-digit3520/1
* */
fun main() {
    print("${kthDigit(12, 11, 4)}\n")
    print("${kthDigit(5, 5, 2)}\n")
}

private fun kthDigit(a: Int, b: Int, k: Int): Long {

    var power = a.toDouble().pow(b.toDouble()).toLong()
    print("$power, $k kth = ")

    var count = 0
    while (power > 0 && count < k) {

        val rem = power % 10

        count++

        if (count == k) {
            return rem
        }

        power /= 10
    }

    return 0
}



