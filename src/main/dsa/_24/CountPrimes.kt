package _24

// Find Prime number using Sieve method
fun main() {
    println(countPrimes(40))
    println(countPrimes(5000000))
}

// Simple Sieve
private fun countPrimes(n: Int): Int {

    var count = 0
    val prime = BooleanArray(n + 1) { true }

    prime[0] = false; prime[1] = false

    for (i in 2 ..< n) {

        if (prime[i]) {
            count++

            var j = 2 * i
            while (j < n) {
                prime[j] = false

                j += i
            }
        }
    }

    return count

}

// Segmented Sieve
private fun segmentedSieve(n: Int): Int {
    // pending
    return 0
}