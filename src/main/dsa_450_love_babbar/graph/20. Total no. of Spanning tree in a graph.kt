package graph

import lecture023_2D_arrays.printArray2D

fun main() {
    val n = 5; val m = 14
    val edges = arrayListOf(
        arrayListOf(1, 2, 2), arrayListOf(1, 4, 6), arrayListOf(2, 1, 2), arrayListOf(2, 3, 3), arrayListOf(2, 4, 8),
        arrayListOf(2, 5, 5), arrayListOf(3, 2, 3), arrayListOf(3, 5, 7), arrayListOf(4, 1, 6), arrayListOf(4, 2, 8),
        arrayListOf(4, 5, 9), arrayListOf(5, 2, 5), arrayListOf(5, 3, 7), arrayListOf(5, 4, 9)
    )
    println(totalSpanningTree(n, m, edges))
}

// node start from 1
private fun totalSpanningTree(n: Int, m: Int, edges: ArrayList<ArrayList<Int>>) {

    // Create Adjacency Matrix
    val adjMatrix: Array<IntArray> = Array(n + 1) { IntArray(n + 1) { 0 } }

    for (i in 0 ..< m) {
        val u = edges[i][0]
        val v = edges[i][1]
        val w = edges[i][2]

        adjMatrix[u][v] = 1
        adjMatrix[v][u] = 1
    }

    println("Adjacency Matrix")
    printArray2D(adjMatrix)

    // Create Degree Matrix
    val degreeMatrix: Array<IntArray> = Array(n + 1) { IntArray(n + 1) { 0 } }


}