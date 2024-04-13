package lecture093_Shortest_Path_in_Undirected_Graphs

import printArray
import java.util.*

/**
 *   https://www.naukri.com/code360/problems/shortest-path-in-an-unweighted-graph_981297
 *   T.C = 0(N + E),   N = No. of Nodes, E = No. of Edges
 *   S.C = 0(N + E)
 */
fun main() {
    var n = 4 // houses
    var m = 4 // roads
    var s = 1 // source
    var t = 4 // destination
    var edges = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 3)
    )
    printArray(shortestPath(edges, n, m, s, t))

    n = 8
    m = 9
    s = 1
    t = 8
    edges = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(1, 4),
        intArrayOf(2, 5),
        intArrayOf(5, 8),
        intArrayOf(3, 8),
        intArrayOf(4, 6),
        intArrayOf(6, 7),
        intArrayOf(7, 8)
    )
    printArray(shortestPath(edges, n, m, s, t))
}

private fun shortestPath(edges: Array<IntArray>, n: Int, m: Int, s: Int, t: Int): LinkedList<Int> {

    // create adjacency list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()
    val e = edges.size
    for (i in 0..< e) {
        val u = edges[i][0]
        val v = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v)

        adj.putIfAbsent(v, ArrayList())
        adj[v]!!.add(u)
    }

    // do bfs
    val visited: MutableMap<Int, Boolean> = HashMap()
    val parent: MutableMap<Int, Int> = HashMap()
    val q: Queue<Int> = LinkedList()

    q.add(s)
    visited[s] = true
    parent[s] = -1

    while (!q.isEmpty()) {
        val front = q.remove()

        if (adj.containsKey(front)) {
            for (neighbour in adj[front]!!) {
                if (!visited.containsKey(neighbour) || !visited[neighbour]!!) {
                    visited[neighbour] = true
                    parent[neighbour] = front
                    q.add(neighbour)
                }
            }
        }
    }

    // prepare shortest path
    val ans = LinkedList<Int>()
    var currentNode = t
    ans.add(t)

    while (currentNode != s) {
        currentNode = parent[currentNode]!!
        ans.add(currentNode)
    }

    Collections.reverse(ans)
    return ans
}



