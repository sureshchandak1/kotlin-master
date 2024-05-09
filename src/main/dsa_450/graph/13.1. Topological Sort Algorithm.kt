package graph

import printArray
import java.util.Stack
import kotlin.collections.ArrayList

//Topological sorting only exists in Directed Acyclic Graph (DAG).
// If the nodes of a graph are connected through directed edges and the graph does not contain a cycle, it is called a directed acyclic graph(DAG).
// In topological sorting, node u will always appear before node v
/**
 *   https://www.geeksforgeeks.org/problems/topological-sort/1
 *   Time Complexity: O(V + E)
 *   Space Complexity: O(V)
 */
fun main() {
    var v = 5
    var e = 7
    var edges = arrayListOf(
        arrayListOf(0, 3), arrayListOf(2, 0), arrayListOf(1, 0), arrayListOf(1, 2),
        arrayListOf(4, 2), arrayListOf(4, 0), arrayListOf(4, 3)
    )
    printArray(topologicalSort(edges, v, e))

    v = 4 ; e = 6
    edges = arrayListOf(
        arrayListOf(0, 2), arrayListOf(3, 2), arrayListOf(3, 1), arrayListOf(0, 1),
        arrayListOf(3, 0), arrayListOf(2, 1)
    )
    printArray(topologicalSort(edges, v, e))
}

private fun topologicalSort(edges: ArrayList<ArrayList<Int>>, v: Int, e: Int): ArrayList<Int> {

    // create adjacency list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()
    for (i in 0 ..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)
    }

    val visited: MutableMap<Int, Boolean> = HashMap()
    val topoStack: Stack<Int> = Stack()

    for (i in 0 ..< v) {
        if (!visited.getOrDefault(i, false)) {
            topoSort(i, adj, visited, topoStack)
        }
    }

    val ans = ArrayList<Int>()

    while (!topoStack.isEmpty()) {
        ans.add(topoStack.pop())
    }

    return ans
}

private fun topoSort(node: Int, adj: MutableMap<Int, MutableList<Int>>,
                     visited: MutableMap<Int, Boolean>, topoStack: Stack<Int>) {

    visited[node] = true // mark as visited

    if (adj.containsKey(node)) {
        val neighbors: MutableList<Int> = adj[node]!!
        for (neighbor in neighbors) {
            if (!visited.getOrDefault(neighbor, false)) {
                topoSort(neighbor, adj, visited, topoStack)
            }
        }
    }

    topoStack.push(node)
}