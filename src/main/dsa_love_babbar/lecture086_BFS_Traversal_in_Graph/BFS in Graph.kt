package lecture086_BFS_Traversal_in_Graph

import printArray
import java.util.*

fun main() {
    var n = 4
    var adj = listOf(
        listOf(0, 1),
        listOf(0, 2),
        listOf(1, 2),
        listOf(0, 3)
    )

    var result: MutableList<Int> = bfsTraversal(n, adj)

    printArray(result)

    println("----------------------------------")

    n = 8
    adj = listOf(
        listOf(0, 1),
        listOf(0, 2),
        listOf(0, 3),
        listOf(1, 4),
        listOf(1, 7),
        listOf(2, 5),
        listOf(3, 6)
    )

    result = bfsTraversal(n, adj)

    printArray(result)
}

private fun bfsTraversal(n: Int, edges: List<List<Int>>): MutableList<Int> {
    // adjacency list
    val adjList: MutableMap<Int, MutableList<Int>> = HashMap()
    prepareAdjList(adjList, edges)

    val ans: MutableList<Int> = ArrayList()
    val visited: MutableMap<Int, Boolean> = HashMap()

    // traverse all components of a graph
    // for loop required for disconnected graph
    /*for (i in 0..< n) {
        if (!visited.containsKey(i) || !visited[i]!!) {
            bfs(adj, visited, ans, i)
        }
    }*/

    bfs(adjList, visited, ans, 0)

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


