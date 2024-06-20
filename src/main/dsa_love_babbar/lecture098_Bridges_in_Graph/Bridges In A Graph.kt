package lecture098_Bridges_in_Graph

import printArray
import kotlin.math.min

/**
 *    https://www.naukri.com/code360/problems/bridges-in-graph_893026
 *    T.C = O(N + E)
 *    S.C = O(N)
 */
fun main() {
    var v = 5; var e = 4
    var edges = arrayOf(
        intArrayOf(0, 1), intArrayOf(3, 1),
        intArrayOf(1, 2), intArrayOf(3, 4)
    )
    var result = findBridges(edges, v, e)
    for (res in result) {
        printArray(res)
    }
    println("-----------------------------------")

    v = 6; e = 7
    edges = arrayOf(
        intArrayOf(1, 2), intArrayOf(1, 0), intArrayOf(0, 2),
        intArrayOf(0, 4), intArrayOf(5, 4), intArrayOf(5, 3), intArrayOf(3, 4)
    )
    result = findBridges(edges, v, e)
    for (res in result) {
        printArray(res)
    }
}

private lateinit var adj: MutableMap<Int, MutableList<Int>>
private lateinit var visited: MutableMap<Int, Boolean>
private lateinit var result: MutableList<MutableList<Int>>
private var timer = 0

private fun findBridges(edges: Array<IntArray>, v: Int, e: Int): MutableList<MutableList<Int>> {

    // initialize
    adj = HashMap()
    visited = HashMap()
    result = ArrayList()
    timer = 0

    // Create adj list
    for (i in 0..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)

        adj.putIfAbsent(v_, ArrayList())
        adj[v_]!!.add(u)
    }

    val disc = IntArray(v)
    val low = IntArray(v)
    val parent = -1

    for (i in 0..< v) {
        disc[i] = -1
        low[i] = -1
    }

    // DFS
    for (i in 0..< v) {
        if (!visited.containsKey(i) || !visited.get(i)!!) {
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

    if (adj.containsKey(node)) {
        for (nbr in adj[node]!!) {
            if (nbr == parent) {
                continue
            }
            if (!visited.containsKey(nbr) || !visited[nbr]!!) {
                dfs(nbr, node, disc, low)

                low[node] = min(low[node].toDouble(), low[nbr].toDouble()).toInt()
                // check edge is bridge
                if (low[nbr] > disc[node]) {
                    val ans: MutableList<Int> = ArrayList()
                    ans.add(node)
                    ans.add(nbr)
                    result.add(ans)
                }
            } else {
                // node already visited and not parent
                // Back edge
                low[node] = min(low[node].toDouble(), disc[nbr].toDouble()).toInt()
            }
        }
    }
}


