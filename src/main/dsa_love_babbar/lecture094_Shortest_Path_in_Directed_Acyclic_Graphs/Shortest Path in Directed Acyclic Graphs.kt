package lecture094_Shortest_Path_in_Directed_Acyclic_Graphs

import printArray
import java.util.Stack

/**
 *   T.C = O(N + E)
 *   S.C = O(N + E)
 */
fun main() {
    val n = 6
    val g = Graph(n)

    g.addEdge(0, 1, 5)
    g.addEdge(0, 2, 3)
    g.addEdge(1, 2, 2)
    g.addEdge(1, 3, 6)
    g.addEdge(2, 3, 7)
    g.addEdge(2, 4, 4)
    g.addEdge(2, 5, 2)
    g.addEdge(3, 4, -1)
    g.addEdge(4, 5, -2)

    g.printAdj()

    // topological sort
    g.topologicalSort()

    val src = 1
    printArray(g.getShortestPath(src))


}

/**
 *   @param n = number of nodes
 */
private class Graph(private val n: Int) {

    private val adj: MutableMap<Int, MutableList<Pair<Int, Int>>> = HashMap()
    private val visited: MutableMap<Int, Boolean> = HashMap()
    private val topo: Stack<Int> = Stack()

    fun addEdge(u: Int, v: Int, weight: Int) {
        val pair: Pair<Int, Int> = Pair(v, weight)
        adj.putIfAbsent(u, ArrayList())
        adj[u]?.add(pair)
    }

    fun topologicalSort() {
        for (i in 0 ..< n) {
            if (!visited.containsKey(i) || !visited[i]!!) {
                dfs(i)
            }
        }
    }

    fun dfs(node: Int) {
        visited[node] = true

        if (adj.containsKey(node)) {
            for (neighbour in adj[node]!!) {
                if (!visited.containsKey(neighbour.first) || !visited[neighbour.first]!!) {
                    dfs(neighbour.first)
                }
            }
        }

        topo.push(node)
    }

    /**
     *  @param src = starting node
     */
    fun getShortestPath(src: Int) : IntArray {
        val dist = IntArray(n)

        for (i in 0 ..< n) {
            dist[i] = Int.MAX_VALUE
        }

        dist[src] = 0

        while (!topo.isEmpty()) {
            val top = topo.pop()

            if (dist[top] != Int.MAX_VALUE) {
                if (adj.containsKey(top)) {
                    for (neighbour: Pair<Int, Int> in adj[top]!!) {
                        if (dist[top] + neighbour.second < dist[neighbour.first]) {
                            dist[neighbour.first] = dist[top] + neighbour.second
                        }
                    }
                }
            }
        }

        return dist
    }

    fun printAdj() {
        for (entry in adj.entries) {
            print("${entry.key} -> ")
            for (pair in entry.value) {
                print("[${pair.first}, ${pair.second}], ")
            }
            println()
        }
    }
}



