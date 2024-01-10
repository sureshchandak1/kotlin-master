// Count total paths in a maze to move from (0, 0) to (n, m)
fun main() {
    val n = 3
    val m = 4
    val totalPaths = countPaths(0, 0, n, m)
    println("Total Paths = $totalPaths")
}

private fun countPaths(i: Int, j: Int, n: Int, m: Int) : Int {

    if (i == n || j == m) {
        return 0
    }
    if (i == n - 1 && j == m - 1) {
        return 1
    }

    // move downwards
    val downPaths = countPaths(i + 1, j, n, m)

    // move right
    val rightPaths = countPaths(i, j + 1, n, m)

    return downPaths + rightPaths

}
