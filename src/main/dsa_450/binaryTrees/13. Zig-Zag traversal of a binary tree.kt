package binaryTrees

import printArray
import java.util.*
import kotlin.collections.ArrayList

/**
 *    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *    Time complexity: O(n)
 *    Space complexity: O(n)
 */
fun main() {
    val root = TreeBuilder.buildTree()

    println("Zig-Zag Traversal")
    val result = zigzagLevelOrder(root)
    for (it in result) {
        print("[${printArray(it)}] ")
    }
}

private fun zigzagLevelOrder(root: TreeNode?): MutableList<MutableList<Int>> {

    val result: MutableList<MutableList<Int>> = ArrayList()

    if (root == null) {
        return result
    }

    val q: Queue<TreeNode> = LinkedList()
    q.add(root)

    var leftToRight = true

    while (!q.isEmpty()) {

        val size = q.size

        val ans = MutableList(size) { 0 }

        for (i in 0 ..< size) {

            val temp = q.remove()

            val index = if (leftToRight) i else size - i - 1
            ans[index] = temp.data

            if (temp.left != null) {
                q.add(temp.left)
            }
            if (temp.right != null) {
                q.add(temp.right)
            }
        }

        leftToRight = !leftToRight

        result.add(ans)
    }

    return result
}





