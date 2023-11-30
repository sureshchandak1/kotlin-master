fun main() {
    println(" ".repeat(5).plus("#".repeat(6 - 5)))
    println()
    println()
    staircase1(6)
    println()
    println()
    staircase2(6)
}

private fun staircase1(n: Int): Unit {
    for (step in n - 1 downTo 0) {
        println(" ".repeat(step).plus("#".repeat(n - step)))
    }
}

private fun staircase2(n: Int): Unit {
    for (x in n - 1 downTo 0) {
        for (y in 0 until n) {
            if (x > y) {
                print(" ")
            } else {
                print("#")
            }
        }
        println()
    }
}



