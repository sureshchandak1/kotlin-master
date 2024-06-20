package lecture099_Articulation_Points_in_Graphs

import printArray
import kotlin.math.min

/**
 *    T.C = O(N + E)
 *    S.C = O(N)
 */
fun main() {
    var v = 5; var e = 5
    var edges = arrayOf(
        intArrayOf(0, 3), intArrayOf(3, 4), intArrayOf(0, 4),
        intArrayOf(0, 1), intArrayOf(1, 2)
    )
    println("Articulation Points")
    printArray(findArticulationPoints(edges, v, e))
}

private lateinit var adj: MutableMap<Int, MutableList<Int>>
private lateinit var visited: MutableMap<Int, Boolean>
private lateinit var result: MutableList<Int>
private var timer = 0

private fun findArticulationPoints(edges: Array<IntArray>, v: Int, e: Int) : MutableList<Int> {

    // Initialize
    adj = HashMap()
    visited = HashMap()
    result = ArrayList(v)
    timer = 0

    // Create adj list
    for (i in 0 ..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)

        adj.putIfAbsent(v_, ArrayList())
        adj[v_]!!.add(u)
    }

    val disc = IntArray(v) { -1 }
    val low = IntArray(v) { -1 }
    val parent = -1

    // DFS
    for (i in 0 ..< v) {
        if (!visited.containsKey(i) || !visited[i]!!) {
            dfs(i, parent, disc, low)
        }
    }

    return result
}

private fun dfs(node: Int, parent: Int, disc: IntArray, low: IntArray) {

    visited[node] = true
    timer++
    disc[node] = timer
    low[node] = timer

    var child = 0
    if (adj.containsKey(node)) {
        for (nbr in adj[node]!!) {
            if (nbr == parent) {
                continue
            }
            if (!visited.containsKey(nbr) || !visited[nbr]!!) {
                dfs(nbr, node, disc, low)

                low[node] = min(low[node], low[nbr])
                // check Articulation Points or not
                if (low[nbr] >= disc[node] && parent != -1) {
                    result.add(node)
                }
                child++
            } else {
                low[node] = min(low[node], disc[nbr])
            }
        }
    }

    if (parent == -1 && child > 1) {
        result.add(node)
    }
}



