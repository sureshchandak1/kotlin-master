package lecture040_Recursion_Day10


fun main() {

    val arr: Array<IntArray> = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1)
    )

    println(findPath(arr, arr.size))
}

private fun findPath(arr: Array<IntArray>, n: Int): ArrayList<String> {
    val ans = ArrayList<String>()

    if (n == 0 || arr[0][0] == 0) {
        return ans
    }

    val srcX = 0
    val srcY = 0

    val visited = Array(n) { IntArray(n) }
    // intialize with 0
    for (i in 0..<n) {
        for (j in 0..<n) {
            visited[i][j] = 0
        }
    }

    val path = StringBuilder()

    solve(arr, n, ans, srcX, srcY, visited, path)

    return ans
}

private fun solve(
    arr: Array<IntArray>, n: Int, ans: ArrayList<String>,
    x: Int, y: Int, visited: Array<IntArray>, path: StringBuilder
) {
    // Base case
    if (x == n - 1 && y == n - 1) {
        ans.add(path.toString())
        return
    }

    visited[x][y] = 1

    // 4 choices - D, L, R, U

    // Down
    var newx = x + 1
    var newy = y
    if (isSafe(newx, newy, n, visited, arr)) {
        path.append("D")
        solve(arr, n, ans, newx, newy, visited, path)
        path.deleteCharAt(path.length - 1)
    }

    // Left
    newx = x
    newy = y - 1
    if (isSafe(newx, newy, n, visited, arr)) {
        path.append("L")
        solve(arr, n, ans, newx, newy, visited, path)
        path.deleteCharAt(path.length - 1)
    }

    // Right
    newx = x
    newy = y + 1
    if (isSafe(newx, newy, n, visited, arr)) {
        path.append("R")
        solve(arr, n, ans, newx, newy, visited, path)
        path.deleteCharAt(path.length - 1)
    }

    // Up
    newx = x - 1
    newy = y
    if (isSafe(newx, newy, n, visited, arr)) {
        path.append("U")
        solve(arr, n, ans, newx, newy, visited, path)
        path.deleteCharAt(path.length - 1)
    }


    visited[x][y] = 0
}

private fun isSafe(x: Int, y: Int, n: Int, visited: Array<IntArray>, arr: Array<IntArray>): Boolean {
    return (x in 0..<n) && (y in 0..<n) && (visited[x][y] == 0) && (arr[x][y] == 1)
}