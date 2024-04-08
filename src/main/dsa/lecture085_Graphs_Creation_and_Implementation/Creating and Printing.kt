package lecture085_Graphs_Creation_and_Implementation

import printArray

fun main() {
    var n = 6
    var m = 6
    var edges = arrayOf(
        intArrayOf(0, 2),
        intArrayOf(0, 4),
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(3, 5),
        intArrayOf(5, 4)
    )

    var result = printAdjacency(n, m, edges)
    // print result
    for (i in result) {
        printArray(i!!)
    }

    println("--------------------------- End ---------------------------")

    n = 7
    m = 7
    edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(1, 4),
        intArrayOf(2, 5),
        intArrayOf(3, 5),
        intArrayOf(4, 6)
    )

    result = printAdjacency(n, m, edges)
    // print result
    for (i in result) {
        printArray(i!!)
    }

}

private fun printAdjacency(n: Int, m: Int, edges: Array<IntArray>): Array<IntArray?> {

    val ans: Array<ArrayList<Int>> = Array(n) { ArrayList() }
    // ans array will store all adjacent nodes corresponding on indexes.
    // Adjacent means close to or near something.
    for (i in 0..< m) {
        val u = edges[i][0]
        val v = edges[i][1]

        ans[u].add(v)
        ans[v].add(u)
    }

    val adj: Array<IntArray?> = Array(n) { null }

    for (i in 0..< n) {

        // add row number to the head of the list
        ans[i].add(0, i)

        val k = ans[i].size

        // initialized array for each list of rows
        adj[i] = IntArray(k)

        // initialize values in the corresponding row&col coordinate
        // entering neighbours
        for (j in 0..< k) {
            adj[i]!![j] = ans[i][j]
        }
    }

    return adj
}