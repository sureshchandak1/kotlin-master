package graph

import java.util.ArrayList
import java.util.HashMap

/**
 *    https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 *    Time Complexity: O(V + E)
 *    Space Complexity: O(V)
 */
fun main() {
    var n = 3; var m = 2
    var edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
    println(cycleDetection(edges, n, m))

    n = 6; m = 5
    edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 3), intArrayOf(5, 4), intArrayOf(6, 5))
    println(cycleDetection(edges, n, m))

    n = 5; m = 4
    edges = arrayOf(intArrayOf(1, 4), intArrayOf(3, 1), intArrayOf(5, 4), intArrayOf(5, 1))
    println(cycleDetection(edges, n, m))

    n = 5; m = 3
    edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(3, 4))
    println(cycleDetection(edges, n, m))
}

private fun cycleDetection(edges: Array<IntArray>, n: Int, m: Int): Boolean {

    // Create adjacency list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()

    for (i in 0..< m) {
        val u = edges[i][0]
        val v = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v)

        adj.putIfAbsent(v, ArrayList())
        adj[v]!!.add(u)
    }

    val visited: MutableMap<Int, Boolean> = HashMap()

    for (i in 0..< n) {
        if (!visited.containsKey(i) || !visited[i]!!) {
            val ans = isCyclicDFS(i, -1, visited, adj)
            if (ans) {
                return true // cycle present
            }
        }
    }

    return false // cycle not present
}

private fun isCyclicDFS(
    node: Int,
    parent: Int,
    visited: MutableMap<Int, Boolean>,
    adj: Map<Int, MutableList<Int>>
): Boolean {

    visited[node] = true

    if (adj.containsKey(node)) {
        for (neighbour in adj[node]!!) {
            if (!visited.containsKey(neighbour) || !visited[neighbour]!!) {
                val cycleDetected = isCyclicDFS(
                    node = neighbour,
                    parent = node,
                    visited = visited,
                    adj = adj
                )
                if (cycleDetected) {
                    return true
                }
            } else if (neighbour != parent) {
                // cycle present
                return true
            }
        }
    }

    return false
}




