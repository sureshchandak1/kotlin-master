package binaryTrees

import printArray
import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
 *    Time Complexity: O(N log N)
 *    Space Complexity: O(N)
 */
fun main() {
    val root = TreeBuilder.buildTree()

    println("Diagonal Traversal")
    val result = diagonal(root)
    printArray(result)
}

private fun diagonal(root: TreeNode?): ArrayList<Int> {
    val ans = ArrayList<Int>()

    if (root == null) {
        return ans
    }

    // Map: key = horizontalDistance, value = node data
    val map: MutableMap<Int, Vector<Int>> = TreeMap<Int, Vector<Int>>()

    diagonalTraversal(root, 0, map)

    for ((_, list) in map) {
        for (value in list) {
            ans.add(value)
        }
    }

    return ans
}

private fun diagonalTraversal(root: TreeNode?, hd: Int, map: MutableMap<Int, Vector<Int>>) {

    // Base case
    if (root == null) {
        return
    }

    map.putIfAbsent(hd, Vector())
    map[hd]!!.add(root.data)

    // left
    diagonalTraversal(root.left, hd + 1, map)

    // right
    diagonalTraversal(root.right, hd, map)
}

private fun diagonalTraversal(root: TreeNode?): ArrayList<Int> {
    val ans = ArrayList<Int>()

    if (root == null) {
        return ans
    }

    // Map: key = horizontalDistance, value = node data
    val map: MutableMap<Int, MutableList<Int>> = TreeMap()
    // Pair<node, horizontalDistance>
    val q: Queue<Pair<TreeNode?, Int>> = LinkedList()
    q.add(Pair(root, 0))

    while (!q.isEmpty()) {
        val temp = q.remove()

        val node: TreeNode = temp.first!!
        val horizontalDistance = temp.second

        map.putIfAbsent(horizontalDistance, ArrayList())
        map[horizontalDistance]!!.add(node.data)

        if (node.left != null) {
            q.add(Pair(node.left, horizontalDistance + 1))
        }

        if (node.right != null) {
            q.add(Pair(node.right, horizontalDistance))
        }
    }

    for ((_, list) in map) {
        for (value in list) {
            ans.add(value)
        }
    }

    return ans
}






