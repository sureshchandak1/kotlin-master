package lecture085_Graphs_Creation_and_Implementation

import printArray

fun main() {
    println("Enter the number of nodes")
    val n = readln().toInt()

    println("Enter the number of edges")
    val m = readln().toInt()

    val graph = Graphs<Int>()

    for (i in 0 ..< m) {
        val components = readln().split(" ")
        val u = components[0].toInt()
        val v = components[1].toInt()
        // creating an undirected graph
        graph.addEdge(u, v, 0)
    }

    // printing graph
    graph.printAdjList()
}

private class Graphs<T> {

    val adj: MutableMap<T, MutableList<T>> = HashMap()

    /**
     * @param u - first edge
     * @param v - second edge
     * @param direction - 0 = undirected graph, 1 = directed graph
     * @return
     */
    fun addEdge(u: T, v: T, direction: Int) {

        // create an edge from u to v
        adj.putIfAbsent(u, ArrayList())
        adj[u]?.add(v)

        if (direction == 0) {
            adj.putIfAbsent(v, ArrayList())
            adj[v]?.add(u)
        }
    }

    fun printAdjList() {
        for (entry in adj.entries) {
            print("${entry.key} -> ")
            printArray(entry.value)
        }
    }

}