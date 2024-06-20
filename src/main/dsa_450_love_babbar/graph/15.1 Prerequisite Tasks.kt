package graph

import java.util.*

/**
 *   https://www.geeksforgeeks.org/problems/prerequisite-tasks/1
 *   Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges
 *   Space Complexity: O(V)
 */
fun main() {
    var n = 4
    var p = 3
    var arr = arrayOf(intArrayOf(1, 0), intArrayOf(2, 1), intArrayOf(3, 2))
    println(isPossible(n, p, arr))

    n = 2 ; p = 2
    arr = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
    println(isPossible(n, p, arr))
}

// using topo sort
private fun isPossible(n: Int, p: Int, prerequisites: Array<IntArray>): Boolean {

    // Create adj list
    val adj = ArrayList<ArrayList<Int>>()
    for (i in 0..<n) {
        adj.add(ArrayList())
    }
    for (i in 0..<p) {
        val u = prerequisites[i][0]
        val v = prerequisites[i][1]
        adj[v].add(u)
    }

    // find all inDegree
    val inDegree = IntArray(n)
    for (neighbors in adj) {
        for (neighbor in neighbors) {
            inDegree[neighbor]++
        }
    }

    // 0 inDegree insert into queue
    val q: Queue<Int> = LinkedList()
    for (i in 0..<n) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    val topo = IntArray(n)
    var index = 0

    while (!q.isEmpty()) {
        val front = q.remove()

        topo[index++] = front

        val neighbors = adj[front]
        for (neighbor in neighbors) {
            inDegree[neighbor]--
            if (inDegree[neighbor] == 0) {
                q.add(neighbor)
            }
        }
    }


    // Check if there is a node whose in-degree is not zero
    for (i in 0..<n) {
        if (inDegree[i] != 0) {
            return false
        }
    }

    return true
}






