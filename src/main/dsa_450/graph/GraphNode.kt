package graph

class GraphNode(var data: Int) {
    var neighbors: MutableList<GraphNode?> = ArrayList()
}


