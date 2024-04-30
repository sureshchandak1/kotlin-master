package graph

/**
 *     https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 *     Time Complexity: O(3^(m*n)), every cell we have to try 3 different directions
 *     Space Complexity: O(m*n), maximum depth of the recursion tree
 */
fun main() {
    val arr: Array<IntArray> = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1)
    )

    println(findPath(arr, arr.size))
}

private const val direction = "DLRU"

private val dr = intArrayOf(1, 0, 0, -1)
private val dc = intArrayOf(0, -1, 1, 0)

private fun findPath(m: Array<IntArray>, n: Int): ArrayList<String> {

    val ans = ArrayList<String>()

    if (n == 0 || m[0][0] == 0) {
        return ans
    }

    findPath(m, n, 0, 0, StringBuilder(), ans)

    return ans
}

private fun findPath(
    maze: Array<IntArray>, n: Int, row: Int, col: Int,
    path: StringBuilder, ans: ArrayList<String>
) {

    // Base case
    if (row == n - 1 && col == n - 1) {
        ans.add(path.toString())
        return
    }

    // Mark current cell is visited
    maze[row][col] = 0

    for (i in 0..3) {

        if (isValid(maze, n, row + dr[i], col + dc[i])) {

            path.append(direction[i])

            findPath(maze, n, row + dr[i], col + dc[i], path, ans)

            path.deleteCharAt(path.length - 1)
        }
    }

    // un-mark current cell not visited
    maze[row][col] = 1
}

private fun isValid(maze: Array<IntArray>, n: Int, row: Int, col: Int): Boolean {
    return (row >= 0 && col >= 0 && row < n && col < n && maze[row][col] == 1)
}








