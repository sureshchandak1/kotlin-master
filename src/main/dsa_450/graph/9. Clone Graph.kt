package graph

import printArray
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 *   https://leetcode.com/problems/clone-graph/description/
 *   https://www.geeksforgeeks.org/problems/clone-graph/1
 *   Time Complexity: O(V + E), where V is number of vertices and E is number of edges
 *   Space Complexity: O(n)
 */
fun main() {
    val node = buildGraph()
    bfs(node)
    val cloneNode = cloneGraph(node)
    bfs(cloneNode)
}

private fun cloneGraph(node: GraphNode?): GraphNode? {
    return cloneGraphBFS(node)
}

// bfs
private fun cloneGraphBFS(node: GraphNode?): GraphNode? {

    if (node == null) {
        return null
    }

    val q: Queue<GraphNode> = LinkedList()
    val cloneNodeMap: MutableMap<GraphNode, GraphNode> = HashMap() // visited map

    q.add(node)
    cloneNodeMap[node] = GraphNode(node.data)

    while (!q.isEmpty()) {

        val u = q.remove()
        val cloneNodeU: GraphNode? = cloneNodeMap[u]

        if (u.neighbors.isNotEmpty()) {

            val v: MutableList<GraphNode?> = u.neighbors
            for (graphNode in v) {
                if (graphNode != null) {
                    var cloneNodeV = cloneNodeMap[graphNode]
                    if (cloneNodeV == null) {
                        q.add(graphNode)

                        cloneNodeV = GraphNode(graphNode.data)
                        cloneNodeMap[graphNode] = cloneNodeV
                    }

                    cloneNodeU!!.neighbors.add(cloneNodeV)
                }
            }
        }

    }

    return cloneNodeMap[node]
}

// dfs
private val visited: MutableMap<GraphNode, GraphNode> = HashMap()

private fun cloneGraphDFS(node: GraphNode?): GraphNode? {

    // Base case
    if (node == null) {
        return null
    }

    // If the node has already been visited i.e., already cloned,
    // return the cloned node from the map.
    if (visited.containsKey(node)) {
        return visited[node] // already cloned
    }

    val cloneNode = GraphNode(node.data) // Create a new node
    visited[node] = cloneNode // Mark this node as visited

    // Iterate over all the neighbors
    for (neighbor in node.neighbors) {
        // depth-first search (DFS) for each neighbor
        val cNode = cloneGraphDFS(neighbor)
        cloneNode.neighbors.add(cNode)
    }

    return cloneNode
}

private fun bfs(node: GraphNode?) {
    val ans = ArrayList<Int>()

    if (node == null) {
        return
    }

    val q: Queue<GraphNode> = LinkedList()
    val visited: MutableMap<GraphNode, Boolean> = HashMap()

    q.add(node)
    visited[node] = true

    while (!q.isEmpty()) {
        val temp = q.remove()

        ans.add(temp.data)

        for (neighbor in temp.neighbors) {
            if (!visited.getOrDefault(neighbor, false)) {
                q.add(neighbor)
                visited[neighbor!!] = true
            }
        }
    }

    printArray(ans)
}

private fun buildGraph(): GraphNode {
    /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */
    val node1 = GraphNode(1)
    val node2 = GraphNode(2)
    val node3 = GraphNode(3)
    val node4 = GraphNode(4)
    var v: MutableList<GraphNode?> = ArrayList()
    v.add(node2)
    v.add(node4)
    node1.neighbors = v
    v = Vector<GraphNode>()
    v.add(node1)
    v.add(node3)
    node2.neighbors = v
    v = Vector<GraphNode>()
    v.add(node2)
    v.add(node4)
    node3.neighbors = v
    v = Vector<GraphNode>()
    v.add(node3)
    v.add(node1)
    node4.neighbors = v
    return node1
}











