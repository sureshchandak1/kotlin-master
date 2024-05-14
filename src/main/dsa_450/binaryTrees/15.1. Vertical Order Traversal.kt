package binaryTrees

import printArray
import java.util.*

/**
 *    https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
 *    Time Complexity: O(N log N)
 *    Space Complexity: O(N)
 */
fun main() {
    val root = TreeBuilder.buildTree()

    val map: TreeMap<Int, Vector<Int>> = TreeMap<Int, Vector<Int>>()
    getVerticalOrder(root, 0, map)
    printArray(getList(map))

    printArray(verticalOrder(root))
}

private fun verticalOrder(root: TreeNode?): ArrayList<Int> {
    val ans = ArrayList<Int>()

    if (root == null) {
        return ans
    }

    // SortedMap: key = horizontal distance, value = list
    val map: MutableMap<Int, Vector<Int>> = TreeMap()

    // Pair<node, horizontalDistance>
    val q: Queue<Pair<TreeNode?, Int>> = LinkedList()
    q.add(Pair(root, 0))

    while (!q.isEmpty()) {
        val temp = q.remove()

        val node: TreeNode = temp.first!!
        val horizontalDistance = temp.second

        map.putIfAbsent(horizontalDistance, Vector())
        map[horizontalDistance]!!.add(node.data)

        //System.out.println(node.data);
        if (node.left != null) {
            q.add(Pair(node.left, horizontalDistance - 1))
        }

        if (node.right != null) {
            q.add(Pair(node.right, horizontalDistance + 1))
        }
    }

    for ((_, list) in map) {
        for (value in list) {
            ans.add(value)
        }
    }

    return ans
}

private fun getVerticalOrder(root: TreeNode?, hd: Int, map: TreeMap<Int, Vector<Int>>) {

    // Base case
    if (root == null) return

    // Store current node in map
    map.putIfAbsent(hd, Vector())
    map[hd]!!.add(root.data)

    getVerticalOrder(root.left, hd - 1, map) // Store nodes in left subtree

    getVerticalOrder(root.right, hd + 1, map) // Store nodes in right subtree
}

private fun getList(map: MutableMap<Int, Vector<Int>>): ArrayList<Int> {
    val ans = ArrayList<Int>()

    for ((_, list) in map) {
        for (value in list) {
            ans.add(value)
        }
    }

    return ans
}











