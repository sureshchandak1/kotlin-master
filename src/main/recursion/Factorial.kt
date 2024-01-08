fun main() {
    println(factorial(3))
    println(factorial(5))
    println(factorial1(5))
    println(factorial(6))
    println(factorial1(6))
}

private fun factorial(n: Int) : Int {

    if (n == 0) return 1 // Base Case (Mandatory) - When to stop function calling again

    val smallerProblem = factorial(n - 1)
    val biggerProblem = n * smallerProblem

    return biggerProblem
}

private fun factorial1(n: Int) : Int {

    if (n == 0) return 1 // Base Case (Mandatory) - When to stop function calling again

    return n * factorial(n - 1)
}