package lecture082_Backtracking_Day1

/*
*   https://www.naukri.com/code360/problems/rat-in-a-maze_1215030
* */
fun main() {

    val arr: Array<IntArray> = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1)
    )

    println(findPath(arr, arr.size).toString())
}

private fun findPath(arr: Array<IntArray>, n: Int): ArrayList<String> {
    val ans = ArrayList<String>()

    if (n == 0 || arr[0][0] == 0) {
        return ans
    }

    val visited = Array(n) { IntArray(n) }
    val path = StringBuilder()
    solve(0, 0, arr, n, visited, path, ans)

    return ans
}

private fun solve(
    x: Int,
    y: Int,
    arr: Array<IntArray>,
    n: Int,
    visited: Array<IntArray>,
    path: StringBuilder,
    ans: ArrayList<String>
) {

    // Base case
    if (x == n - 1 && y == n - 1) {
        ans.add(path.toString())
        return
    }

    // 4 movement
    // D, L, R, U
    visited[x][y] = 1

    // D - Down
    if (isSafe(x + 1, y, arr, n, visited)) {
        path.append("D")
        solve(x + 1, y, arr, n, visited, path, ans)
        path.deleteCharAt(path.length - 1)
    }

    // L - Left
    if (isSafe(x, y - 1, arr, n, visited)) {
        path.append("L")
        solve(x, y - 1, arr, n, visited, path, ans)
        path.deleteCharAt(path.length - 1)
    }

    // R - Right
    if (isSafe(x, y + 1, arr, n, visited)) {
        path.append("R")
        solve(x, y + 1, arr, n, visited, path, ans)
        path.deleteCharAt(path.length - 1)
    }

    // U - Up
    if (isSafe(x - 1, y, arr, n, visited)) {
        path.append("U")
        solve(x - 1, y, arr, n, visited, path, ans)
        path.deleteCharAt(path.length - 1)
    }

    visited[x][y] = 0
}

private fun isSafe(x: Int, y: Int, arr: Array<IntArray>, n: Int, visited: Array<IntArray>): Boolean {
    if ((x in 0..< n) && (y in 0..< n) && (arr[x][y] == 1) && (visited[x][y] == 0)) {
        return true
    }

    return false
}

