package binaryTrees

import printArray
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val root = TreeBuilder.buildTree()

    val ans = ArrayList<Int>()
    bottomView(root, ans)
    printArray(ans)
}

private fun bottomView(root: TreeNode?, ans: ArrayList<Int>) {
    // level order traversal
    if (root == null) {
        return
    }

    // key = horizontal distance, value = node data
    val map: MutableMap<Int, Int> = TreeMap()
    // Pair: first = node, second = horizontalDistance
    val q: Queue<Pair<TreeNode?, Int>> = LinkedList()
    q.add(Pair(root, 0))

    while (!q.isEmpty()) {
        val temp = q.remove()

        val node: TreeNode = temp.first!!
        val hd = temp.second

        map[hd] = node.data

        // left
        if (node.left != null) {
            q.add(Pair(node.left, hd - 1))
        }
        // right
        if (node.right != null) {
            q.add(Pair(node.right, hd + 1))
        }
    }

    for ((_, value) in map) {
        ans.add(value)
    }
}

