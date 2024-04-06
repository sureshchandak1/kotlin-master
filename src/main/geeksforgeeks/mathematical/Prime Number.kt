package mathematical

import kotlin.math.sqrt

/*
*   https://www.geeksforgeeks.org/problems/prime-number2314/1
* */
fun main() {
    println(isPrime(5))
    println(isPrime(25))
    println(isPrime(19))
    println(isPrime(2001))
}

private fun isPrime(n: Int): Boolean {

    if (n <= 1) {
        return false
    }

    if (n == 2) {
        return true
    }

    if (n % 2 == 0) {
        return false
    }

    val sqrt = sqrt(n.toDouble()).toInt()
    println("sqrt = $sqrt")

    var i = 3
    while (i <= sqrt) {
        if (n % i == 0) {
            return false
        }
        i += 2
    }

    return true
}


