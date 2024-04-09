package lecture087_DFS_Traversal_in_Graph

import printArray

/*
*   https://www.naukri.com/code360/problems/dfs-traversal_630462
* */
fun main() {
    var v = 5
    var e = 6
    var edges = arrayListOf(
        arrayListOf(0, 4),
        arrayListOf(2, 0),
        arrayListOf(2, 4),
        arrayListOf(3, 0),
        arrayListOf(3, 2),
        arrayListOf(4, 3)
    )

    var result = depthFirstSearch(v, e, edges)

    for (i in result){
        printArray(i)
    }

    println("-----------------------------------")

    v = 10
    e = 5
    edges = arrayListOf(
        arrayListOf(9, 0),
        arrayListOf(8, 1),
        arrayListOf(7, 2),
        arrayListOf(6, 3),
        arrayListOf(5, 4)
    )

    result = depthFirstSearch(v, e, edges)

    for (i in result){
        printArray(i)
    }
}

private fun depthFirstSearch(v: Int, e: Int, edges: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {

    val ans = ArrayList<ArrayList<Int>>()

    val adjList: MutableMap<Int, MutableList<Int>> = HashMap()
    // prepare adj list
    for (i in 0..< e) {
        val u = edges[i][0]
        val v_ = edges[i][1]

        adjList.putIfAbsent(u, ArrayList())
        adjList[u]!!.add(v_)

        adjList.putIfAbsent(v_, ArrayList())
        adjList[v_]!!.add(u)
    }

    val visited: MutableMap<Int, Boolean> = HashMap()

    for (i in 0..< v) {
        if (!visited.containsKey(i) || !visited[i]!!) {
            val component = ArrayList<Int>()
            dfs(i, visited, adjList, component)
            ans.add(component)
        }
    }

    return ans
}

private fun dfs(
    node: Int, visited: MutableMap<Int, Boolean>,
    adjList: Map<Int, MutableList<Int>>, component: ArrayList<Int>
) {
    // ans store
    component.add(node)
    // mark visited
    visited[node] = true

    // for connected node recursive call
    if (adjList.containsKey(node)) {
        for (neaibours in adjList[node]!!) {
            if (!visited.containsKey(neaibours) || !visited[neaibours]!!) {
                dfs(neaibours, visited, adjList, component)
            }
        }
    }
}


