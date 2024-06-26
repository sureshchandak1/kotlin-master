package graph

import printArray
import java.util.*

/**
 *   Shortest Paths from Source to all Vertices
 *   Dijkstra’s Algorithm is not valid for negative weights or negative cycles
 *   https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 *   Time Complexity : O( E log(V) ), where E = Number of edges and V = Number of Nodes
 *   Space Complexity : O( E + V )
 */
fun main() {
    var v= 4
    var e = 5
    var edges = arrayListOf(arrayListOf(0, 1, 5), arrayListOf(0, 2, 8), arrayListOf(1, 2, 9),
        arrayListOf(1, 3, 2), arrayListOf(2, 3, 6)
    )
    printArray(dijkstra(edges, v, e, 0))

    v = 5 ; e = 7
    edges = arrayListOf(
        arrayListOf(0, 1, 7), arrayListOf(0, 2, 1), arrayListOf(0, 3, 2), arrayListOf(1, 2, 3),
        arrayListOf(1, 3, 5), arrayListOf(1, 4, 1), arrayListOf(3, 4, 7)
    )
    printArray(dijkstra(edges, v, e, 0))
}

private fun dijkstra(edges: ArrayList<ArrayList<Int>>, vertices: Int, e: Int, source: Int): IntArray {

    // Create adjacency list
    // Pair<Int, Int> = connected node , weight
    val adj: MutableMap<Int, MutableList<Pair<Int, Int>>> = HashMap()
    for (i in 0 ..< e) {
        val u = edges[i][0]
        val v = edges[i][1]
        val w = edges[i][2]

        adj.putIfAbsent(u, ArrayList())
        adj[u]!!.add(Pair(v, w))

        adj.putIfAbsent(v, ArrayList())
        adj[v]!!.add(Pair(u, w))
    }

    // creation of distance array with infinite value initially
    val distance = IntArray(vertices) { Int.MAX_VALUE }

    // Pair<Int, Int> = distance , node
    val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue(PairComparator())

    distance[source] = 0
    pq.add(Pair(0, source))

    while (!pq.isEmpty()) {

        val top: Pair<Int, Int> = pq.peek() // fetch top record

        val nodeDistance = top.first
        val topNode = top.second

        pq.remove(top)

        // traverse on neighbours
        if (adj.containsKey(topNode)) {
            // Pair<Int, Int> = connected node , weight
            val neighbours: MutableList<Pair<Int, Int>> = adj[topNode]!!
            for (neighbour: Pair<Int, Int> in neighbours) {

                if (nodeDistance + neighbour.second < distance[neighbour.first]) {
                    var record: Pair<Int, Int>? = null
                    // find record already present
                    for (pair in pq) {
                        if (pair.first == distance[neighbour.first] && pair.second == neighbour.first) {
                            record = pair
                            break
                        }
                    }

                    if (record != null) { // if record found
                        pq.remove(record)
                    }

                    // distance update
                    distance[neighbour.first] = nodeDistance + neighbour.second
                    // record push in pq
                    pq.add(Pair(distance[neighbour.first], neighbour.first))
                }
            }
        }
    }

    return distance
}

// Pair<Int, Int> = distance , node
private class PairComparator : Comparator<Pair<Int, Int>> {
    override fun compare(o1: Pair<Int, Int>?, o2: Pair<Int, Int>?): Int {
        if (o1 == null || o2 == null) return 0
        if (o1.first < o2.first) return -1
        else if (o1.first > o2.first) return 1
        return 0
    }
}

private fun dijkstra(vertices: Int, adj: ArrayList<ArrayList<ArrayList<Int>>>, source: Int): IntArray {

    // create distance array
    val distance = IntArray(vertices) { Int.MAX_VALUE }

    // create priorityQueue
    val pq: PriorityQueue<GraphPair> = PriorityQueue(PairComparator2())

    distance[source] = 0
    pq.add(GraphPair(0, source))

    while (!pq.isEmpty()) {
        val top = pq.peek()

        val nodeDistance = top.distance
        val topNode = top.node

        pq.remove(top)

        val neighbors: ArrayList<ArrayList<Int>> = adj[topNode]
        for (neighbor: ArrayList<Int> in neighbors) {
            if (nodeDistance + neighbor[1] < distance[neighbor[0]]) {
                var record: GraphPair? = null
                for (p in pq) {
                    if (p.distance == distance[neighbor[0]] && p.node == neighbor[0]) {
                        record = p
                        break
                    }
                }

                if (record != null) {
                    pq.remove(record)
                }

                // distance update
                distance[neighbor[0]] = nodeDistance + neighbor[1]
                // add in pq
                pq.add(GraphPair(distance[neighbor[0]], neighbor[0]))
            }
        }
    }

    return distance
}

private class PairComparator2 : Comparator<GraphPair> {
    override fun compare(p1: GraphPair?, p2: GraphPair?): Int {
        if (p1 == null || p2 == null) return 0
        if (p1.distance < p2.distance) return -1
        else if (p1.distance > p2.distance) return 1
        return 0
    }
}

private class GraphPair(distance: Int, node: Int) {
    var distance: Int = 0
    var node: Int = 0

    init {
        this.distance = distance
        this.node = node
    }
}





