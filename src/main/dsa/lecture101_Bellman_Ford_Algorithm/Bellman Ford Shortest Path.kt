package lecture101_Bellman_Ford_Algorithm

import printArray

/**
 *   https://www.naukri.com/code360/problems/bellmon-ford_2041977
 *   T.C = O(n * m)   n = no of nodes, m = no 0f edges
 *   S.C = O(n)
 */
fun main() {
    // 1 <= n <= 50
    var n = 3; var m = 3; var src = 1; var dest = 3
    var edges = listOf( listOf(1, 2, 2), listOf(1, 3, 2), listOf(2, 3, -1) )
    println(bellmanFord(n, m, src, dest, edges))
    println("----------------------------------")

    n = 14; m = 19; src = 1; dest = 13
    edges = listOf(
        listOf(1, 13, 25), listOf(2, 1, 41), listOf(2, 8, -69), listOf(3, 11, 113), listOf(5, 3, 3),
        listOf(5, 10, 107), listOf(5, 12, 121), listOf(6, 5, 56), listOf(6, 9, 125), listOf(8, 10, 90),
        listOf(9, 5, 86), listOf(9, 7, 98), listOf(10, 11, 97), listOf(11, 10, 69), listOf(11, 10, 139),
        listOf(11, 12, 50), listOf(12, 3, 25), listOf(12, 14, 25), listOf(14, 9, 13)
    )
    println(bellmanFord(n, m, src, dest, edges))
    println("----------------------------------")
}

private fun bellmanFord(n: Int, m: Int, src: Int, dest: Int, edges: List<List<Int>>): Int {

    val largeInt: Int = 1e8.toInt()
    val dist = IntArray(n) { largeInt }

    dist[src - 1] = 0 // src - 1 , n is start from 1

    // n - 1 times

    for (i in 1..n) {
        // traverse on edge list
        for (j in 0..< m) {
            val u = edges[j][0] - 1 // -1, n is start from 1
            val v = edges[j][1] - 1 // -1, n is start from 1
            val w = edges[j][2]

            if (dist[u] != largeInt && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w
            }
        }
    }

    // check for negative cycle
    var flag = false
    for (j in 0..< m) {
        val u = edges[j][0] - 1
        val v = edges[j][1] - 1
        val w = edges[j][2]

        if (dist[u] != largeInt && dist[u] + w < dist[v]) {
            flag = true
        }
    }

    if (!flag) {
        printArray(dist)
        return dist[dest - 1]
    }

    return -1
}




