package lecture092_Cycle_Detection_in_Directed_Graph_Using_BFS

import java.util.*

/**
 * https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1062626
 *   T.C = 0(N + E)
 *   S.C = 0(N + E)
 */
fun main() {
    var n = 5
    var m = 6
    var edges = arrayListOf(
        arrayListOf(1, 2),
        arrayListOf(4, 1),
        arrayListOf(2, 4),
        arrayListOf(3, 4),
        arrayListOf(5, 2),
        arrayListOf(1, 3)
    )

    println(detectCycleInDirectedGraph1(n, edges))
    println(detectCycleInDirectedGraph2(n, edges))

    n = 5
    m = 4
    edges = arrayListOf(
        arrayListOf(1, 2),
        arrayListOf(2, 3),
        arrayListOf(3, 4),
        arrayListOf(4, 5)
    )

    println(detectCycleInDirectedGraph1(n, edges))
    println(detectCycleInDirectedGraph2(n, edges))
}

private fun detectCycleInDirectedGraph1(n: Int, edges: ArrayList<ArrayList<Int>>): Boolean {

    // create adj list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()
    val e = edges.size
    for (i in 0..< e) {
        val u = edges[i][0] - 1
        val v_ = edges[i][1] - 1

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)
    }

    // find all indegrees
    val indegrees = IntArray(n)
    for ((_, value) in adj)  {
        for (j in value) {
            indegrees[j]++
        }
    }

    // push all 0 indegree in queue
    val q: Queue<Int> = LinkedList()
    for (i in 0..< n) {
        if (indegrees[i] == 0) {
            q.add(i)
        }
    }

    // do bfs
    var cnt = 0
    while (!q.isEmpty()) {
        val front = q.remove()

        cnt++

        // neighbour indegree update
        if (adj.containsKey(front)) {
            for (neighbour in adj[front]!!) {
                indegrees[neighbour]--
                if (indegrees[neighbour] == 0) {
                    q.add(neighbour)
                }
            }
        }
    }

    return if (cnt == n) {
        false
    } else {
        true
    }
}

private fun detectCycleInDirectedGraph2(n: Int, edges: ArrayList<ArrayList<Int>>): Boolean {

    // create adj list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()
    val e = edges.size
    for (i in 0..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)
    }

    // find all indegrees
    val indegrees = IntArray(n + 1)
    for ((_, value) in adj)  {
        for (j in value) {
            indegrees[j]++
        }
    }

    // push all 0 indegree in queue
    val q: Queue<Int> = LinkedList()
    for (i in 1..n) {
        if (indegrees[i] == 0) {
            q.add(i)
        }
    }

    // do bfs
    var cnt = 0
    while (!q.isEmpty()) {
        val front = q.remove()

        cnt++

        // neighbour indegree update
        if (adj.containsKey(front)) {
            for (neighbour in adj[front]!!) {
                indegrees[neighbour]--
                if (indegrees[neighbour] == 0) {
                    q.add(neighbour)
                }
            }
        }
    }

    return if (cnt == n) {
        false
    } else {
        true
    }
}




