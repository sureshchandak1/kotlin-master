package graph

fun main() {
    println("Enter the number of nodes")
    val n = readln().toInt()

    println("Enter the number of edges")
    val m = readln().toInt()

    val graph = Graph()

    for (i in 0 ..< m) {
        val components: List<String> = readln().split(" ")
        val u = components[0].toInt()
        val v = components[1].toInt()
        // creating an undirected graph
        graph.addEdge(u, v, 0)
    }

    // printing graph
    graph.printAdjacencyLists()
}

internal class Graph {

    // Adjacency Lists - Map = Node, Connected nodes list
    private val adj: MutableMap<Int, MutableList<Int>> = HashMap()

    /**
     * @param u - first edge
     * @param v - second edge
     * @param direction - 0 = undirected graph, 1 = directed graph
     * @return
     */
    fun addEdge(u: Int, v: Int, direction: Int) {

        // create an edge from u to v
        adj.putIfAbsent(u, ArrayList())
        adj[u]?.add(v)

        if (direction == 0) { // Undirected graph
            adj.putIfAbsent(v, ArrayList())
            adj[v]?.add(u)
        }
    }

    fun printAdjacencyLists() {
        for (entry in adj.entries) {
            print("${entry.key} -> {")
            for ((index, node) in entry.value.withIndex()) {
                print(node)
                if (index < entry.value.size - 1) {
                    print(", ")
                }
            }
            print("}")
            println()
        }
    }

}