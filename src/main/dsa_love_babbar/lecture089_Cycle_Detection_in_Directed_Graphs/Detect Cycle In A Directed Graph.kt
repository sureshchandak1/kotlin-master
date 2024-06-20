package lecture089_Cycle_Detection_in_Directed_Graphs


/**
 * https://www.naukri.com/code360/problems/detect-cycle-in-a-directed-graph_1062626
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

    println(detectCycleInDirectedGraph(n, edges))

    n = 5
    m = 4
    edges = arrayListOf(
        arrayListOf(1, 2),
        arrayListOf(2, 3),
        arrayListOf(3, 4),
        arrayListOf(4, 5)
    )

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

    // call dfs for all components
    val visited: MutableMap<Int, Boolean> = HashMap()
    val dfsVisited: MutableMap<Int, Boolean> = HashMap()

    for (i in 1..n) {
        if (!visited.containsKey(i) || !visited[i]!!) {
            val cycleFound = checkCycleDFS(i, visited, dfsVisited, adj)
            if (cycleFound) {
                return true
            }
        }
    }

    return false
}

private fun checkCycleDFS(
    node: Int, visited: MutableMap<Int, Boolean>,
    dfsVisited: MutableMap<Int, Boolean>, adj: Map<Int, MutableList<Int>>
): Boolean {

    visited[node] = true
    dfsVisited[node] = true

    if (adj.containsKey(node)) {
        for (neighbour in adj[node]!!) {
            if (!visited.containsKey(neighbour) || !visited[neighbour]!!) {
                val cycleDetected = checkCycleDFS(neighbour, visited, dfsVisited, adj)
                if (cycleDetected) {
                    return true
                }
            } else if (dfsVisited.containsKey(neighbour) && dfsVisited[neighbour]!!) {
                // visited
                return true
            }
        }
    }

    dfsVisited[node] = false
    return false
}



