package graph

import printArray
import java.util.*

/**
 *     https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 *     Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges
 *     Space Complexity: O(V)
 */
fun main() {
    var v = 4
    var adj = listOf(listOf(0, 1), listOf(0, 2), listOf(1, 2), listOf(0, 3))

    var result: MutableList<Int> = bfsTraversal(v, adj)
    printArray(result)

    v = 8
    adj = listOf(listOf(0, 1), listOf(0, 2), listOf(0, 3), listOf(1, 4),
        listOf(1, 7), listOf(2, 5), listOf(3, 6))

    result = bfsTraversal(v, adj)
    printArray(result)
}

// Level Order Traversal
private fun bfsTraversal(n: Int, edges: List<List<Int>>): MutableList<Int> {
    // Adjacency list
    val adjList: MutableMap<Int, MutableList<Int>> = HashMap()
    prepareAdjList(adjList, edges)

    val ans: MutableList<Int> = ArrayList()
    val visited: MutableMap<Int, Boolean> = HashMap()

    // traverse all components of a graph
    // for loop required for disconnected graph
    for (i in 0..< n) {
        if (!visited.containsKey(i) || !visited[i]!!) {
            bfs(adjList, visited, ans, i)
        }
    }

    return ans
}

private fun bfs(adj: MutableMap<Int, MutableList<Int>>, visited: MutableMap<Int, Boolean>, ans: MutableList<Int>, node: Int) {

    val q: Queue<Int> = LinkedList()

    q.add(node)
    visited[node] = true

    while (!q.isEmpty()) {
        val frontNode = q.remove()

        // store front node into ans
        ans.add(frontNode)

        // traverse all neighbours of frontNode
        if (adj.containsKey(frontNode)) {
            for (i in adj[frontNode]!!) {
                if (!visited.containsKey(i) || !visited[i]!!) {
                    q.add(i)
                    visited[i] = true
                }
            }
        }

    }
}

private fun prepareAdjList(adjList: MutableMap<Int, MutableList<Int>>, edges: List<List<Int>>) {
    for (i in edges.indices) {
        val u = edges[i][0]
        val v = edges[i][1]

        adjList.putIfAbsent(u, ArrayList())
        adjList[u]!!.add(v)

        adjList.putIfAbsent(v, ArrayList())
        adjList[v]!!.add(u)
    }
}




