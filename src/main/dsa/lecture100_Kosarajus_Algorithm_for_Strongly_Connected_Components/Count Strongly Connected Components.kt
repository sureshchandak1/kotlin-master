package lecture100_Kosarajus_Algorithm_for_Strongly_Connected_Components

import java.util.*

// Kosaraju’s Algorithm

/**
 *   https://www.naukri.com/code360/problems/count-strongly-connected-components-kosaraju-s-algorithm_1171151
 *   T.C = O(N + E)
 *   S>C = O(N)
 */
fun main() {

    var v = 5
    var edges = arrayListOf(
        arrayListOf(0, 1), arrayListOf(1, 2), arrayListOf(1, 4),
        arrayListOf(2, 3), arrayListOf(3, 2), arrayListOf(4, 0)
    )

    println(stronglyConnectedComponents(v, edges))

    v = 8
    edges = arrayListOf(
        arrayListOf(0, 1), arrayListOf(1, 2), arrayListOf(2, 0), arrayListOf(3, 2), arrayListOf(3, 0),
        arrayListOf(4, 3), arrayListOf(3, 4), arrayListOf(5, 0), arrayListOf(4, 5), arrayListOf(7, 4),
        arrayListOf(5, 6), arrayListOf(6, 5), arrayListOf(7, 6)
    )

    println(stronglyConnectedComponents(v, edges))

    v = 5
    edges = arrayListOf(
        arrayListOf(1, 0), arrayListOf(0, 2), arrayListOf(2, 1),
        arrayListOf(3, 2), arrayListOf(4, 3), arrayListOf(2, 4)
    )

    println(stronglyConnectedComponents(v, edges))
}

private fun stronglyConnectedComponents(v: Int, edges: ArrayList<ArrayList<Int>>): Int {
    val e = edges.size
    // Create adj list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()

    for (i in 0..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v_)
    }

    // topological sort
    val topo = Stack<Int>()
    val visited: MutableMap<Int, Boolean> = HashMap()

    for (i in 0..< v) {
        if (!visited.containsKey(i) || !visited[i]!!) {
            dfs(i, visited, topo, adj)
        }
    }

    // create a transpose graph
    val transpose: MutableMap<Int, MutableList<Int>> = HashMap()

    for (i in 0..< v) {
        visited[i] = false
        if (adj.containsKey(i)) {
            for (nbr in adj[i]!!) {
                transpose.putIfAbsent(nbr, ArrayList())
                transpose[nbr]!!.add(i)
            }
        }
    }

    // dfs call using above ordering
    var count = 0
    while (!topo.isEmpty()) {
        val top = topo.pop()

        if (!visited.containsKey(top) || !visited[top]!!) {
            count++
            dfs(top, visited, transpose)
        }
    }

    return count
}

private fun dfs(node: Int, visited: MutableMap<Int, Boolean>, topo: Stack<Int>, adj: Map<Int, MutableList<Int>>) {
    visited[node] = true

    if (adj.containsKey(node)) {
        for (nbr in adj[node]!!) {
            if (!visited.containsKey(nbr) || !visited[nbr]!!) {
                dfs(nbr, visited, topo, adj)
            }
        }
    }
    // topo logic
    topo.add(node)
}

private fun dfs(node: Int, visited: MutableMap<Int, Boolean>, adj: Map<Int, MutableList<Int>>) {
    visited[node] = true

    if (adj.containsKey(node)) {
        for (nbr in adj[node]!!) {
            if (!visited.containsKey(nbr) || !visited[nbr]!!) {
                dfs(nbr, visited, adj)
            }
        }
    }
}




