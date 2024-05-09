package graph

import printArray
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 *   https://www.geeksforgeeks.org/minimum-time-taken-by-each-job-to-be-completed-given-by-a-directed-acyclic-graph/
 *   Time Complexity: O(V + E)
 *   Space Complexity: O(V)
 */
fun main() {
    var v = 10
    var e = 13
    var edges = arrayListOf(
        arrayListOf(1, 3), arrayListOf(1, 4), arrayListOf(1, 5), arrayListOf(2, 3),
        arrayListOf(2, 8), arrayListOf(2, 9), arrayListOf(3, 6), arrayListOf(4, 6),
        arrayListOf(4, 8), arrayListOf(5, 8), arrayListOf(6, 7), arrayListOf(7, 8), arrayListOf(8, 10)
    )
    printArray(findMinTime(edges, v, e))

    v = 7 ; e = 7
    edges = arrayListOf(
        arrayListOf(1, 2), arrayListOf(2, 3), arrayListOf(2, 4), arrayListOf(2, 5),
        arrayListOf(3, 6), arrayListOf(4, 6), arrayListOf(5, 7)
    )
    printArray(findMinTime(edges, v, e))
}

// using Topological Sort
private fun findMinTime(edges: ArrayList<ArrayList<Int>>, v: Int, e: Int): IntArray {

    // Create adj list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()
    for (i in 0 ..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)
    }

    // find all inDegree
    val inDegree = IntArray(v + 1) // node start from 1
    for (entry in adj.entries) {
        for (node in entry.value) {
            inDegree[node]++
        }
    }

    val job = IntArray(v + 1) { -1 } // node start from 1

    // push all 0 inDegrees node in queue
    val q: Queue<Int> = LinkedList()
    for (i in 1 .. v) { // node start from 1
        if (inDegree[i] == 0) {
            q.add(i)
            job[i] = 1
        }
    }

    // BFS
    while (!q.isEmpty()) {
        val front = q.remove()

        // neighbour inDegrees update
        if (adj.containsKey(front)) {
            val neighbours: MutableList<Int> = adj[front]!!
            for (neighbor in neighbours) {
                inDegree[neighbor]--
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor)
                    job[neighbor] = 1 + job[front]
                }
            }
        }
    }

    return job
}





