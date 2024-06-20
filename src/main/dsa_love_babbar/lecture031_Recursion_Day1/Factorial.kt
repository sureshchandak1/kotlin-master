package lecture031_Recursion_Day1

fun main() {
    println(factorial(4))
    println(factorial(5))
    println(factorial(6))
}

private fun factorial(n: Int): Int {

    // Base case
    if (n == 0) {
        return 1
    }

    val small = factorial(n - 1)
    val ans = n * small

    return ans

}