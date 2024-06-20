package lecture031_Recursion_Day1

fun main() {
    printCountingHighToLow(5)
    println("------------------------")
    printCountingLowToHigh(5)
}

// Tail recursion
private fun printCountingHighToLow(n: Int) {

    // Base case
    if (n == 0) {
        return
    }

    // Processing
    println(n)

    // Recursion relation
    printCountingHighToLow(n - 1)
}

// Head recursion
private fun printCountingLowToHigh(n: Int) {

    // Base case
    if (n == 0) {
        return
    }

    // Recursion relation
    printCountingLowToHigh(n - 1)

    // Processing
    println(n)
}