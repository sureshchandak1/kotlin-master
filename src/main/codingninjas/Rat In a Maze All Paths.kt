fun main() {
    var result = ratInAMaze(arrayOf(
        intArrayOf(1, 0),
        intArrayOf(1, 1)
    ), 2)
    println(result)

    result = ratInAMaze(arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(0, 1, 1)
    ), 3)
    println(result)
}

private fun ratInAMaze(arr: Array<IntArray>, n: Int): ArrayList<ArrayList<Int>> {
    val ans = ArrayList<ArrayList<Int>>()

    if (n == 0 || arr[0][0] == 0) {
        return ans
    }

    val srcX = 0
    val srcY = 0

    val visited = Array(n) { IntArray(n) { 0 } }

    val path = ArrayList<Int>()

    solve(arr, n, ans, srcX, srcY, visited, path)


    for (value in ans) {
        val x = value[0]
        val y = value[1]

        for (i in 0 ..< n) {
            for (j in 0 ..< n) {
                if (i == x && j == y) {
                    arr[i][j] = 1
                } else {
                    arr[i][j] = 0
                }
            }
        }

    }

    return ans
}

private fun solve(
    arr: Array<IntArray>, n: Int, ans: ArrayList<ArrayList<Int>>,
    x: Int, y: Int, visited: Array<IntArray>, path: ArrayList<Int>
) {

    // Base case
    if (x == n - 1 && y == n - 1) {
        ans.add(ArrayList(path))
        return
    }

    visited[x][y] = 1

    // 4 choices - D, L, R, U

    // Down
    var newx = x + 1
    var newy = y
    if (isSafe(newx, newy, n, visited, arr)) {
        path.add(newx)
        path.add(newy)

        solve(arr, n, ans, newx, newy, visited, path)

        path.removeAt(path.size - 1)
        path.removeAt(path.size - 1)
    }

    // Left
    newx = x
    newy = y - 1
    if (isSafe(newx, newy, n, visited, arr)) {
        path.add(newx)
        path.add(newy)

        solve(arr, n, ans, newx, newy, visited, path)

        path.removeAt(path.size - 1)
        path.removeAt(path.size - 1)
    }

    // Right
    newx = x
    newy = y + 1
    if (isSafe(newx, newy, n, visited, arr)) {
        path.add(newx)
        path.add(newy)

        solve(arr, n, ans, newx, newy, visited, path)

        path.removeAt(path.size - 1)
        path.removeAt(path.size - 1)
    }

    // Up
    newx = x - 1
    newy = y
    if (isSafe(newx, newy, n, visited, arr)) {
        path.add(newx)
        path.add(newy)

        solve(arr, n, ans, newx, newy, visited, path)

        path.removeAt(path.size - 1)
        path.removeAt(path.size - 1)
    }


    visited[x][y] = 0
}

private fun isSafe(x: Int, y: Int, n: Int, visited: Array<IntArray>, arr: Array<IntArray>): Boolean {
    return (x in 0..<n) && (y in 0..<n) && (visited[x][y] == 0) && (arr[x][y] == 1)
}