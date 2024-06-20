package graph

import printArray
import java.util.LinkedList
import java.util.Queue
import kotlin.collections.ArrayList

// Topological Sort (Kahn's Algorithm)
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

    // Create adj list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()
    for (i in 0 ..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)
    }

    // find all inDegree
    val inDegree = IntArray(v)
    for (entry in adj.entries) {
        for (node in entry.value) {
            inDegree[node]++
        }
    }

    // push all 0 inDegrees node in queue
    val q: Queue<Int> = LinkedList()
    for (i in 0 ..< v) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    // BFS
    val ans = ArrayList<Int>()
    while (!q.isEmpty()) {
        val front = q.remove()

        ans.add(front) // store in ans

        // neighbour inDegrees update
        if (adj.containsKey(front)) {
            val neighbours: MutableList<Int> = adj[front]!!
            for (neighbor in neighbours) {
                inDegree[neighbor]--
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor)
                }
            }
        }
    }

    return ans
}