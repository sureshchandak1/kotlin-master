package lecture085_Graphs_Creation_and_Implementation

/*
*    https://www.geeksforgeeks.org/graph-and-its-representations/
* */

fun main() {
    val g = Graph(4)

    g.addEdge(0, 1)
    g.addEdge(0, 2)
    g.addEdge(1, 2)
    g.addEdge(2, 0)
    g.addEdge(2, 3)

    print(g.toString())
}


// Adjacency Matrix representation
private class Graph(private val numVertices: Int) {

    private val adjMatrix = Array(numVertices) { BooleanArray(numVertices) }

    // Add edges
    fun addEdge(i: Int, j: Int) {
        adjMatrix[i][j] = true
        adjMatrix[j][i] = true
    }

    // Remove edges
    fun removeEdge(i: Int, j: Int) {
        adjMatrix[i][j] = false
        adjMatrix[j][i] = false
    }

    // Print the matrix
    override fun toString(): String {
        val s = StringBuilder()
        for (i in 0..< numVertices) {
            s.append("$i: ") // node

            for (j in adjMatrix[i]) {
                s.append((if (j) 1 else 0).toString() + " ")
            }
            s.append("\n")
        }
        return s.toString()
    }

}