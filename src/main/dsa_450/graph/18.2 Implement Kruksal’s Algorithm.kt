package graph

import java.util.ArrayList
import java.util.Collections

/**
 *    Time Complexity: O(E * logV)
 */
fun main() {
    var kruskalMST = KruskalMST(4)
    var edges = arrayListOf(
        arrayListOf(0, 1, 3), arrayListOf(0, 3, 5), arrayListOf(1, 2, 1), arrayListOf(2, 3, 8)
    )
    println(kruskalMST.minimumSpanningTree(edges))

    kruskalMST = KruskalMST(4)
    edges = arrayListOf(
        arrayListOf(0, 1, 3), arrayListOf(0, 2, 1), arrayListOf(0, 3, 2),
        arrayListOf(1, 2, 5), arrayListOf(1, 3, 2), arrayListOf(2, 3, 4)
    )
    println(kruskalMST.minimumSpanningTree(edges))
}

// Kruskal’s Minimum Spanning Tree (MST) Algorithm
private class KruskalMST(private val n: Int) {

    private val parent = IntArray(n)
    private val rank = IntArray(n) { 0 }

    init {
        makeSet()
    }

    private fun makeSet() {
        for (i in 0 ..< n) {
            parent[i] = i
        }
    }

    fun minimumSpanningTree(edges: ArrayList<ArrayList<Int>>): Int {

        Collections.sort(edges, EdgeComparator()) // O(E * logE)

        var minWeight = 0

        for (i in edges.indices) { // O(E)
            val uParent = findParent(edges[i][0])
            val vParent = findParent(edges[i][1])
            val wt = edges[i][2]

            if (uParent != vParent) {
                minWeight += wt
                unionSet(uParent, vParent) // O(logV)
            }
        }

        return minWeight
    }

    private fun findParent(node: Int): Int {

        if (parent[node] != node) {
            parent[node] = findParent(parent[node])
        }

        return parent[node]
    }

    private fun unionSet(u: Int, v: Int) {

        val uParent = parent[u]
        val vParent = parent[v]

        if (uParent == vParent) return

        val uRank = rank[uParent]
        val vRank = rank[vParent]

        if (uRank < vRank) {
            parent[uParent] = vParent
        } else if (vRank < uRank) {
            parent[vParent] = uParent
        } else {
            parent[vParent] = uParent
            rank[uParent]++
        }
    }

    private class EdgeComparator : Comparator<ArrayList<Int>> {
        override fun compare(o1: ArrayList<Int>?, o2: ArrayList<Int>?): Int {
            if (o1 == null || o2 == null) return 0
            if (o1[2] < o2[2]) return -1
            if (o1[2] > o2[2]) return 1
            return 0
        }

    }

}




