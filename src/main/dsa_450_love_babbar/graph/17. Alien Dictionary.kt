package graph

import java.util.*
import kotlin.math.min

/**
 *    https://www.geeksforgeeks.org/problems/alien-dictionary/1
 *    Time Complexity: O(N + K), where N is number of given words and K is number of unique characters in given alphabet
 *    Space Complexity: O(N + K)
 */
fun main() {
    var k = 4
    var arr = arrayOf("baa", "abcd", "abca", "cab", "cad")
    println(findOrder(arr, arr.size, k))

    k = 3
    arr = arrayOf("caa", "aaa", "aab")
    println(findOrder(arr, arr.size, k))
}

private fun findOrder(dict: Array<String>, n: Int, k: Int): String {
    // create adj list
    val adj: MutableList<MutableList<Int>> = ArrayList()
    for (i in 0..<k) {
        adj.add(ArrayList())
    }

    for (i in 0..<n - 1) {
        val s1 = dict[i]
        val s2 = dict[i + 1]

        val length = min(s1.length.toDouble(), s2.length.toDouble()).toInt()

        for (j in 0..<length) {
            if (s1[j] != s2[j]) {
                val u = s1[j].code - 'a'.code
                val v = s2[j].code - 'a'.code

                adj[u].add(v)

                break
            }
        }
    }

    val isCycle = checkCycleDFS(adj, k)
    if (isCycle) {
        return ""
    }

    val topoSort = topoSortBFS(adj, k)

    val result = StringBuilder()
    for (i in topoSort.indices) {
        val ch = (topoSort[i] + 'a'.code).toChar()
        result.append(ch)
        result.append(" ")
    }

    return result.toString()
}

private fun checkCycleDFS(adj: List<MutableList<Int>>, v: Int): Boolean {
    val isCycle = booleanArrayOf(false)
    val visited = IntArray(v)

    for (i in 0..<v) {
        if (visited[i] == 0) {
            cycleDFS(i, adj, visited, isCycle)
        }
    }

    return isCycle[0]
}

private fun cycleDFS(node: Int, adj: List<MutableList<Int>>, visited: IntArray, isCycle: BooleanArray) {
    // Mark visited
    visited[node] = 1

    val neighbors: List<Int> = adj[node]
    for (neighbor in neighbors) {
        if (visited[neighbor] == 1) {
            isCycle[0] = true
            return
        } else if (visited[neighbor] == 0) {
            cycleDFS(neighbor, adj, visited, isCycle)
        }
    }

    visited[node] = 2
}

private fun topoSortBFS(adj: List<List<Int>>, v: Int): List<Int> {
    // find all inDegree
    val inDegree = IntArray(v)
    for (i in 0..<v) {
        for (node in adj[i]) {
            inDegree[node]++
        }
    }

    // 0 inDegree insert into queue
    val q: Queue<Int> = LinkedList()
    for (i in 0..<v) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    val ans: MutableList<Int> = ArrayList()

    while (!q.isEmpty()) {
        val front = q.remove()

        ans.add(front)

        // down by 1 neighbors inDegree
        val neighbors = adj[front]

        for (neighbor in neighbors) {
            inDegree[neighbor]--
            if (inDegree[neighbor] == 0) {
                q.add(neighbor)
            }
        }
    }

    return ans
}

private fun topoSortDFS(adj: List<MutableList<Int>>, v: Int): List<Int> {
    val visited: MutableMap<Int, Boolean> = HashMap()
    val stack = Stack<Int>()

    for (i in 0..<v) {
        if (!visited.getOrDefault(i, false)) {
            topoDFS(i, adj, visited, stack)
        }
    }

    val topo: MutableList<Int> = ArrayList()
    while (!stack.isEmpty()) {
        topo.add(stack.pop())
    }

    return topo
}

private fun topoDFS(node: Int, adj: List<MutableList<Int>>, visited: MutableMap<Int, Boolean>, stack: Stack<Int>) {
    // mark visited
    visited[node] = true

    val neighbors: List<Int> = adj[node]
    for (neighbor in neighbors) {
        if (!visited.getOrDefault(neighbor, false)) {
            topoDFS(neighbor, adj, visited, stack)
        }
    }

    stack.push(node)
}

private fun printList(list: List<Int>) {
    val size = list.size
    print("[")
    for (i in 0..<size) {
        val ch = (list[i] + 'a'.code).toChar()
        print("$ch, ")
    }
    print("]")
    println()
}










