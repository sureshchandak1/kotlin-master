package graph

/**
 *    https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 *    Time Complexity: O(V + E)
 *    Space Complexity: O(V)
 */
fun main() {
    var n = 5
    var edges = arrayListOf(arrayListOf(1, 2), arrayListOf(4, 1), arrayListOf(2, 4),
        arrayListOf(3, 4), arrayListOf(5, 2), arrayListOf(1, 3)
    )
    println(detectCycleInDirectedGraph(n, edges))

    n = 5
    edges = arrayListOf(arrayListOf(1, 2), arrayListOf(2, 3), arrayListOf(3, 4), arrayListOf(4, 5))
    println(detectCycleInDirectedGraph(n, edges))
}

private fun detectCycleInDirectedGraph(n: Int, edges: ArrayList<ArrayList<Int>>): Boolean {

    // Create adjacency list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()

    for (i in edges.indices) {
        val u = edges[i][0]
        val v = edges[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v)
    }

    val isCyclePresent = isCyclic(n, adj)

    return isCyclePresent
}

private fun isCyclic(v: Int, adj: MutableMap<Int, MutableList<Int>>): Boolean {

    val visited: MutableMap<Int, Boolean> = HashMap()
    val dfsVisited: MutableMap<Int, Boolean> = HashMap()

    for (i in 0..< v) {
        if (!visited.getOrDefault(i, false)) {
            val cycleDetected = isCyclicDFS(i, adj, visited, dfsVisited)
            if (cycleDetected) {
                return true
            }
        }
    }

    return false
}

private fun isCyclicDFS(
    node: Int,
    adj: MutableMap<Int, MutableList<Int>>,
    visited: MutableMap<Int, Boolean>,
    dfsVisited: MutableMap<Int, Boolean>
): Boolean {
    visited[node] = true
    dfsVisited[node] = true

    for (neighbor in adj.getOrDefault(node, ArrayList())) {
        if (!visited.getOrDefault(neighbor, false)) {
            val cyclePresent = isCyclicDFS(neighbor, adj, visited, dfsVisited)
            if (cyclePresent) {
                return true
            }
        } else if (dfsVisited.getOrDefault(neighbor, false)) {
            return true
        }
    }

    dfsVisited[node] = false

    return false
}







