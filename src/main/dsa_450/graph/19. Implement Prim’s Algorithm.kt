package graph

import printArray

/**
 *      ** Spanning Tree **
 *  When you converted graph into a tree (not cycle) with n nodes and (n - 1) edges.
 *  Every node is reachable by any other node
 *
 *      ** Minimum Spanning Tree **
 *  Minimum total cost of weight (when convert to tree)
 */

fun main() {
    val n = 5; val m = 14
    val edges = arrayListOf(
        arrayListOf(1, 2, 2), arrayListOf(1, 4, 6), arrayListOf(2, 1, 2), arrayListOf(2, 3, 3), arrayListOf(2, 4, 8),
        arrayListOf(2, 5, 5), arrayListOf(3, 2, 3), arrayListOf(3, 5, 7), arrayListOf(4, 1, 6), arrayListOf(4, 2, 8),
        arrayListOf(4, 5, 9), arrayListOf(5, 2, 5), arrayListOf(5, 3, 7), arrayListOf(5, 4, 9)
    )
    val result = calculatePrimsMST(n, m, edges)
    for (ans in result) {
        printArray(ans)
    }
}

// node start from 1
private fun calculatePrimsMST(n: Int, m: Int, edges: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {

    // Create adj list
    // pair = connected node, weight
    val adj: MutableMap<Int, MutableList<Pair<Int, Int>>> = HashMap()
    for (i in 0 ..< m) {
        val u = edges[i][0]
        val v = edges[i][1]
        val w = edges[i][2]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(Pair(v, w))

        adj.putIfAbsent(v, ArrayList())
        adj[v]!!.add(Pair(u, w))
    }

    // array index are indicate node, index = node
    val key = IntArray(n + 1) { Int.MAX_VALUE } // node start from 1
    val mst = BooleanArray(n + 1) { false }
    val parent = IntArray(n + 1) { -1 }

    // start algo , start node is 1
    key[1] = 0
    parent[1] = -1

    // array index are indicate node, index = node
    for (node in 1 ..< n) {

        var mini = Int.MAX_VALUE
        var u = 0
        // find the min node in key array
        for (v in 1 .. n) {
            if (!mst[v] && key[v] < mini) {
                mini = key[v]
                u = v
            }
        }

        // mark min node as true
        mst[u] = true

        // check its adjacent nodes
        if (adj.containsKey(u)) {
            val neighbors: MutableList<Pair<Int, Int>> = adj[u]!!
            for (neighbor: Pair<Int, Int> in neighbors) {
                val v = neighbor.first // node
                val w = neighbor.second // weight

                if (!mst[v] && w < key[v]) {
                    key[v] = w
                    parent[v] = u
                }
            }
        }
    }

    val result = ArrayList<ArrayList<Int>>()
    for (i in 2..n) {
        val list = ArrayList<Int>()
        list.add(parent[i])
        list.add(i)
        list.add(key[i])

        result.add(list)
    }

    return result
}
