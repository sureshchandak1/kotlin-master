package lecture068_Tree_Interview_Questions_Day6

import lecture062_Tree_Introduction.TreeNode
import printArray
import java.util.*

/*
*   https://www.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1
* */
fun main() {
    val root = TreeNode(8)
    root.left = TreeNode(3)
    root.right = TreeNode(10)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(6)
    root.right!!.right = TreeNode(14)
    root.right!!.right!!.left = TreeNode(13)
    root.left!!.right!!.left = TreeNode(4)
    root.left!!.right!!.right = TreeNode(7)

    printArray(diagonalSum(root))
}

private fun diagonalSum(root: TreeNode?): ArrayList<Int> {

    val ans = ArrayList<Int>()

    if (root == null) {
        return ans
    }

    val map: MutableMap<Int, MutableList<Int>> = TreeMap()

    val q: Queue<TNode> = LinkedList()
    q.add(TNode(root, 0))

    while (!q.isEmpty()) {
        val temp = q.remove()

        val node: TreeNode? = temp.node
        val level = temp.level

        map.putIfAbsent(level, ArrayList())
        map[level]!!.add(node!!.data)

        if (node.left != null) {
            q.add(TNode(node.left, level + 1))
        }

        if (node.right != null) {
            q.add(TNode(node.right, level))
        }
    }

    for ((_, list) in map) {
        var sum = 0
        for (value in list) {
            sum += value
        }

        ans.add(sum)
    }

    return ans
}

private class TNode(node: TreeNode?, level: Int) {
    var node: TreeNode? = null
    var level: Int = 0

    init {
        this.node = node
        this.level = level
    }
}