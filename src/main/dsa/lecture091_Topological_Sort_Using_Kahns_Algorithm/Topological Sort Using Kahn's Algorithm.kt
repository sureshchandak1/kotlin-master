package lecture091_Topological_Sort_Using_Kahns_Algorithm

import printArray
import java.util.*

/**
 *   https://www.naukri.com/code360/problems/topological-sort_982938
 *   T.C = 0(N + E)
 *   S.C = 0(N + E)
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
    // create adj list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()

    for (i in 0..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)
    }

    // find all indegrees
    val indegrees = IntArray(v)
    for ((_, value) in adj) {
        for (j in value) {
            indegrees[j]++
        }
    }

    // push all 0 indegrees in queue
    val q: Queue<Int> = LinkedList()
    for (i in 0..< v) {
        if (indegrees[i] == 0) {
            q.add(i)
        }
    }

    // do bfs
    val ans = ArrayList<Int>()
    while (!q.isEmpty()) {
        val front = q.remove()

        // ans store
        ans.add(front)

        // neighbour indegrees update
        if (adj.containsKey(front)) {
            for (neighbour in adj[front]!!) {
                indegrees[neighbour]--
                if (indegrees[neighbour] == 0) {
                    q.add(neighbour)
                }
            }
        }
    }

    return ans
}