package lecture095_Dijkstras_Algorithm

import printArray
import java.util.*


/**
 *   https://www.naukri.com/code360/problems/dijkstra-s-shortest-path_920469
 *   T.C = O(E  log V)  E = edges, V = vertex
 *   S.C = (N + E)
 */
fun main() {
    var v= 4
    var e = 5
    var edges = arrayListOf(
        arrayListOf(0, 1, 5),
        arrayListOf(0, 2, 8),
        arrayListOf(1, 2, 9),
        arrayListOf(1, 3, 2),
        arrayListOf(2, 3, 6)
    )
    printArray(dijkstra(edges, v, e, 0))

    v = 5
    e = 7
    edges = arrayListOf(
        arrayListOf(0, 1, 7),
        arrayListOf(0, 2, 1),
        arrayListOf(0, 3, 2),
        arrayListOf(1, 2, 3),
        arrayListOf(1, 3, 5),
        arrayListOf(1, 4, 1),
        arrayListOf(3, 4, 7)
    )
    printArray(dijkstra(edges, v, e, 0))
}

private fun dijkstra(vec: ArrayList<ArrayList<Int>>, vertices: Int, edges: Int, source: Int): ArrayList<Int> {
    // Create adjacency list
    val adj: MutableMap<Int, MutableList<Adjacency>> = HashMap()

    for (i in 0..< edges) {
        val u = vec[i][0]
        val v = vec[i][1]
        val w = vec[i][2]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(Adjacency(v, w))

        adj.putIfAbsent(v, ArrayList())
        adj[v]!!.add(Adjacency(u, w))
    }

    // creation of distance array with infinite value initially
    val distance = IntArray(vertices)
    for (i in 0..< vertices) {
        distance[i] = Int.MAX_VALUE
    }

    // creation of PriorityQueue on basis distance, node
    val pq = PriorityQueue(NodeComparator())

    distance[source] = 0
    pq.add(GraphNode(0, source))

    while (!pq.isEmpty()) {
        // fetch top record
        val top = pq.peek()

        val nodeDistance = top.distance
        val topNode = top.node

        pq.remove(top)

        // traverse on neighbours
        if (adj.containsKey(topNode)) {
            for (neighbour in adj[topNode]!!) {
                if (nodeDistance + neighbour.weight < distance[neighbour.node]) {
                    var record: GraphNode? = null
                    // find record already present
                    for (gn in pq) {
                        if (gn.distance == distance[neighbour.node] && gn.node == neighbour.node) {
                            record = gn
                            break
                        }
                    }

                    // if record found
                    if (record != null) {
                        pq.remove(record)
                    }

                    // distance update
                    distance[neighbour.node] = nodeDistance + neighbour.weight
                    // record push in set
                    pq.add(GraphNode(distance[neighbour.node], neighbour.node))
                }
            }
        }
    }

    val ans = ArrayList<Int>()

    for (i in distance.indices) {
        ans.add(distance[i])
    }

    return ans
}

private class NodeComparator : Comparator<GraphNode> {
    override fun compare(g1: GraphNode, g2: GraphNode): Int {
        if (g1.distance < g2.distance) return -1
        else if (g1.distance > g2.distance) return 1
        return 0
    }
}

private class Adjacency(node: Int, weight: Int) {
    var node: Int = 0
    var weight: Int = 0

    init {
        this.node = node
        this.weight = weight
    }
}

private class GraphNode(distance: Int, node: Int) {
    var distance: Int = 0
    var node: Int = 0

    init {
        this.distance = distance
        this.node = node
    }
}




