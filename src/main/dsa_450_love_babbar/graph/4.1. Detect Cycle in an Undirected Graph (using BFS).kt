package graph

import java.util.*

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
            val ans = isCyclicBFS(i, visited, adj)
            if (ans) {
                return true // cycle present
            }
        }
    }

    return false // cycle not present
}

private fun isCyclicBFS(srcNode: Int, visited: MutableMap<Int, Boolean>, adj: Map<Int, List<Int>>): Boolean {

    val parent: MutableMap<Int, Int> = HashMap()
    val q: Queue<Int> = LinkedList()

    visited[srcNode] = true
    parent[srcNode] = -1
    q.add(srcNode)

    while (!q.isEmpty()) {
        val front = q.remove()

        if (adj.containsKey(front)) {
            for (neighbour in adj[front]!!) {
                if (visited.containsKey(neighbour) && visited[neighbour]!! &&
                    parent.containsKey(front) && neighbour != parent[front]
                ) {
                    return true
                } else if (!visited.containsKey(neighbour) || !visited[neighbour]!!) {
                    q.add(neighbour)
                    visited[neighbour] = true
                    parent[neighbour] = front
                }
            }
        }
    }

    return false
}











