package graph

/**
 *    https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
 *    Time complexity: O(V + E)
 *    Space complexity: O(V)
 */
fun main() {
    var n = 6
    var edges = arrayOf(
        intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(1, 3)
    )
    println(makeConnected(n, edges))

    n = 4
    edges = arrayOf(
        intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2)
    )
    println(makeConnected(n, edges))

    n = 6
    edges = arrayOf(
        intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2)
    )
    println(makeConnected(n, edges))
}

private fun makeConnected(n: Int, connections: Array<IntArray>): Int {

    val e = connections.size

    // adj list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()

    var edgesCount = 0

    for (i in 0..<e) {
        val u = connections[i][0]
        val v = connections[i][1]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(v)

        adj.putIfAbsent(v, ArrayList())
        adj[v]!!.add(u)

        edgesCount += 1
    }

    val visited: MutableMap<Int, Boolean> = HashMap()

    var components = 0

    for (i in 0..<n) {
        if (!visited.getOrDefault(i, false)) {

            components += 1

            dfs(i, adj, visited)
        }
    }

    if (edgesCount < n - 1) { // At least n - 1 edges are required
        return -1
    }

    // Count redundant edges
    val redundant = edgesCount - ((n - 1) - (components - 1))

    // Check if components can be rearranged using redundant edges
    if (redundant >= components - 1) {
        return components - 1
    }

    return -1
}

private fun dfs(node: Int, adj: MutableMap<Int, MutableList<Int>>, visited: MutableMap<Int, Boolean>) {

    if (visited.getOrDefault(node, false)) {
        return
    }

    visited[node] = true

    if (adj.containsKey(node)) {
        for (neighbor in adj[node]!!) {
            if (!visited.getOrDefault(neighbor, false)) {
                dfs(neighbor, adj, visited)
            }
        }
    }
}



