fun main(args: Array<String>) {
    println(power(2, 10))
    println(power(2, 5))
    println(power(10, 2))
}

private fun power(n: Int, power: Int) : Int {

    // Base case
    if (power == 0) return 1

    // Recursive relation
    val smallerProblem = power(n, power - 1)
    val biggerProblem = n * smallerProblem

    return biggerProblem
}