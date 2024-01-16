fun main() {
    isPrime(8, 2)
    isPrime(5, 2)
    isPrime(11, 2)
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

private fun isPrime(n: Int) {

    var isPrime = true
    loop@for (index in 2 ..< n) {
        if ((n % index) == 0) {
            isPrime = false
            println("$n = Not Prime Number")
            break@loop
        }
    }

    if (isPrime) {
        println("$n = Prime Number")
    }

}




