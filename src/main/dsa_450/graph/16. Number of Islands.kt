package graph

import java.util.*

/**
 *   https://leetcode.com/problems/number-of-islands/description/
 *   https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
 *   T.C = O(row + col)
 *   S.C = O(row + col)
 */
fun main() {
    var grid = arrayOf(
        charArrayOf('1','1','1','1','0'), charArrayOf('1','1','0','1','0'),
        charArrayOf('1','1','0','0','0'), charArrayOf('0','0','0','0','0')
    )
    println(numIslands(grid))

    grid = arrayOf(
        charArrayOf('1','1','0','0','0'), charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','1','0','0'), charArrayOf('0','0','0','1','1')
    )
    println(numIslands(grid))
}

private val dr = intArrayOf(1, 0, -1, 0) // row direction (4-Direction)
private val dc = intArrayOf(0, 1, 0, -1) // col direction (4-Direction)

//private val dr = intArrayOf(1, 1, 0, -1, -1, -1, 0, 1) // row direction (8-Direction)
//private val dc = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1) // col direction (8-Direction)

private fun numIslands(grid: Array<CharArray>): Int {

    val rSize = grid.size
    val cSize = grid[0].size

    val visited: Array<IntArray> = Array(rSize) { IntArray(cSize) { 0 } }

    var countComponent = 0

    for (row in 0 ..< rSize) {
        for (col in 0 ..< cSize) {

            if (grid[row][col] == '1' && visited[row][col] == 0) {
                bfs(grid, row, col, visited)

                countComponent++
            }
        }
    }

    return countComponent
}

private fun bfs(grid: Array<CharArray>, row: Int, col: Int, visited: Array<IntArray>) {

    // mark visited
    visited[row][col] = 1

    val q: Queue<Pair> = LinkedList()
    q.add(Pair(row, col))

    while (!q.isEmpty()) {
        val front: Pair = q.remove()

        // visit neighbors
        for (i in 0 ..< 4) { // 4-Direction (0 to 4), 8-Direction (0 to 8)

            val newRow = front.row + dr[i]
            val newCol = front.col + dc[i]

            if (isSafe(grid, newRow, newCol, visited)) {
                q.add(Pair(newRow, newCol))
                visited[newRow][newCol] = 1
            }
        }
    }
}

private fun isSafe(grid: Array<CharArray>, row: Int, col: Int, visited: Array<IntArray>): Boolean {
    val rSize = grid.size
    val cSize = grid[0].size

    return ( row >= 0 && col >= 0 && row < rSize && col < cSize &&
            grid[row][col] == '1' && visited[row][col] == 0 )
}

private class Pair(val row: Int, val col: Int)









