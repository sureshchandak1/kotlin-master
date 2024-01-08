fun main(args: Array<String>) {
    println(power(2, 10))
    println(power(2, 5))
    println(power1(2, 5))
    println(power(10, 2))
    println(power(0, 2))
}

private fun power(n: Int, power: Int) : Int {

    // Base case
    if (n == 0) return 0
    if (power == 0) return 1

    // Recursive relation
    val smallerProblem = power(n, power - 1)
    val biggerProblem = n * smallerProblem

    return biggerProblem
}

private fun power1(n: Int, power: Int) : Int {

    // Base case
    if (n == 0) return 0
    if (power == 0) return 1

    return if (power % 2 == 0) {
        power1(n, power / 2) * power1(n, power / 2)
    } else {
        power1(n, power / 2) * power1(n, power / 2) * n
    }

}