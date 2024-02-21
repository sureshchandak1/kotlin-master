package lecture032_Recursion_Day2

fun main() {
    println(fibonacci(10))
}

private fun fibonacci(n: Int): Int {

    // Base Case
    if (n == 0) {
        return 0
    }
    if (n == 1) {
        return 1
    }

    val value1 = fibonacci(n - 1)
    val value2 = fibonacci(n - 2)

    val sum = value1 + value2

    return sum

}