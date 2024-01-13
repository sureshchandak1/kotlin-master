fun main() {
    isPrime(8)
    isPrime(5)
    isPrime(11)
}

private fun isPrime(n: Int, index: Int = 2) {

    if (n == index) {
        println("$n = Prime Number")
        return
    }

    if ((n % index) == 0) {
        println("$n = Not Prime Number")
        return
    } else {
        isPrime(n, index + 1)
    }

}




