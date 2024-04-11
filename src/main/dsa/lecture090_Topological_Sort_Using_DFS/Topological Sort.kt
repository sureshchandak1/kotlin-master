package lecture090_Topological_Sort_Using_DFS

import printArray
import java.util.*

/**
 *   https://www.naukri.com/code360/problems/topological-sort_982938
 */
fun main() {
    var v = 5
    var e = 7
    var edges = arrayListOf(
        arrayListOf(0, 3),
        arrayListOf(2, 0),
        arrayListOf(1, 0),
        arrayListOf(1, 2),
        arrayListOf(4, 2),
        arrayListOf(4, 0),
        arrayListOf(4, 3)
    )
    printArray(topologicalSort(edges, v, e))

    v = 4
    e = 6
    edges = arrayListOf(
        arrayListOf(0, 2),
        arrayListOf(3, 2),
        arrayListOf(3, 1),
        arrayListOf(0, 1),
        arrayListOf(3, 0),
        arrayListOf(2, 1)
    )
    printArray(topologicalSort(edges, v, e))
}

private fun topologicalSort(edges: ArrayList<ArrayList<Int>>, v: Int, e: Int): ArrayList<Int> {

    // create adjacency list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()

    for (i in 0..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)
    }

    // call dfs toplogical sort util function for all components
    val visited: MutableMap<Int, Boolean> = HashMap()
    val s = Stack<Int>()

    for (i in 0..< v) {
        if (!visited.containsKey(i) || !visited[i]!!) {
            topoSort(i, visited, s, adj)
        }
    }

    val ans = ArrayList<Int>()

    while (!s.isEmpty()) {
        ans.add(s.pop())
    }

    return ans
}

private fun topoSort(node: Int, visited: MutableMap<Int, Boolean>, s: Stack<Int>, adj: Map<Int, MutableList<Int>>) {
    visited[node] = true

    if (adj.containsKey(node)) {
        for (neighbour in adj[node]!!) {
            if (!visited.containsKey(neighbour) || !visited[neighbour]!!) {
                topoSort(neighbour, visited, s, adj)
            }
        }
    }

    // imp
    s.push(node)
}





