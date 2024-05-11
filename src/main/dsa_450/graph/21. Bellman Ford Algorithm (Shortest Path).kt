package graph

import printArray

/**
 *    https://www.geeksforgeeks.org/problems/negative-weight-cycle3504/1
 *    T.C = O(n * m)
 *    S.C = O(n)
 */
fun main() {
    val n = 5
    val edges = arrayOf(
        intArrayOf(0, 1, -1), intArrayOf(0, 2, 4), intArrayOf(1, 2, 3), intArrayOf(1, 3, 2),
        intArrayOf(1, 4, 2), intArrayOf(3, 2, 5), intArrayOf(3, 1, 1), intArrayOf(4, 3, -3)
    )
    println(bellmanFord(n, edges.size, 1, 4, edges))
    println(isNegativeWeightCycle(n, edges))
}

private fun bellmanFord(n: Int, m: Int, src: Int, dest: Int, edges: Array<IntArray>): Int {

    val largeInt = 1e8.toInt()
    val distance = IntArray(n) { largeInt }

    distance[src] = 0

    // n - 1 times
    for (i in 1 ..< n) { // 1 <= to <= n-1
        for (j in edges.indices) {
            val u = edges[j][0]
            val v = edges[j][1]
            val w = edges[j][2]

            if (distance[u] != largeInt && distance[u] + w < distance[v]) {
                distance[v] = distance[u] + w
            }
        }
    }

    // check for negative cycle
    var isCycle = false
    for (j in edges.indices) {
        val u = edges[j][0]
        val v = edges[j][1]
        val w = edges[j][2]

        if (distance[u] != largeInt && distance[u] + w < distance[v]) {
            isCycle = true
            break
        }
    }

    if (!isCycle) {
        printArray(distance)
        return distance[dest]
    }

    return -1

}

private fun isNegativeWeightCycle(n: Int, edges: Array<IntArray>): Boolean {

    val largeInt = 1e8.toInt()
    val distance = IntArray(n) { largeInt }

    distance[0] = 0

    // n - 1 times
    for (i in 1 ..< n) { // 1 <= to <= n-1
        for (j in edges.indices) {
            val u = edges[j][0]
            val v = edges[j][1]
            val w = edges[j][2]

            if (distance[u] != largeInt && distance[u] + w < distance[v]) {
                distance[v] = distance[u] + w
            }
        }
    }

    // check for negative cycle
    for (j in edges.indices) {
        val u = edges[j][0]
        val v = edges[j][1]
        val w = edges[j][2]

        if (distance[u] != largeInt && distance[u] + w < distance[v]) {
            return true
        }
    }

    return false
}