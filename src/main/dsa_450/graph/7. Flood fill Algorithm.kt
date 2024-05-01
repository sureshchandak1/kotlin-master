package graph

import lecture023_2D_arrays.printArray2D
import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
 *    https://leetcode.com/problems/flood-fill/
 *    Time Complexity: O(n * m)
 *    Space Complexity: O(n * m)
 */
fun main() {
    var image = arrayOf(intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 0))
    image = floodFill(image, 1, 0, 2)
    printArray2D(image)
    println("-------------------------")
    image = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    image = floodFill(image, 1, 1, 2)
    printArray2D(image)
    println("-------------------------")
    image = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
    image = floodFill(image, 0, 0, 0)
    printArray2D(image)
}

private val dx = intArrayOf(1, 0, 0, -1)
private val dy = intArrayOf(0, -1, 1, 0)

private fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {

    fillFloodBFS(image, sr, sc, image[sr][sc], newColor)

    return image
}

// BFS
private fun fillFloodBFS(image: Array<IntArray>, row: Int, col: Int, prevColor: Int, newColor: Int) {
    println("prevColor = $prevColor, newColor = $newColor")

    val q: Queue<Pair<Int, Int>> = LinkedList()

    q.add(Pair(row, col))

    image[row][col] = newColor

    while (!q.isEmpty()) {
        val front = q.remove();

        for (i in 0..<4) {

            val newRow = front.first + dx[i]
            val newCol = front.second + dy[i]

            if (isValid(image, newRow, newCol, prevColor, newColor)) {
                image[newRow][newCol] = newColor
                q.add(Pair(newRow, newCol))
            }
        }
    }
}

// DFS
private fun fillFloodDFS(image: Array<IntArray>, row: Int, col: Int, prevColor: Int, newColor: Int) {

    image[row][col] = newColor

    for (i in 0..<4) {

        val newRow = row + dx[i]
        val newCol = col + dy[i]

        if (isValid(image, newRow, newCol, prevColor, newColor)) {
            fillFloodDFS(image, newRow, newCol, prevColor, newColor)
        }
    }
}

private fun isValid(image: Array<IntArray>, row: Int, col: Int, prevColor: Int, newColor: Int): Boolean {
    val rSize = image.size
    val cSize = image[0].size

    return (row >= 0 &&
            col >= 0 &&
            row < rSize &&
            col < cSize &&
            image[row][col] == prevColor &&
            image[row][col] != newColor
            )
}




