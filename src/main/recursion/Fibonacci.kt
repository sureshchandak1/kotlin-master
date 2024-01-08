fun main() {
    println(fibonacci1(10))

    print("0 1 ")
    printFibonacci(0, 1, 5)
}

private fun fibonacci1(n: Int) : Int {

    // Base case
    if (n == 0) return 0
    if (n == 1) return 1

    val ans = fibonacci1(n - 1) + fibonacci1(n - 2)

    return ans
}

private fun printFibonacci(first: Int, second: Int, n: Int) {

    if (n == 0) {
        return
    }

    val next = first + second
    print("$next ")

    printFibonacci(second, next, n - 1)
}