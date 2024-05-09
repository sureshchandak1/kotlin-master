package graph

import printArray
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 *   https://leetcode.com/problems/course-schedule-ii/description/
 *   Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges
 *   Space Complexity: O(V)
 */
fun main() {
    var n = 4
    var arr = arrayOf(intArrayOf(1, 0), intArrayOf(2, 1), intArrayOf(3, 2))
    printArray(findOrder(n, arr))

    n = 2
    arr = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
    printArray(findOrder(n, arr))
}

// using topo sort
private fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

    // create adj list
    val adj: MutableMap<Int, MutableList<Int>> = HashMap()
    for (i in prerequisites.indices) {
        val u = prerequisites[i][0]
        val v = prerequisites[i][1]

        adj.putIfAbsent(v, ArrayList())
        adj[v]!!.add(u)
    }

    // find all inDegree
    val inDegree = IntArray(numCourses)
    for (entry in adj.entries) {
        for (node in entry.value) {
            inDegree[node]++
        }
    }

    // 0 inDegree insert into queue
    val q: Queue<Int> = LinkedList()
    for (i in 0 ..< numCourses) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    val topo = IntArray(numCourses)
    var index = 0

    while (!q.isEmpty()) {
        val front = q.remove()

        topo[index++] = front

        if (adj.containsKey(front)) {
            val neighbors = adj[front]!!
            for (neighbor in neighbors) {
                inDegree[neighbor]--
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor)
                }
            }
        }
    }

    if (index == numCourses) return topo

    return intArrayOf()
}




