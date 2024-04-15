package lecture097_Kruskals_Algorithm

import java.util.*


// Using Kruskal's Algorithm

/**
 *   https://www.naukri.com/code360/problems/minimum-spanning-tree_631769
 *   T.C = O(n log n)
 *   S>C = O(n)
 */
fun main() {
    var n = 4
    var edges = arrayListOf(
        arrayListOf(0, 1, 3),
        arrayListOf(0, 3, 5),
        arrayListOf(1, 2, 1),
        arrayListOf(2, 3, 8)
    )
    println(minimumSpanningTree(edges, n))

    n = 4
    edges = arrayListOf(
        arrayListOf(0, 1, 3),
        arrayListOf(0, 2, 1),
        arrayListOf(0, 3, 2),
        arrayListOf(1, 2, 5),
        arrayListOf(1, 3, 2),
        arrayListOf(2, 3, 4)
    )
    println(minimumSpanningTree(edges, n))
}

private fun minimumSpanningTree(edges: ArrayList<ArrayList<Int>>, n: Int): Int {

    Collections.sort(edges, EdgeComparator())

    val parent = IntArray(n)
    val rank = IntArray(n)

    makeSet(parent, rank, n)

    var minWeight = 0

    for (i in edges.indices) {
        val u = findParent(parent, edges[i][0])
        val v = findParent(parent, edges[i][1])
        val wt = edges[i][2]

        if (u != v) {
            minWeight += wt
            unionSet(u, v, parent, rank)
        }
    }

    return minWeight
}

private fun makeSet(parent: IntArray, rank: IntArray, n: Int) {
    for (i in 0..< n) {
        parent[i] = i
        rank[i] = 0
    }
}

private fun findParent(parent: IntArray, node: Int): Int {
    // Base case
    if (parent[node] == node) {
        return node
    }
    // return parent[node] = findParent(parent, parent[node]); -> in Java
    return findParent(parent, parent[node]).also { parent[node] = it }
}

private fun unionSet(u: Int, v: Int, parent: IntArray, rank: IntArray) {
    var u = u
    var v = v

    u = findParent(parent, u)
    v = findParent(parent, v)

    if (rank[u] < rank[v]) {
        parent[u] = v
    } else if (rank[v] < rank[u]) {
        parent[v] = u
    } else {
        parent[v] = u
        rank[u]++
    }
}

private class EdgeComparator : Comparator<ArrayList<Int>> {
    override fun compare(list1: ArrayList<Int>, list2: ArrayList<Int>): Int {
        if (list1[2] < list2[2]) return -1
        else if (list1[2] > list2[2]) return 1
        return 0
    }
}



