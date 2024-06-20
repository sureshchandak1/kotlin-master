package lecture096_Prims_Algorithm_Minimum_Spanning_Tree

import printArray

/**
 *   https://www.naukri.com/code360/problems/prim-s-mst_1095633
 *   T.C =
 *   S.C =
 */
fun main() {
    var n = 5; var m = 14
    var edges = arrayListOf(
        arrayListOf(1, 2, 2),
        arrayListOf(1, 4, 6),
        arrayListOf(2, 1, 2),
        arrayListOf(2, 3, 3),
        arrayListOf(2, 4, 8),
        arrayListOf(2, 5, 5),
        arrayListOf(3, 2, 3),
        arrayListOf(3, 5, 7),
        arrayListOf(4, 1, 6),
        arrayListOf(4, 2, 8),
        arrayListOf(4, 5, 9),
        arrayListOf(5, 2, 5),
        arrayListOf(5, 3, 7),
        arrayListOf(5, 4, 9)
    )
    val result = calculatePrimsMST(n, m, edges)
    for (ans in result) {
        printArray(ans)
    }
}

private fun calculatePrimsMST(n: Int, m: Int, g: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {

    // Create adj list
    // pair first = node, second = weight
    val adj: MutableMap<Int, MutableList<Pair<Int, Int>>> = HashMap()

    for (i in 0..< m) {
        val u = g[i][0]
        val v = g[i][1]
        val w = g[i][2]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(Pair(v, w))

        adj.putIfAbsent(v, ArrayList())
        adj[v]!!.add(Pair(u, w))
    }

    val key = IntArray(n + 1)
    val mst = BooleanArray(n + 1)
    val parent = IntArray(n + 1)

    for (i in 0..n) {
        key[i] = Int.MAX_VALUE
        parent[i] = -1
        mst[i] = false
    }

    // start algo
    key[1] = 0
    parent[1] = -1

    for (i in 1..< n) {

        var mini = Int.MAX_VALUE
        var u = 0
        // find the min node in key array
        for (v in 1..n) {
            if (!mst[v] && key[v] < mini) {
                u = v
                mini = key[v]
            }
        }

        // mark min node as true
        mst[u] = true

        // check its adjacent nodes
        if (adj.containsKey(u)) {
            for (it in adj[u]!!) {
                val v = it.first // node
                val w = it.second // weight

                if (!mst[v] && w < key[v]) {
                    parent[v] = u
                    key[v] = w
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




