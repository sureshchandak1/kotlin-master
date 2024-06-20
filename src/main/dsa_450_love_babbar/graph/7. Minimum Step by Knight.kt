package graph

import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/steps-by-knight5927/1
 *    Time complexity: O(N2), n square
 *    Space complexity: O(N2), n square
 */
fun main() {
    println(minStepToReachTarget(intArrayOf(4, 5), intArrayOf(1, 1), 6))
    println(minStepToReachTarget(intArrayOf(1, 3), intArrayOf(5, 0), 8))
}

// x and y direction, where a knight can move
private val dx = intArrayOf(-2, -1, 1, 2, -2, -1, 1, 2)
private val dy = intArrayOf(-1, -2, -2, -1, 1, 2, 2, 1)

// BFS (shortest path in an unweighted graph)
private fun minStepToReachTarget(kNightPos: IntArray, targetPos: IntArray, n: Int): Int {

    val visited = Array(n + 1) { BooleanArray(n + 1) }

    val q: Queue<Cell> = LinkedList()

    q.add(Cell(kNightPos[0], kNightPos[1], 0))
    visited[kNightPos[0]][kNightPos[1]] = true

    while (!q.isEmpty()) {
        val front = q.remove()

        if (front.x == targetPos[0] && front.y == targetPos[1]) {
            return front.dis
        }

        for (i in 0..7) {
            val xNext = front.x + dx[i]
            val yNext = front.y + dy[i]

            if (isInside(xNext, yNext, n) && !visited[xNext][yNext]) {
                q.add(Cell(xNext, yNext, front.dis + 1))
                visited[xNext][yNext] = true
            }
        }
    }

    return -1
}

private fun isInside(x: Int, y: Int, n: Int): Boolean {
    return (x >= 1 && y >= 1 && x <= n && y <= n)
}

private class Cell(x: Int, y: Int, dis: Int) {

    var x: Int = 0
    var y: Int = 0
    var dis: Int = 0

    init {
        this.x = x
        this.y = y
        this.dis = dis
    }
}





